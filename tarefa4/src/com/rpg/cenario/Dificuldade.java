package com.rpg.cenario;

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

    public double getVidaMultiplicador() 
    {
        return vidaMultiplicador;
    }

    public double getDanoMultiplicador() 
    {
        return danoMultiplicador;
    }

    public double getDropMultiplicador() 
    {
        return dropMultiplicador;
    }
}
