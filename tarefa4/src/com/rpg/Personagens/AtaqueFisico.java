package com.rpg.Personagens;

import com.rpg.Interfaces.Combate.AcaoDeCombate;
import com.rpg.Interfaces.Combate.Combatente;
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