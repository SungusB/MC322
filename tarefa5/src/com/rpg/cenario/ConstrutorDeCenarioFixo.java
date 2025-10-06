package com.rpg.cenario;

import com.rpg.cenario.Fase;
import com.rpg.cenario.GeradorDeFases;
import com.rpg.cenario.FasesConcretas.FaseSonho;
import com.rpg.cenario.FasesConcretas.FaseMeiaNoite;
import com.rpg.cenario.FasesConcretas.FaseFloresta;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementação do GeradorDeFases que constrói uma campanha com fases em ordem fixa.
 */
public class ConstrutorDeCenarioFixo implements GeradorDeFases {

    /**
     * Gera uma sequência de fases fixas: Fase Sonho, Fase Floresta, Fase Meia Noite.
     * O número máximo de fases geradas é 3.
     * @param quantidadeDeFases O número de fases a serem incluídas (máximo 3).
     * @return Uma lista de Fases.
     */
    @Override
    public List<Fase> gerar(int quantidadeDeFases) {
        List<Fase> campanha = new ArrayList<>();

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