package com.rpg.personagens.Monstros.MonstrosConcretos;

import com.rpg.itens.ArmasConcretas.EspadaRunica;
import com.rpg.personagens.Monstros.Monstro;
import com.rpg.itens.Item;
import com.rpg.combate.AcaoDeCombate;
import com.rpg.combate.Combatente;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FogoFatuo extends Monstro 
{
    public FogoFatuo() {
        // super(nome, vida, dano, vel, def, xp)
        super("Fogo Fátuo", 300, 80, 70, 0.1, 50);
    }

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

    //So ataca e esquiva (e um fantasma)
    @Override
    public AcaoDeCombate escolherAcao(Combatente alvo) 
    {
        List<AcaoDeCombate> acoes = getAcoesDisponiveis();
        Random random = new Random();

        if (random.nextBoolean()) 
        { // 50% de chance
            return acoes.get(0);
        } 

        else 
        { // 50% de chance
            return acoes.get(2);
        }
    }
}
