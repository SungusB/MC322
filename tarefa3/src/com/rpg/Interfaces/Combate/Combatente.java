package com.rpg.Interfaces.Combate;

//Define qlq participante de Combate

public interface Combatente
{
    String getNome();

    boolean estaVivo();

    void receberDano();

    void receberCura();

    AcaoDeCombate escolherAcao(Combatente alvo);
}