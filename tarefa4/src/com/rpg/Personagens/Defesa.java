package com.rpg.Personagens;

import com.rpg.Interfaces.Combate.Combatente;
import com.rpg.Interfaces.Combate.AcaoDeCombate;

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