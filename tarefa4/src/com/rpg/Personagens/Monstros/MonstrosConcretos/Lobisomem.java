package com.rpg.Personagens.Monstros.MonstrosConcretos;

import com.rpg.Armas.ArmasConcretas.MachadoLunar;
import com.rpg.Interfaces.Recompensa.Item;
import com.rpg.Interfaces.Combate.AcaoDeCombate;
import com.rpg.Interfaces.Combate.Combatente;
import com.rpg.Personagens.Monstros.Monstro;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Lobisomem extends Monstro 
{

    public Lobisomem() 
    {
        // super(nome, vida, dano, vel, def, xp) - Boss
        super("Lobisomem", 2000, 180, 50, 0.5, 500);
    }

    @Override
    public List<Item> droparLoot() 
    {
        List<Item> loot = new ArrayList<>();
        // 100% de chance de dropar o Machado Lunar
        loot.add(new MachadoLunar());
        System.out.println(this.nome + " dropou um Machado Lunar!");
        return loot;
    }

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