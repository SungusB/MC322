package com.rpg.combate;

import com.rpg.personagens.Personagem;
import com.rpg.combate.Combatente;
import com.rpg.combate.AcaoDeCombate;

public class Defesa implements AcaoDeCombate 
{

    public Defesa(double percentualDefesa) {}

    @Override
    public void executar(Combatente usuario, Combatente alvo) {
        System.out.println(usuario.getNome() + " está se defendendo.");
        if (usuario instanceof Personagem) 
        {
            ((Personagem) usuario).setEstadoDeDefesa(true);
        }
    }
}