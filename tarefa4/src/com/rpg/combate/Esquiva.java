package com.rpg.combate;

import com.rpg.personagens.Personagem;
import com.rpg.combate.AcaoDeCombate;
import com.rpg.combate.Combatente;

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