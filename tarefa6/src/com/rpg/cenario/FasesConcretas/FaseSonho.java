package com.rpg.cenario.FasesConcretas;

import com.rpg.personagens.Herois.Heroi;
import com.rpg.personagens.Monstros.MonstrosConcretos.FogoFatuo;
import com.rpg.cenario.FaseDeCombate;
import com.rpg.cenario.TipoCenario;
import java.util.List;
import java.util.ArrayList;

public class FaseSonho extends FaseDeCombate {
 
    public FaseSonho() {
        super();
    }

    public FaseSonho(boolean novoJogo) 
    {
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
    public void iniciar(Heroi heroi) 
    {
        this.heroi = heroi;
        System.out.println("Iniciando fase: " + this.nome);
        if (this.cenario != null)
            {
            this.cenario.aplicarEfeitos(heroi);
        }
    }
}