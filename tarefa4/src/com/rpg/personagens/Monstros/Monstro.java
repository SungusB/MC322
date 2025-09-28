package com.rpg.personagens.Monstros;

import com.rpg.itens.Item;
import com.rpg.itens.Lootavel;
import com.rpg.combate.AcaoDeCombate;
import com.rpg.personagens.Personagem;
import com.rpg.cenario.Dificuldade;

import java.util.ArrayList;
import java.util.List;

public abstract class Monstro extends Personagem implements Lootavel 
{
    protected int xpRecompensa;

    public Monstro(String nome, int vidaMaxima, int danoAtaque, int velocidade, double percentualDefesa, int xpRecompensa)
    {
        super(nome, vidaMaxima, danoAtaque, velocidade, percentualDefesa);
        this.xpRecompensa = xpRecompensa;
    }

    public void aplicarDificuldade(Dificuldade dificuldade) 
    {
        this.vidaMaxima = (int) Math.round(this.vidaMaxima * dificuldade.getVidaMultiplicador());
        this.vidaAtual = this.vidaMaxima;
        this.danoAtaque = (int) Math.round(this.danoAtaque * dificuldade.getDanoMultiplicador());

        this.xpRecompensa = (int) Math.round(this.xpRecompensa * dificuldade.getVidaMultiplicador());
    }

    public int getXpRecompensa() 
    {
        return this.xpRecompensa;
    }

    @Override
    public abstract List<Item> droparLoot();

    @Override
    protected List<AcaoDeCombate> getAcoesUnicas() 
    {
        return new ArrayList<>();
    }
}
