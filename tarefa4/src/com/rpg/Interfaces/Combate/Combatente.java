package com.rpg.Interfaces.Combate;

//Define qlq participante de Combate

public interface Combatente
{
    String getNome();

    boolean estaVivo();

    void receberDano(int dano);

    void receberCura(int cura);

    AcaoDeCombate escolherAcao(Combatente alvo);
}