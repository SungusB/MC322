package com.rpg.Ambiente.FasesConcretas;

import com.rpg.Personagens.Herois.Heroi;
import com.rpg.Personagens.Monstros.MonstrosConcretos.FogoFatuo;
import com.rpg.Personagens.Monstros.MonstrosConcretos.SoldadoPortugues;
import com.rpg.Personagens.Monstros.MonstrosConcretos.SoldadoPortuguesElite;
import com.rpg.Personagens.Monstros.Monstro;
import com.rpg.Personagens.Monstros.MonstrosConcretos.SoldadoPortugues;
import com.rpg.Personagens.Monstros.MonstrosConcretos.SoldadoPortuguesElite;
import com.rpg.Ambiente.FaseDeCombate;
import com.rpg.Ambiente.TipoCenario;
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