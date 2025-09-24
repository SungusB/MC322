package com.rpg.Personagens;

import com.rpg.Interfaces.Combate.AcaoDeCombate;
import com.rpg.Interfaces.Combate.Combatente;

public class Esquiva implements AcaoDeCombate 
{
    public Esquiva(int velocidade) 
    {}

    @Override
    public void executar(Combatente usuario, Combatente alvo) 
    {
        System.out.println(usuario.getNome() + " prepara esquiva.");
        if (usuario instanceof Personagem) 
        {
            ((Personagem) usuario).setEstadoDeEsquiva(true);
        }
    }
}