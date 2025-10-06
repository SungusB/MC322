package com.rpg.cenario.FasesConcretas;

import com.rpg.personagens.Herois.Heroi;
import com.rpg.personagens.Monstros.MonstrosConcretos.FogoFatuo;
import com.rpg.personagens.Monstros.Monstro;
import com.rpg.personagens.Monstros.MonstrosConcretos.FogoFatuo;
import com.rpg.cenario.FaseDeCombate;
import com.rpg.cenario.TipoCenario;
import java.util.List;

/**
 * Fase concreta: O Sonho Febril.
 * É a primeira fase da campanha, com o cenário SONHO que aplica Dano x2.0 ao herói.
 * Consiste em três Fogo Fátuos.
 */
public class FaseSonho extends FaseDeCombate {

    /**
     * Construtor para FaseSonho.
     * Inicializa a fase com o nome, tipo de cenário e a lista de monstros.
     */
    public FaseSonho() {
        super("O Sonho Febril",
              TipoCenario.SONHO,
              List.of(
                  new FogoFatuo(),
                  new FogoFatuo(),
                  new FogoFatuo()
              )
        );
    }

    /**
     * Inicia a fase de combate, define o herói e aplica os efeitos do cenário.
     * O cenário SONHO aplica modificador de Dano x2.0.
     * @param heroi O herói que entra na fase.
     */
    @Override
    public void iniciar(Heroi heroi) {
        this.heroi = heroi;
        System.out.println("Iniciando fase: " + this.nome);
        this.cenario.aplicarEfeitos(heroi);
    }
}