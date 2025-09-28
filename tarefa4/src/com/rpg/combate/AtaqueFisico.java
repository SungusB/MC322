package com.rpg.combate;

import com.rpg.combate.AcaoDeCombate;
import com.rpg.combate.Combatente;
import java.util.Random;

public class AtaqueFisico implements AcaoDeCombate
{
    private int danoBase;
    
    public AtaqueFisico(int danoBase)
    {
        this.danoBase = danoBase;
    }

    @Override
    public void executar(Combatente usuario, Combatente alvo)
    {
        int danoFinal =this.danoBase;
        if (new Random().nextInt(100) < 20)
        {
            danoFinal *= 2;
            System.out.println("CRITICO");
        }
        System.out.println(usuario.getNome() + " ataca " 
        + alvo.getNome() + " causando " + danoFinal + " de dano.");

        alvo.receberDano(danoFinal);
    }
}