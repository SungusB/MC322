package com.rpg.personagens;

import com.rpg.combate.AcaoDeCombate;
import com.rpg.combate.Combatente;
import com.rpg.combate.Defesa;
import com.rpg.combate.Esquiva;
import com.rpg.combate.AtaqueFisico;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
    public String getNome()
    {
        return this.nome;
    }

    @Override
    public boolean estaVivo()
    {
        return this.vidaAtual > 0;
    }

    public void setEstadoDeDefesa(boolean estado)
    {
        this.estaDefendendo = estado;
    }
    public void setEstadoDeEsquiva(boolean estado)
    {
        this.estaEsquivando = estado;
    }

    public void prepararProximoTurno()
    {
        this.estaDefendendo = false;
        this.estaDefendendo = false;
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
                return; // 0 dano
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
        if (this.vidaAtual > this.vidaMaxima)
        {
            this.vidaAtual = this.vidaMaxima;
        }
    }

    public final List<AcaoDeCombate> getAcoesDisponiveis() 
    {
        List<AcaoDeCombate> acoes = new ArrayList<>();

        acoes.add(new AtaqueFisico(this.getDanoAtaque()));
        acoes.add(new Defesa(this.percentualDefesa));
        acoes.add(new Esquiva(this.getVelocidade()));

        List<AcaoDeCombate> acoesUnicas = getAcoesUnicas();
        acoes.addAll(acoesUnicas);

        return acoes;
    }

    protected abstract List<AcaoDeCombate> getAcoesUnicas();

    public int getDanoAtaque() {return this.danoAtaque;}
    public int getVelocidade() {return this.velocidade;}
    public int getVidaMaxima() {return this.vidaMaxima;}
}