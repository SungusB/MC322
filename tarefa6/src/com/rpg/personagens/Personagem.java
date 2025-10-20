package com.rpg.personagens;

import com.rpg.combate.AcaoDeCombate;
import com.rpg.combate.Combatente;
import com.rpg.combate.Defesa;
import com.rpg.combate.Esquiva;
import com.rpg.combate.AtaqueFisico;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Classe base abstrata para todos os personagens (Heróis e Monstros).
 * Implementa a interface Combatente.
 */
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

    /**
     * Construtor para criar um novo Personagem.
     * @param nome O nome do personagem.
     * @param vidaMaxima O valor máximo de pontos de vida.
     * @param danoAtaque O dano base de ataque físico.
     * @param velocidade O valor de velocidade, que influencia a ordem de ataque e esquiva.
     * @param percentualDefesa O percentual de redução de dano ao defender (ex: 0.3 para 30%).
     */
    public Personagem(String nome, int vidaMaxima, int danoAtaque, int velocidade, double percentualDefesa) 
    {
        this.nome = nome;
        this.vidaMaxima = vidaMaxima;
        this.vidaAtual = vidaMaxima;
        this.danoAtaque = danoAtaque;
        this.velocidade = velocidade;
        this.percentualDefesa = percentualDefesa;
    }

    /**
     * @return O nome do personagem.
     */
    @Override
    public String getNome()
    {
        return this.nome;
    }

    /**
     * @return {@code true} se o personagem tem vida restante, {@code false} caso contrário.
     */
    @Override
    public boolean estaVivo()
    {
        return this.vidaAtual > 0;
    }

    /**
     * Define se o personagem está no estado de defesa para o próximo turno.
     * @param estado {@code true} para ativar a defesa, {@code false} para desativar.
     */
    public void setEstadoDeDefesa(boolean estado)
    {
        this.estaDefendendo = estado;
    }

    /**
     * Define se o personagem está no estado de esquiva para o próximo turno.
     * @param estado {@code true} para ativar a esquiva, {@code false} para desativar.
     */
    public void setEstadoDeEsquiva(boolean estado)
    {
        this.estaEsquivando = estado;
    }

    /**
     * Reseta os estados de defesa e esquiva no início do turno.
     */
    public void prepararProximoTurno()
    {
        this.estaDefendendo = false;
        this.estaEsquivando = false;
    }

    
    /**
     * Processa o recebimento de dano. Considera esquiva (com chance baseada na velocidade) 
     * e estado de defesa para calcular a redução final do dano.
     * Se a esquiva for bem-sucedida, o dano é cancelado e o personagem é curado em metade do dano.
     * @param dano O valor do dano base a ser recebido.
     */
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

    /**
     * Aplica cura ao personagem. A vida atual não pode ultrapassar a vida máxima.
     * @param cura A quantidade de pontos de vida a ser restaurada.
     */
    @Override
    public void receberCura(int cura)
    {
        this.vidaAtual += cura;
        if (this.vidaAtual > this.vidaMaxima)
        {
            this.vidaAtual = this.vidaMaxima;
        }
    }

    /**
     * Retorna a lista de ações de combate disponíveis para o personagem (Ataque, Defesa, Esquiva + Ações Únicas).
     * @return Uma lista imutável de AcaoDeCombate.
     */
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

    /**
     * Retorna as ações de combate exclusivas de cada subclasse (como habilidades especiais).
     * @return Uma lista de AcaoDeCombate.
     */
    protected abstract List<AcaoDeCombate> getAcoesUnicas();

    /**
     * @return O valor de dano de ataque base do personagem.
     */
    public int getDanoAtaque() {return this.danoAtaque;}
    
    /**
     * @return O valor de velocidade base do personagem.
     */
    public int getVelocidade() {return this.velocidade;}
    
    /**
     * @return O valor da vida máxima base do personagem.
     */
    public int getVidaMaxima() {return this.vidaMaxima;}
}