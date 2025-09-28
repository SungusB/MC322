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

public class FaseMeiaNoite extends FaseDeCombate {

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

    @Override
    public void iniciar(Heroi heroi) {
        this.heroi = heroi;
        System.out.println("Iniciando fase: " + this.nome);
        this.cenario.aplicarEfeitos(heroi);
    }
}
