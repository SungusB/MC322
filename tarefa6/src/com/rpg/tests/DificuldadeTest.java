package com.rpg.tests;

import com.rpg.cenario.Dificuldade;
import com.rpg.personagens.Monstros.Monstro;
import com.rpg.personagens.Monstros.MonstrosConcretos.Lobisomem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DificuldadeTest {

    @Test
    void testMonstroVidaAumentaComDificuldade() {
        Monstro monstroFacil = new Lobisomem();
        monstroFacil.aplicarDificuldade(Dificuldade.FACIL);
        int vidaFacil = monstroFacil.getVidaMaxima();

        Monstro monstroDificil = new Lobisomem();
        monstroDificil.aplicarDificuldade(Dificuldade.DIFICIL);
        int vidaDificil = monstroDificil.getVidaMaxima();

        assertTrue(vidaDificil > vidaFacil,
            "O monstro deve ter mais vida em dificuldade difícil do que em fácil");
    }

    @Test
    void testMonstroDanoAumentaComDificuldade() {
        Monstro monstroFacil = new Lobisomem();
        monstroFacil.aplicarDificuldade(Dificuldade.FACIL);
        int danoFacil = monstroFacil.getDanoAtaque();

        Monstro monstroDificil = new Lobisomem();
        monstroDificil.aplicarDificuldade(Dificuldade.DIFICIL);
        int danoDificil = monstroDificil.getDanoAtaque();

        assertTrue(danoDificil > danoFacil,
            "O monstro deve causar mais dano em dificuldade difícil do que em fácil");
    }
}