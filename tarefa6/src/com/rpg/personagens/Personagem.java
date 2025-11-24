package com.rpg.personagens;

import com.rpg.combate.AcaoDeCombate;
import com.rpg.combate.Combatente;
import com.rpg.combate.Defesa;
import com.rpg.combate.Esquiva;
import com.rpg.combate.AtaqueFisico;
import com.rpg.personagens.Herois.Heroi;
import com.rpg.personagens.Monstros.Monstro;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.bind.annotation.XmlTransient;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Classe base abstrata para todos os personagens (Heróis e Monstros).
 * Gerencia vida, atributos básicos e ações comuns.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso({Heroi.class, Monstro.class}) 
public abstract class Personagem implements Combatente
{
    protected String nome;
    protected int vidaMaxima;
    protected int vidaAtual;
    protected int danoAtaque;
    protected int velocidade;
    protected double percentualDefesa;
    
    protected boolean estaDefendendo = false;
    protected boolean estaEsquivando = false;

    @XmlTransient 
    protected List<AcaoDeCombate> acoesDisponiveis = new ArrayList<>();

    public Personagem() {}

    public Personagem(String nome, int vidaMaxima, int danoAtaque, int velocidade, double percentualDefesa) 
    {
        this.nome = nome;
        this.vidaMaxima = vidaMaxima;
        this.vidaAtual = vidaMaxima;
        this.danoAtaque = danoAtaque;
        this.velocidade = velocidade;
        this.percentualDefesa = percentualDefesa;
    }

    @Override
    public String getNome() { return this.nome; }

    @Override
    public boolean estaVivo() { return this.vidaAtual > 0; }

    public void setEstadoDeDefesa(boolean estado) { this.estaDefendendo = estado; }

    public void setEstadoDeEsquiva(boolean estado) { this.estaEsquivando = estado; }

    public void prepararProximoTurno()
    {
        this.estaDefendendo = false;
        this.estaEsquivando = false;
    }

    @Override
    public void receberDano(int dano) 
    {
        if (this.estaEsquivando) 
        {
            double chanceDeEsquiva = Math.min(this.getVelocidade() / 2.0, 67.0);
            if (new Random().nextDouble() * 100 < chanceDeEsquiva) 
            {
                System.out.println(this.nome + " se esquivou do ataque!");
                receberCura(dano/2);
                return; 
            }
        }

        int danoFinal = dano;
        if (this.estaDefendendo) 
        {
            danoFinal = (int) (dano * (1.0 - this.percentualDefesa));
            System.out.println(this.nome + " defendeu e reduziu o dano!");
        }

        this.vidaAtual -= danoFinal;
        if (this.vidaAtual < 0) this.vidaAtual = 0;
        System.out.println(this.nome + " recebeu " + danoFinal + " de dano e tem "
                           + this.vidaAtual + "/" + this.vidaMaxima + " de vida.");
    }

    @Override
    public void receberCura(int cura)
    {
        this.vidaAtual += cura;
        if (this.vidaAtual > this.vidaMaxima) {
            this.vidaAtual = this.vidaMaxima;
        }
    }

    /**
     * Retorna a lista de ações. Se estiver vazia (após carregar jogo), recria as ações padrão.
     */
    public final List<AcaoDeCombate> getAcoesDisponiveis() 
    {
        if (acoesDisponiveis.isEmpty()) {
            acoesDisponiveis.add(gerarAtaqueBasico()); 
            acoesDisponiveis.add(new Defesa(this.percentualDefesa));
            acoesDisponiveis.add(new Esquiva(this.getVelocidade()));
            acoesDisponiveis.addAll(getAcoesUnicas());
        }
        return acoesDisponiveis;
    }

    protected AcaoDeCombate gerarAtaqueBasico() {
        return new AtaqueFisico(); 
    }

    protected abstract List<AcaoDeCombate> getAcoesUnicas();

    public int getDanoAtaque() {return this.danoAtaque;}
    public int getVelocidade() {return this.velocidade;}
    public int getVidaMaxima() {return this.vidaMaxima;}

    @Override
    public void prepararDefesa() { this.setEstadoDeDefesa(true); }

    @Override
    public void prepararEsquiva() { this.setEstadoDeEsquiva(true); }

    @Override
    public int getAtaque() { return this.danoAtaque; }

    @Override
    public abstract int getDefesa();
}