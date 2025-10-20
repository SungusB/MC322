package com.rpg.personagens.Monstros.MonstrosConcretos;

import com.rpg.itens.ArmasConcretas.EspadaRunica;
import com.rpg.personagens.Monstros.Monstro;
import com.rpg.itens.Item;
import com.rpg.combate.AcaoDeCombate;
import com.rpg.combate.Combatente;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Monstro concreto: Fogo Fátuo. Um monstro rápido focado em ataque e esquiva.
 */
public class FogoFatuo extends Monstro 
{
    /**
     * Construtor para FogoFatuo.
     * Define as estatísticas base (Vida 300, Dano 80, Vel 70, Def 0.1, XP 50).
     */
    public FogoFatuo() {
        // super(nome, vida, dano, vel, def, xp)
        super("Fogo Fátuo", 300, 80, 70, 0.1, 50);
    }

    /**
     * Implementa a lógica de drop de loot.
     * Tem 20% de chance de dropar uma Espada Rúnica.
     * @return Uma lista de Itens. Pode ser vazia.
     */
    //20% chance drop espada runica
    @Override
    public List<Item> droparLoot() {
        List<Item> loot = new ArrayList<>();
        Random random = new Random();

        if (random.nextInt(100) < 20) { // 20% de chance
            loot.add(new EspadaRunica());
            System.out.println(this.nome + " dropou uma Espada Rúnica!");
        }

        return loot;
    }

    /**
     * Define a inteligência artificial de combate do Fogo Fátuo.
     * Escolhe entre Ataque Básico (posição 0) e Esquiva (posição 2) com 50% de chance para cada.
     * @param alvo O combatente alvo da ação.
     * @return A ação de combate escolhida.
     */
    //So ataca e esquiva (e um fantasma)
    @Override
    public AcaoDeCombate escolherAcao(Combatente alvo) 
    {
        List<AcaoDeCombate> acoes = getAcoesDisponiveis();
        Random random = new Random();

        if (random.nextBoolean()) 
        { // 50% de chance
            return acoes.get(0); // AtaqueFisico
        } 

        else 
        { // 50% de chance
            return acoes.get(2); // Esquiva
        }
    }
}