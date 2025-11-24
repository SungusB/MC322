package com.rpg.personagens.Monstros.MonstrosConcretos;

import com.rpg.itens.ArmasConcretas.AdagaLusiada; 
import com.rpg.itens.Item;
import com.rpg.combate.AcaoDeCombate;
import com.rpg.combate.Combatente;
import com.rpg.personagens.Monstros.Monstro;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Monstro concreto: Soldado Português de Elite. 
 */
public class SoldadoPortuguesElite extends Monstro {

    public SoldadoPortuguesElite() 
    {
        super("Soldado Português de Elite", 800, 130, 40, 0.4, 150);
        
        this.itensDropaveis.add(AdagaLusiada.class);
    }

    @Override
    public List<Item> droparLoot() 
    {
        List<Item> loot = new ArrayList<>();
        
        for (Class<? extends Item> classeItem : this.itensDropaveis) {
            try {
                Item item = classeItem.getDeclaredConstructor().newInstance();
                loot.add(item);
                System.out.println(this.nome + " dropou uma " + item.getNome() + "!");
            } catch (Exception e) {
                System.err.println("Erro ao gerar loot do Soldado Elite: " + e.getMessage());
                e.printStackTrace();
            }
        }
        return loot;
    }

    @Override
    public AcaoDeCombate escolherAcao(Combatente alvo) 
    {
        List<AcaoDeCombate> acoes = getAcoesDisponiveis();
        int escolha = new Random().nextInt(3); 
        return acoes.get(escolha);
    }
}