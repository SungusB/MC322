package com.rpg.Interfaces.Mundo;

//executa algum evento x de uma fase
public interface Evento
{
    //checa para ver se x evento pode rolar
    boolean verficarGatilho(Fase contextoFase);

    //Executa o evento;
    void executar(Fase contextoFase);
}