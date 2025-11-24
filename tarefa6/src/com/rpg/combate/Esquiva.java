package com.rpg.combate;

public class Esquiva implements AcaoDeCombate 
{

    public Esquiva(int velocidade) {}

    @Override
    public void executar(Combatente usuario, Combatente alvo) 
    {
        System.out.println(usuario.getNome() + " prepara-se para esquivar.");
        usuario.prepararEsquiva();
    }
}