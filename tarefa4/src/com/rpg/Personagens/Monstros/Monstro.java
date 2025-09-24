package com.rpg.Personagens.Monstros;

import com.rpg.Interfaces.Recompensa.Item;
import com.rpg.Interfaces.Recompensa.Lootavel;
import com.rpg.Interfaces.Combate.AcaoDeCombate;
import com.rpg.Personagens.Personagem;
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