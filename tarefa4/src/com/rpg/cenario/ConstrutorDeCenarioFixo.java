package com.rpg.cenario;

import com.rpg.cenario.Fase;
import com.rpg.cenario.GeradorDeFases;
import com.rpg.cenario.FasesConcretas.FaseSonho;
import com.rpg.cenario.FasesConcretas.FaseMeiaNoite;
import com.rpg.cenario.FasesConcretas.FaseFloresta;
import java.util.ArrayList;
import java.util.List;

public class ConstrutorDeCenarioFixo implements GeradorDeFases {

    @Override
    public List<Fase> gerar(int quantidadeDeFases) {
        List<Fase> campanha = new ArrayList<>();

        // Adiciona as fases concretas na ordem
        if (quantidadeDeFases >= 1) {
            campanha.add(new FaseSonho());
        }

        if (quantidadeDeFases >= 2) {
            campanha.add(new FaseFloresta());
        }

        if (quantidadeDeFases >= 3) {
            campanha.add(new FaseMeiaNoite());
        }

        return campanha;
    }
}
