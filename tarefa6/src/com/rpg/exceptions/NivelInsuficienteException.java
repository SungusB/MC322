package com.rpg.exceptions;

/**
 * Exceção checada (Checked Exception)
 */
public class NivelInsuficienteException extends Exception {
    /**
     * @param mensagem A mensagem de erro que descreve a falha ao equipar o item.
     */
    public NivelInsuficienteException(String mensagem) {
        super(mensagem);
    }
}