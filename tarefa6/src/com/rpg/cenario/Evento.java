package com.rpg.cenario;

/**
 * Interface para a execução de eventos opcionais que podem ocorrer durante uma fase.
 */
public interface Evento
{
    /**
     * @param contextoFase O objeto Fase atual.
     * @return {@code true} se o evento deve ser ativado, {@code false} caso contrário.
     */
    boolean verficarGatilho(Fase contextoFase);

    /**
     * @param contextoFase O objeto Fase atual.
     */
    void executar(Fase contextoFase);
}