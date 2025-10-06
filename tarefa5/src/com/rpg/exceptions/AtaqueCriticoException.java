package com.rpg.exceptions;

/**
 * Exceção de tempo de execução (Unchecked Exception) usada para sinalizar que um 
 * ataque crítico ocorreu. 
 * Não exige que os métodos de combate a declarem no 'throws'.
 */
public class AtaqueCriticoException extends RuntimeException {
    /**
     * Construtor para AtaqueCriticoException.
     * @param mensagem A mensagem de erro que descreve o evento crítico.
     */
    public AtaqueCriticoException(String mensagem) {
        super(mensagem);
    }
}