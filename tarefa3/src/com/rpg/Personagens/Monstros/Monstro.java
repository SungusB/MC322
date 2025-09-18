package com.rpg.Personagens.Monstros;

import com.rpg.Personagens.Personagem;

public abstract class Monstro extends Personagem {

    public Monstro(String nome, int vidaMaxima, int danoAtaque, int velocidade, double percentualDefesa) {
        super(nome, vidaMaxima, danoAtaque, velocidade, percentualDefesa);
    }
}