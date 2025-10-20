package com.rpg.cenario.FasesConcretas;

import com.rpg.personagens.Herois.Heroi;
import com.rpg.personagens.Monstros.MonstrosConcretos.FogoFatuo;
import com.rpg.personagens.Monstros.MonstrosConcretos.SoldadoPortugues;
import com.rpg.personagens.Monstros.MonstrosConcretos.SoldadoPortuguesElite;
import com.rpg.personagens.Monstros.Monstro;
import com.rpg.personagens.Monstros.MonstrosConcretos.Lobisomem;
import com.rpg.personagens.Monstros.MonstrosConcretos.Zumbi;
import com.rpg.cenario.FaseDeCombate;
import com.rpg.cenario.TipoCenario;
import java.util.List;

/**
 * Fase concreta: Noite de Lua Cheia.
 * É a fase final da campanha, com o cenário MEIANOITE que reduz a velocidade do herói (x0.9).
 * Consiste no chefe Lobisomem e três Zumbis.
 */
public class FaseMeiaNoite extends FaseDeCombate {

    /**
     * Construtor para FaseMeiaNoite.
     * Inicializa a fase com o nome, tipo de cenário e a lista de monstros.
     */
    public FaseMeiaNoite() {
        super("Noite de Lua Cheia",
              TipoCenario.MEIANOITE,
              List.of(
                  new Lobisomem(),
                  new Zumbi(),
                  new Zumbi(),
                  new Zumbi()
              )
        );
    }

    /**
     * Inicia a fase de combate, define o herói e aplica os efeitos do cenário.
     * O cenário MEIANOITE aplica modificador de Velocidade x0.9.
     * @param heroi O herói que entra na fase.
     */
    @Override
    public void iniciar(Heroi heroi) {
        this.heroi = heroi;
        System.out.println("Iniciando fase: " + this.nome);
        this.cenario.aplicarEfeitos(heroi);
    }
}