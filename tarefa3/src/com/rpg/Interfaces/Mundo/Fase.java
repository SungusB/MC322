package com.rpg.Interfaces.Mundo;

import com.rpg.Personagens.Herois.Heroi;

//define uma fase do jogo

public interface Fase
{
    //inicia a fase para o heroi
    void iniciar(Heroi heroi);

    //verifica se a fase acabou (heroi morto/monstros mortos)
    boolean isConcluida();

    //retorna descricao da fase
    String getTipoDeCenario();
}