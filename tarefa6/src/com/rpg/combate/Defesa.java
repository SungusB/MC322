package com.rpg.combate;

public class Defesa implements AcaoDeCombate {
    
    public Defesa(double percentual) {}

    @Override
    public void executar(Combatente usuario, Combatente alvo) 
    {
        System.out.println(usuario.getNome() + " assume postura defensiva.");
        usuario.prepararDefesa();
    }
}