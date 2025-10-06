package com.rpg.cenario;

import java.util.List;

/**
 * Interface para classes responsáveis por gerar a sequência de fases do jogo (campanha).
 */
public interface GeradorDeFases
{
    /**
     * Gera uma lista de fases para a campanha.
     * @param quantidadeDeFases O número de fases a serem geradas.
     * @return Uma lista de objetos Fase.
     */
    List<Fase> gerar(int quantidadeDeFases);
}