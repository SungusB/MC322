package com.rpg.exceptions;

/**
 * Exceção de tempo de execução
 */
public class AtaqueCriticoException extends RuntimeException {
    /**
     * @param mensagem A mensagem de erro que descreve o evento crítico.
     */
    public AtaqueCriticoException(String mensagem) {
        super(mensagem);
    }
}