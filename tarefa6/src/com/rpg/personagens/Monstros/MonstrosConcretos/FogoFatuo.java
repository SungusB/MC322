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
 * Monstro concreto: Fogo Fátuo.
 */
public class FogoFatuo extends Monstro 
{
    public FogoFatuo() {
        super("Fogo Fátuo", 300, 80, 70, 0.1, 50);
        
        this.itensDropaveis.add(EspadaRunica.class);
    }

    @Override
    public List<Item> droparLoot() {
        List<Item> loot = new ArrayList<>();
        Random random = new Random();

        // 20% de chance de drop
        if (random.nextInt(100) < 20) { 
            
            if (!this.itensDropaveis.isEmpty()) {
                try {
                    Class<? extends Item> classeItem = this.itensDropaveis.get(0);
                    Item item = classeItem.getDeclaredConstructor().newInstance();
                    
                    loot.add(item);
                    System.out.println(this.nome + " dropou uma " + item.getNome() + "!");
                } catch (Exception e) {
                    System.err.println("Erro ao gerar loot do Fogo Fatuo: " + e.getMessage());
                }
            }
        }

        return loot;
    }

    @Override
    public AcaoDeCombate escolherAcao(Combatente alvo) 
    {
        List<AcaoDeCombate> acoes = getAcoesDisponiveis();
        Random random = new Random();

        if (random.nextBoolean()) 
        { 
            return acoes.get(0); // Ataque
        } 
        else 
        { 
            return acoes.get(2); // Esquiva
        }
    }
}