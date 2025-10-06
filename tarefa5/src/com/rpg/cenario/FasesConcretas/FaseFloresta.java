package com.rpg.cenario.FasesConcretas;

import com.rpg.personagens.Herois.Heroi;
import com.rpg.personagens.Monstros.MonstrosConcretos.FogoFatuo;
import com.rpg.personagens.Monstros.MonstrosConcretos.SoldadoPortugues;
import com.rpg.personagens.Monstros.MonstrosConcretos.SoldadoPortuguesElite;
import com.rpg.personagens.Monstros.Monstro;
import com.rpg.personagens.Monstros.MonstrosConcretos.SoldadoPortugues;
import com.rpg.personagens.Monstros.MonstrosConcretos.SoldadoPortuguesElite;
import com.rpg.cenario.FaseDeCombate;
import com.rpg.cenario.TipoCenario;
import java.util.List;

/**
 * Fase concreta: A Floresta Portuguesa.
 * É a segunda fase da campanha, com o cenário FLORESTAPORTUGUESA que aplica Dano x1.1 ao herói.
 * Consiste em Soldados Portugueses comuns e um Soldado Português de Elite.
 */
public class FaseFloresta extends FaseDeCombate {

    /**
     * Construtor para FaseFloresta.
     * Inicializa a fase com o nome, tipo de cenário e a lista de monstros.
     */
    public FaseFloresta() {
        super("A Floresta Portuguesa",
              TipoCenario.FLORESTAPORTUGUESA,
              List.of(
                  new SoldadoPortugues(),
                  new SoldadoPortugues(),
                  new SoldadoPortugues(),
                  new SoldadoPortuguesElite()
              )
        );
    }

    /**
     * Inicia a fase de combate, define o herói e aplica os efeitos do cenário.
     * O cenário FLORESTAPORTUGUESA aplica modificador de Dano x1.1.
     * @param heroi O herói que entra na fase.
     */
    @Override
    public void iniciar(Heroi heroi) {
        this.heroi = heroi;
        System.out.println("Iniciando fase: " + this.nome);
        this.cenario.aplicarEfeitos(heroi);
    }
}