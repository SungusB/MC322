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
 * Monstro concreto: Lobisomem. Boss que dropa Machado Lunar.
 */
public class Lobisomem extends Monstro 
{
    public Lobisomem() 
    {
        super("Lobisomem", 2000, 180, 50, 0.5, 500);
        
        this.itensDropaveis.add(MachadoLunar.class);
    }

    @Override
    public List<Item> droparLoot() 
    {
        List<Item> loot = new ArrayList<>();
        
        for (Class<? extends Item> classeItem : this.itensDropaveis) {
            try {
                Item item = classeItem.getDeclaredConstructor().newInstance();
                loot.add(item);
                System.out.println(this.nome + " dropou um " + item.getNome() + "!");
            } catch (Exception e) {
                System.err.println("Erro ao gerar loot do Lobisomem: " + e.getMessage());
            }
        }
        return loot;
    }

    @Override
    public AcaoDeCombate escolherAcao(Combatente alvo) {
        List<AcaoDeCombate> acoes = getAcoesDisponiveis();
        int chance = new Random().nextInt(100);

        if (chance < 60) 
        {     
            return acoes.get(0); // Ataque
        } 
        else 
        { 
            return acoes.get(1); // Defesa
        }
    }
}