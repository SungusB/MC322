package com.rpg.combate;

import com.rpg.exceptions.AtaqueCriticoException;
import java.util.Random;

public class AtaqueFisico implements AcaoDeCombate {

    public AtaqueFisico() {
    }

    @Override
    public void executar(Combatente usuario, Combatente alvo) {
        
        if (new Random().nextDouble() < 0.2) {
            throw new AtaqueCriticoException("CRÍTICO! " + usuario.getNome() + " desferiu um golpe devastador!");
        }

        int danoCalculado = usuario.getAtaque() - alvo.getDefesa();

        if (danoCalculado < 0) danoCalculado = 0;

        System.out.println(usuario.getNome() + " atacou " + alvo.getNome() + "!");
        
        if (danoCalculado > 0) {
            alvo.receberDano(danoCalculado);
        } else {
            System.out.println("O ataque não foi forte o suficiente para passar a defesa.");
        }
    }
}