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

public class FaseFloresta extends FaseDeCombate {

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

    @Override
    public void iniciar(Heroi heroi) {
        this.heroi = heroi;
        System.out.println("Iniciando fase: " + this.nome);
        this.cenario.aplicarEfeitos(heroi);
    }
}