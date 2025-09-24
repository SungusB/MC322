package com.rpg.Ambiente.FasesConcretas;

import com.rpg.Personagens.Herois.Heroi;
import com.rpg.Personagens.Monstros.MonstrosConcretos.FogoFatuo;
import com.rpg.Personagens.Monstros.Monstro;
import com.rpg.Personagens.Monstros.MonstrosConcretos.FogoFatuo;
import com.rpg.Ambiente.FaseDeCombate;
import com.rpg.Ambiente.TipoCenario;
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
