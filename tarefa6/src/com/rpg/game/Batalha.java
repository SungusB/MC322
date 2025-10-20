package com.rpg.game;

import java.io.Serializable;
import com.rpg.cenario.Dificuldade;
import com.rpg.personagens.Herois.Heroi;

/**
 * Snapshot simples do estado do jogo para persistência.
 * Mantém referência ao herói, dificuldade e o índice da próxima fase da campanha.
 */
public class Batalha implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String classeHeroi;
    private Dificuldade dificuldade;
    private int indiceProximaFase;

    public Batalha() {}

    public Batalha(Heroi heroi, Dificuldade dificuldade, int indiceProximaFase) {
        this.classeHeroi = heroi.getClass().getName();
        this.dificuldade = dificuldade;
        this.indiceProximaFase = indiceProximaFase;
    }

    public String getClasseHeroi() { return classeHeroi; }
    public void setClasseHeroi(String classeHeroi) { this.classeHeroi = classeHeroi; }

    public Dificuldade getDificuldade() { return dificuldade; }
    public void setDificuldade(Dificuldade dificuldade) { this.dificuldade = dificuldade; }

    public int getIndiceProximaFase() { return indiceProximaFase; }
    public void setIndiceProximaFase(int indiceProximaFase) { this.indiceProximaFase = indiceProximaFase; }
}
