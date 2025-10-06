package com.rpg.itens;

/**
 * Classe base abstrata para todas as armas equipáveis por heróis.
 */
public abstract class Arma
{
    protected String nome;
    protected int nivelReq;

    /**
     * Construtor para Arma.
     * @param nome O nome da arma.
     * @param nivelReq O nível mínimo necessário para equipar a arma.
     */
    public Arma(String nome, int nivelReq)
    {
        this.nome=nome;
        this.nivelReq=nivelReq;
    }

    /**
     * Retorna o nome da arma.
     * @return O nome da arma.
     */
    public String getNome()
    {
        return nome;
    }

    /**
     * Retorna o nível mínimo necessário para equipar a arma.
     * @return O nível de requisito.
     */
    public int getNivelReq()
    {
        return nivelReq;
    }

    /**
     * Retorna o bônus de dano que esta arma concede.
     * @return O bônus de dano.
     */
    public abstract int getBonusDano();
    
    /**
     * Retorna o bônus de velocidade que esta arma concede.
     * @return O bônus de velocidade.
     */
    public abstract int getBonusVelocidade();
    
    /**
     * Retorna o bônus de vida máxima que esta arma concede.
     * @return O bônus de vida máxima.
     */
    public abstract int getBonusVidaMaxima();
}