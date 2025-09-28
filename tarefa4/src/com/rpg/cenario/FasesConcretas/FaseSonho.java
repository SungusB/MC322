package com.rpg.cenario.FasesConcretas;

import com.rpg.personagens.Herois.Heroi;
import com.rpg.personagens.Monstros.MonstrosConcretos.FogoFatuo;
import com.rpg.personagens.Monstros.Monstro;
import com.rpg.personagens.Monstros.MonstrosConcretos.FogoFatuo;
import com.rpg.cenario.FaseDeCombate;
import com.rpg.cenario.TipoCenario;
import java.util.List;

public class FaseSonho extends FaseDeCombate {

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

    @Override
    public void iniciar(Heroi heroi) {
        this.heroi = heroi;
        System.out.println("Iniciando fase: " + this.nome);
        this.cenario.aplicarEfeitos(heroi);
    }
}
