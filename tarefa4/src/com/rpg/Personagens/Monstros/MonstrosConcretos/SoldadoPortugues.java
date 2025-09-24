package com.rpg.Personagens.Monstros.MonstrosConcretos;

import com.rpg.Interfaces.Recompensa.Item;
import com.rpg.Interfaces.Combate.AcaoDeCombate;
import com.rpg.Interfaces.Combate.Combatente;
import com.rpg.Personagens.Monstros.Monstro;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SoldadoPortugues extends Monstro {

    public SoldadoPortugues() {
        super("Soldado Português", 500, 100, 30, 0.3, 75);
    }

    @Override
    public List<Item> droparLoot() {
        // Nao dropa itens
        return new ArrayList<>();
    }

    @Override
    public AcaoDeCombate escolherAcao(Combatente alvo) {
        List<AcaoDeCombate> acoes = getAcoesDisponiveis();
        int escolha = new Random().nextInt(3); // 0, 1, or 2
        return acoes.get(escolha);
    }
}