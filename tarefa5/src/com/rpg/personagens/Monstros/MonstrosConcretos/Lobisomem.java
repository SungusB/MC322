package com.rpg.personagens.Monstros.MonstrosConcretos;

import com.rpg.itens.ArmasConcretas.MachadoLunar;
import com.rpg.itens.Item;
import com.rpg.combate.AcaoDeCombate;
import com.rpg.combate.Combatente;
import com.rpg.personagens.Monstros.Monstro;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Monstro concreto: Lobisomem. Um chefe com alta vida e recompensa de XP.
 * Dropa o Machado Lunar (100% de chance).
 */
public class Lobisomem extends Monstro 
{

    /**
     * Construtor para Lobisomem.
     * Define as estatísticas base (Boss: Vida 2000, Dano 180, Vel 50, Def 0.5, XP 500).
     */
    public Lobisomem() 
    {
        // super(nome, vida, dano, vel, def, xp) - Boss
        super("Lobisomem", 2000, 180, 50, 0.5, 500);
    }

    /**
     * Implementa a lógica de drop de loot.
     * Garante 100% de chance de dropar um Machado Lunar.
     * @return Uma lista contendo o item droppado.
     */
    @Override
    public List<Item> droparLoot() 
    {
        List<Item> loot = new ArrayList<>();
        // 100% de chance de dropar o Machado Lunar
        loot.add(new MachadoLunar());
        System.out.println(this.nome + " dropou um Machado Lunar!");
        return loot;
    }

    /**
     * Define a inteligência artificial de combate do Lobisomem.
     * Ação: 60% de chance de Ataque Básico, 40% de chance de Defesa.
     * @param alvo O combatente alvo da ação.
     * @return A ação de combate escolhida.
     */
    // 60% Ataque, 40% Defesa
    @Override
    public AcaoDeCombate escolherAcao(Combatente alvo) {
        List<AcaoDeCombate> acoes = getAcoesDisponiveis();
        int chance = new Random().nextInt(100);

        if (chance < 60) 
        {     
            return acoes.get(0); 
        } 
        else 
        { // 40% de chance
            return acoes.get(1); 
        }
    }
}