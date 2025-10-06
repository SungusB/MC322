package com.rpg.personagens.Monstros;

import com.rpg.itens.Item;
import com.rpg.itens.Lootavel;
import com.rpg.combate.AcaoDeCombate;
import com.rpg.personagens.Personagem;
import com.rpg.cenario.Dificuldade;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe base abstrata para todos os Monstros.
 * Implementa a interface Lootavel para recompensas.
 */
public abstract class Monstro extends Personagem implements Lootavel 
{
    protected int xpRecompensa;

    /**
     * Construtor para criar um novo Monstro.
     * @param nome O nome do monstro.
     * @param vidaMaxima O valor máximo de pontos de vida.
     * @param danoAtaque O dano base de ataque físico.
     * @param velocidade O valor de velocidade.
     * @param percentualDefesa O percentual de redução de dano ao defender.
     * @param xpRecompensa A quantidade base de XP concedida ao derrotar este monstro.
     */
    public Monstro(String nome, int vidaMaxima, int danoAtaque, int velocidade, double percentualDefesa, int xpRecompensa)
    {
        super(nome, vidaMaxima, danoAtaque, velocidade, percentualDefesa);
        this.xpRecompensa = xpRecompensa;
    }

    /**
     * Aplica os modificadores de dificuldade (Vida, Dano, XP) ao monstro.
     * @param dificuldade O nível de dificuldade do jogo.
     */
    public void aplicarDificuldade(Dificuldade dificuldade) 
    {
        this.vidaMaxima = (int) Math.round(this.vidaMaxima * dificuldade.getVidaMultiplicador());
        this.vidaAtual = this.vidaMaxima;
        this.danoAtaque = (int) Math.round(this.danoAtaque * dificuldade.getDanoMultiplicador());

        this.xpRecompensa = (int) Math.round(this.xpRecompensa * dificuldade.getVidaMultiplicador());
    }

    /**
     * Retorna a quantidade de XP que o monstro concede ao ser derrotado.
     * @return A recompensa de XP.
     */
    public int getXpRecompensa() 
    {
        return this.xpRecompensa;
    }

    /**
     * Implementa a lógica para o monstro dropar itens ao ser derrotado.
     * @return Uma lista de itens que são o loot do monstro.
     */
    @Override
    public abstract List<Item> droparLoot();

    /**
     * Monstros não possuem ações únicas por padrão, mas o método é necessário para a herança.
     * @return Uma lista vazia de AcaoDeCombate.
     */
    @Override
    protected List<AcaoDeCombate> getAcoesUnicas() 
    {
        return new ArrayList<>();
    }
}