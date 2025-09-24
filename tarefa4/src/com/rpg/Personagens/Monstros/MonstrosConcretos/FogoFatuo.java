package com.rpg.Personagens.Monstros.MonstrosConcretos;

import com.rpg.Armas.ArmasConcretas.EspadaRunica;
import com.rpg.Personagens.Monstros.Monstro;
import com.rpg.Interfaces.Recompensa.Item;
import com.rpg.Interfaces.Combate.AcaoDeCombate;
import com.rpg.Interfaces.Combate.Combatente;
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
