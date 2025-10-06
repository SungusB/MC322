package com.rpg.exceptions;

/**
 * Exceção checada (Checked Exception) lançada quando um herói tenta
 * equipar um item com requisito de nível maior que o nível atual do herói.
 */
public class NivelInsuficienteException extends Exception {
    /**
     * Construtor para NivelInsuficienteException.
     * @param mensagem A mensagem de erro que descreve a falha ao equipar o item.
     */
    public NivelInsuficienteException(String mensagem) {
        super(mensagem);
    }
}