package com.rpg.personagens.Herois.HeroisConcretos.Hunter;

import com.rpg.combate.AcaoDeCombate;
import com.rpg.combate.Combatente;

public class AtaqueDeRaiva implements AcaoDeCombate
{
    private final int danoBase;

    public AtaqueDeRaiva(int danoBase)
    {
        this.danoBase = danoBase;
    }

    @Override
    public void executar(Combatente usuario, Combatente alvo)
    {
        int danoFinal = this.danoBase * 2;
        System.out.println(usuario.getNome() + " ficou enfurecido e desferiu um ataque letal em " + alvo.getNome() + " causando " + danoFinal + " de dano.");
        alvo.receberDano((danoFinal));
    }
}

