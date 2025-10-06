package com.rpg.cenario;

import com.rpg.personagens.Herois.Heroi;


/**
 * Enumeração que define os tipos de cenário do jogo e seus efeitos.
 * Cada tipo de cenário tem um efeito específico no herói ao iniciar a fase.
 */
public enum TipoCenario 
{
    SONHO("Um Sonho estranho de um cochilho cansado.") 
    {
        /**
         * Aplica o modificador de Dano x2.0.
         * @param heroi O herói que entra na fase.
         */
        @Override
        public void aplicarEfeitos(Heroi heroi) 
        {
            System.out.println("Um sonho cheio de mensageiros, que avisam sobre o perigo a frente");
            heroi.setModificadorDeDano(2.0);
        }
    },

    FLORESTAPORTUGUESA("Acordado de surpresa, o heroi se encontra numa floresta, cercada de soldados...") 
    {
        /**
         * Aplica o modificador de Dano x1.1.
         * @param heroi O herói que entra na fase.
         */
        @Override
        public void aplicarEfeitos(Heroi heroi) 
        {
            System.out.println("Os soldados discutem com o heroi, e comecam uma briga");
            heroi.setModificadorDeDano(1.1);
        }
    },

    MEIANOITE("Os corpos caidos no chao se levantam ao tocar da luz do luar, é noite de lua cheia!") {
        /**
         * Aplica o modificador de Velocidade x0.9 (reduzindo a velocidade).
         * @param heroi O herói que entra na fase.
         */
        @Override
        public void aplicarEfeitos(Heroi heroi) {
            System.out.println("Um uivo ensurdecedor é escutado pelo heroi.");
            heroi.setModificadorDeVelocidade(0.9);
        }
    };

    private final String descricao;

    /**
     * Construtor para TipoCenario.
     * @param descricao A descrição textual do cenário.
     */
    TipoCenario(String descricao) 
    {
        this.descricao = descricao;
    }

    /**
     * Retorna a descrição do cenário.
     * @return A descrição.
     */
    public String getDescricao() 
    {
        return this.descricao;
    }

    /**
     * Aplica os efeitos do cenário sobre o herói.
     * @param heroi O herói que está entrando na fase.
     */
    public abstract void aplicarEfeitos(Heroi heroi);
}