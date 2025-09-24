package com.rpg.Ambiente.FasesConcretas;

import com.rpg.Personagens.Herois.Heroi;
import com.rpg.Personagens.Monstros.MonstrosConcretos.FogoFatuo;
import com.rpg.Personagens.Monstros.MonstrosConcretos.SoldadoPortugues;
import com.rpg.Personagens.Monstros.MonstrosConcretos.SoldadoPortuguesElite;
import com.rpg.Personagens.Monstros.Monstro;
import com.rpg.Personagens.Monstros.MonstrosConcretos.Lobisomem;
import com.rpg.Personagens.Monstros.MonstrosConcretos.Zumbi;
import com.rpg.Ambiente.FaseDeCombate;
import com.rpg.Ambiente.TipoCenario;
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
