package com.rpg.personagens.Monstros.MonstrosConcretos;

import com.rpg.itens.Item;
import com.rpg.combate.AcaoDeCombate;
import com.rpg.combate.Combatente;
import com.rpg.personagens.Monstros.Monstro;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Monstro concreto: Soldado Português. Um inimigo comum e versátil.
 * Não dropa itens.
 */
public class SoldadoPortugues extends Monstro {

    /**
     * Construtor para SoldadoPortugues.
     * Define as estatísticas base (Vida 500, Dano 100, Vel 30, Def 0.3, XP 75).
     */
    public SoldadoPortugues() {
        super("Soldado Português", 500, 100, 30, 0.3, 75);
    }

    /**
     * Implementa a lógica de drop de loot.
     * Soldados Portugueses comuns não dropam itens, retornando uma lista vazia.
     * @return Uma lista vazia de Itens.
     */
    @Override
    public List<Item> droparLoot() {
        // Nao dropa itens
        return new ArrayList<>();
    }

    /**
     * Define a inteligência artificial de combate do Soldado Português.
     * Escolhe aleatoriamente entre Ataque, Defesa e Esquiva (1/3 de chance para cada).
     * @param alvo O combatente alvo da ação.
     * @return A ação de combate escolhida.
     */
    @Override
    public AcaoDeCombate escolherAcao(Combatente alvo) {
        List<AcaoDeCombate> acoes = getAcoesDisponiveis();
        int escolha = new Random().nextInt(3); // 0, 1, or 2
        return acoes.get(escolha);
    }
}