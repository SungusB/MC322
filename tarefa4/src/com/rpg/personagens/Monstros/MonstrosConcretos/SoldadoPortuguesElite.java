package com.rpg.personagens.Monstros.MonstrosConcretos;

import com.rpg.itens.ArmasConcretas.AdagaLusiada; // Importa a arma correta
import com.rpg.itens.Item;
import com.rpg.combate.AcaoDeCombate;
import com.rpg.combate.Combatente;
import com.rpg.personagens.Monstros.Monstro;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SoldadoPortuguesElite extends Monstro {

    public SoldadoPortuguesElite() 
    {
        super("Soldado Português de Elite", 800, 130, 40, 0.4, 150);
    }

    @Override
    public List<Item> droparLoot() 
    {
        List<Item> loot = new ArrayList<>();
        // Drop 100% garantido da Adaga Lusiada.
        loot.add(new AdagaLusiada());
        System.out.println(this.nome + " dropou uma Adaga Lusiada!");
        return loot;
    }

    @Override
    public AcaoDeCombate escolherAcao(Combatente alvo) 
    {
        List<AcaoDeCombate> acoes = getAcoesDisponiveis();
        int escolha = new Random().nextInt(3); // 1/3 de chance de cada acao
        return acoes.get(escolha);
    }
}