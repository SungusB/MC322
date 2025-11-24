package com.rpg.personagens.Herois.HeroisConcretos.Hunter;

import com.rpg.combate.AcaoDeCombate;
import com.rpg.combate.Combatente;

/**
 * Habilidade especial do Hunter. Causa dano explosivo (dano base x3).
 */
public class AtaqueDeRaiva implements AcaoDeCombate
{
    private final int danoBase;

    /**
     * Construtor para AtaqueDeRaiva.
     * @param danoBase O dano base do ataque do Hunter.
     */
    public AtaqueDeRaiva(int danoBase)
    {
        this.danoBase = danoBase;
    }

    /**
     * Executa o ataque de raiva, aplicando 3x o dano base ao alvo.
     * @param usuario O Hunter.
     * @param alvo O combatente alvo.
     */
    @Override
    public void executar(Combatente usuario, Combatente alvo)
    {
        int danoFinal = this.danoBase * 3;
        System.out.println(usuario.getNome() + " ficou enfurecido e desferiu um ataque letal em " + alvo.getNome() + " causando " + danoFinal + " de dano.");
        alvo.receberDano((danoFinal));
    }
}