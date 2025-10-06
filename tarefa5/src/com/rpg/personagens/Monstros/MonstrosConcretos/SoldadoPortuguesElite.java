package com.rpg.personagens.Monstros.MonstrosConcretos;

import com.rpg.itens.ArmasConcretas.AdagaLusiada; // Importa a arma correta
import com.rpg.itens.Item;
import com.rpg.combate.AcaoDeCombate;
import com.rpg.combate.Combatente;
import com.rpg.personagens.Monstros.Monstro;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Monstro concreto: Soldado Português de Elite. 
 * Uma versão mais forte do Soldado Português.
 * Dropa a Adaga Lusíada (100% de chance).
 */
public class SoldadoPortuguesElite extends Monstro {

    /**
     * Construtor para SoldadoPortuguesElite.
     * Define as estatísticas base (Vida 800, Dano 130, Vel 40, Def 0.4, XP 150).
     */
    public SoldadoPortuguesElite() 
    {
        super("Soldado Português de Elite", 800, 130, 40, 0.4, 150);
    }

    /**
     * Implementa a lógica de drop de loot.
     * Garante 100% de chance de dropar uma Adaga Lusíada.
     * @return Uma lista contendo o item droppado.
     */
    @Override
    public List<Item> droparLoot() 
    {
        List<Item> loot = new ArrayList<>();
        // Drop 100% garantido da Adaga Lusiada.
        loot.add(new AdagaLusiada());
        System.out.println(this.nome + " dropou uma Adaga Lusiada!");
        return loot;
    }

    /**
     * Define a inteligência artificial de combate do Soldado de Elite.
     * Escolhe aleatoriamente entre Ataque, Defesa e Esquiva (1/3 de chance para cada).
     * @param alvo O combatente alvo da ação.
     * @return A ação de combate escolhida.
     */
    @Override
    public AcaoDeCombate escolherAcao(Combatente alvo) 
    {
        List<AcaoDeCombate> acoes = getAcoesDisponiveis();
        int escolha = new Random().nextInt(3); // 1/3 de chance de cada acao
        return acoes.get(escolha);
    }
}