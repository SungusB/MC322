package com.rpg.combate;

import com.rpg.combate.AcaoDeCombate;
import com.rpg.combate.Combatente;
import com.rpg.exceptions.AtaqueCriticoException;
import java.util.Random;

/**
 * Representa a ação de ataque físico básico.
 * Tem 20% de chance de ser um acerto crítico, dobrando o dano e lançando uma exceção.
 */
public class AtaqueFisico implements AcaoDeCombate
{
    private int danoBase;
    
    /**
     * Construtor para AtaqueFisico.
     * @param danoBase O dano base a ser aplicado pela ação.
     */
    public AtaqueFisico(int danoBase)
    {
        this.danoBase = danoBase;
    }

    /**
     * Executa o ataque físico, calcula acertos críticos e aplica o dano no alvo.
     * @param usuario O combatente que está atacando.
     * @param alvo O combatente que recebe o ataque.
     * @throws AtaqueCriticoException Se ocorrer um acerto crítico (20% de chance).
     */
    @Override
    public void executar(Combatente usuario, Combatente alvo)
    {
        int danoFinal =this.danoBase;
        boolean isCritico = new Random().nextInt(100) < 20; // Armazena o status do crítico

        if (isCritico)
        {
            danoFinal *= 2;
            System.out.println("CRITICO");
        }
        
        System.out.println(usuario.getNome() + " ataca " 
        + alvo.getNome() + " causando " + danoFinal + " de dano.");

        alvo.receberDano(danoFinal);

        // Lança a exceção após o dano ser aplicado
        if (isCritico) {
            throw new AtaqueCriticoException(usuario.getNome() + " acertou um ataque crítico!");
        }
    }
}