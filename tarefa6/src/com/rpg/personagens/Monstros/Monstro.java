package com.rpg.personagens.Monstros;

import com.rpg.itens.Item;
import com.rpg.itens.Lootavel;
import com.rpg.combate.AcaoDeCombate;
import com.rpg.personagens.Personagem;
import com.rpg.cenario.Dificuldade;
import com.rpg.combate.AtaqueFisico;
import com.rpg.personagens.Monstros.MonstrosConcretos.*;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.bind.annotation.XmlTransient;

import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso({Zumbi.class, Lobisomem.class, SoldadoPortugues.class, SoldadoPortuguesElite.class, FogoFatuo.class})
public abstract class Monstro extends Personagem implements Lootavel 
{
    protected int xpRecompensa;

    public static final AtaqueFisico ATAQUE_BASICO = new AtaqueFisico();

    @XmlTransient
    protected List<Class<? extends Item>> itensDropaveis = new ArrayList<>();

    public Monstro() { super(); }

    public Monstro(String nome, int vidaMaxima, int danoAtaque, int velocidade, double percentualDefesa, int xpRecompensa)
    {
        super(nome, vidaMaxima, danoAtaque, velocidade, percentualDefesa);
        this.xpRecompensa = xpRecompensa;
    }

    @Override
    protected AcaoDeCombate gerarAtaqueBasico() {
        return ATAQUE_BASICO;
    }

    public void aplicarDificuldade(Dificuldade dificuldade) 
    {
        this.vidaMaxima = (int) Math.round(this.vidaMaxima * dificuldade.getVidaMultiplicador());
        this.vidaAtual = this.vidaMaxima;
        this.danoAtaque = (int) Math.round(this.danoAtaque * dificuldade.getDanoMultiplicador());
        this.xpRecompensa = (int) Math.round(this.xpRecompensa * dificuldade.getVidaMultiplicador());
    }

    public int getXpRecompensa() { return this.xpRecompensa; }

    @Override
    public abstract List<Item> droparLoot();

    @Override
    protected List<AcaoDeCombate> getAcoesUnicas() {
        return new ArrayList<>();
    }
    
    @Override
    public int getAtaque() {
        return this.danoAtaque; 
    }

    @Override
    public int getDefesa() {
        return 0; 
    }
}