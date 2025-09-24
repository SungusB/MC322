package com.rpg.Ambiente;

import com.rpg.Personagens.Herois.Heroi;


public enum TipoCenario 
{
    SONHO("Um Sonho estranho de um cochilho cansado.") 
    {
        @Override
        public void aplicarEfeitos(Heroi heroi) 
        {
            System.out.println("Um sonho cheio de mensageiros, que avisam sobre o perigo a frente");
            heroi.setModificadorDeDano(2.0);
        }
    },

    FLORESTAPORTUGUESA("Acordado de surpresa, o heroi se encontra numa floresta, cercada de soldados...") 
    {
        @Override
        public void aplicarEfeitos(Heroi heroi) 
        {
            System.out.println("Os soldados discutem com o heroi, e comecam uma briga");
            heroi.setModificadorDeDano(1.1);
        }
    },

    MEIANOITE("Os corpos caidos no chao se levantam ao tocar da luz do luar, é noite de lua cheia!") {
        @Override
        public void aplicarEfeitos(Heroi heroi) {
            System.out.println("Um uivo ensurdecedor é escutado pelo heroi.");
            heroi.setModificadorDeVelocidade(0.9);
        }
    };

    private final String descricao;

    TipoCenario(String descricao) 
    {
        this.descricao = descricao;
    }

    public String getDescricao() 
    {
        return this.descricao;
    }

    public abstract void aplicarEfeitos(Heroi heroi);
}