package com.rpg.Ambiente;

import com.rpg.Interfaces.Mundo.Fase;
import com.rpg.Personagens.Herois.Heroi;
import com.rpg.Personagens.Monstros.Monstro;
import com.rpg.Ambiente.TipoCenario;
import java.util.List;
import java.util.spi.TimeZoneNameProvider;


public abstract class FaseDeCombate implements Fase 
{
    protected String nome;
    protected String descricao;
    protected TipoCenario cenario;
    protected List<Monstro> monstros;
    protected Heroi heroi;
    protected boolean concluida = false;

    public FaseDeCombate(String nome, TipoCenario cenario, List<Monstro> monstros) 
    {
        this.nome = nome;
        this.cenario = cenario;
        this.monstros = monstros;
    }

    

    @Override
    public String getTipoDeCenario() 
    {
        return this.descricao;
    }

    @Override
    public boolean isConcluida() 
    {
        return this.concluida;
    }

    @Override
    public abstract void iniciar(Heroi heroi);
}