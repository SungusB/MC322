package com.rpg.cenario;

/**
 * Enumeração que define os níveis de dificuldade do jogo e seus respectivos multiplicadores.
 */
public enum Dificuldade {
    FACIL(0.7, 0.7, 0.9),
    NORMAL(1.0, 1.0, 1.0),
    DIFICIL(1.3, 1.3, 1.1);

    private final double vidaMultiplicador;
    private final double danoMultiplicador;
    private final double dropMultiplicador; 

    Dificuldade(double vidaMultiplicador, double danoMultiplicador, double dropMultiplicador) 
    {
        this.vidaMultiplicador = vidaMultiplicador;
        this.danoMultiplicador = danoMultiplicador;
        this.dropMultiplicador = dropMultiplicador;
    }

    /**
     * Retorna o multiplicador de vida aplicado aos monstros para esta dificuldade.
     * @return O multiplicador de vida.
     */
    public double getVidaMultiplicador() 
    {
        return vidaMultiplicador;
    }

    /**
     * Retorna o multiplicador de dano aplicado aos monstros para esta dificuldade.
     * @return O multiplicador de dano.
     */
    public double getDanoMultiplicador() 
    {
        return danoMultiplicador;
    }

    /**
     * Retorna o multiplicador da chance de drop de loot para esta dificuldade.
     * @return O multiplicador de drop.
     */
    public double getDropMultiplicador() 
    {
        return dropMultiplicador;
    }
}