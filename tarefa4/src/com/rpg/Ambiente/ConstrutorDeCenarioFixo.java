package com.rpg.Ambiente;

import com.rpg.Interfaces.Mundo.Fase;
import com.rpg.Interfaces.Mundo.GeradorDeFases;
import com.rpg.Ambiente.FasesConcretas.FaseSonho;
import com.rpg.Ambiente.FasesConcretas.FaseFloresta;
import com.rpg.Ambiente.FasesConcretas.FaseMeiaNoite;
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
