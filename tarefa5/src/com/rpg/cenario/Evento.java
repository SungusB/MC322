package com.rpg.cenario;

/**
 * Interface para a execução de eventos opcionais que podem ocorrer durante uma fase.
 */
public interface Evento
{
    /**
     * Checa se o evento deve ser ativado com base no contexto da fase.
     * @param contextoFase O objeto Fase atual.
     * @return {@code true} se o evento deve ser ativado, {@code false} caso contrário.
     */
    boolean verficarGatilho(Fase contextoFase);

    /**
     * Executa a lógica do evento.
     * @param contextoFase O objeto Fase atual.
     */
    void executar(Fase contextoFase);
}