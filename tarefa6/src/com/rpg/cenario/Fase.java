package com.rpg.cenario;

import com.rpg.personagens.Herois.Heroi;

/**
 * Interface que define uma fase (ou nível) do jogo.
 */
public interface Fase
{
    /**
     * Inicia a fase, preparando o herói e aplicando efeitos de cenário.
     * @param heroi O herói que está entrando na fase.
     */
    void iniciar(Heroi heroi);

    /**
     * Verifica se a fase foi concluída com sucesso (todos os objetivos alcançados).
     * @return {@code true} se a fase foi concluída, {@code false} caso contrário.
     */
    boolean isConcluida();

    /**
     * Retorna a descrição do tipo de cenário desta fase.
     * @return A descrição do cenário.
     */
    String getTipoDeCenario();
}