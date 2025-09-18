package com.rpg.Armas;

public abstract class Arma
{
    protected String nome;
    protected int nivelReq;

    public Arma(String nome, int nivelReq)
    {
        this.nome=nome;
        this.nivelReq=nivelReq;
    }

    public String getNome()
    {
        return nome;
    }

    public int getNivelReq()
    {
        return nivelReq;
    }

    public abstract int getBonusDano();
    public abstract int getBonusVelocidade();
    public abstract int getBonusVidaMaxima();
}