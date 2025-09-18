package com.rpg.Personagens;
import com.rpg.Interfaces.Combate.AcaoDeCombate;
import com.rpg.Interfaces.Combate.Combatente;
import com.rpg.Armas.Arma;
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
    protected int nivel;
    protected int xp;

    public Personagem(String nome, int vidaMaxima, int danoAtaque, int velocidade, double percentualDefesa) {
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

    @Override
    public void receberDano(int dano)
    {
        this.vidaAtual -= dano;
        if (this.vidaAtual < 0)
        {
            this.vidaAtual = 0;
        }
        System.out.println(this.nome " agora tem " this.vidaAtual + "/" + this.vidaMaxima + " de vida.");
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

    @Override
    public AcaoDeCombate escolherAcao(Combatente alvo)
    {
        List<AcaoDeCombate> acoes = getAcoesDisponiveis();
        double percentualDeVida = (double) this.vidaAtual/this.vidaMaxima;

        if(percentualDeVida < 0.25)
        {
            System.out.println(this.nome + "Esta com pouca vida.");
        }

        return acoes.get(new Random.nextInt(acoes.size()));
    }

    public abstract List<AcaoDeCombate> getAcoesDisponiveis();
}