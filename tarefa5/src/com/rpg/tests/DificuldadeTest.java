package com.rpg.tests;

import com.rpg.cenario.Dificuldade;
import com.rpg.personagens.Monstros.Monstro;
import com.rpg.personagens.Monstros.MonstrosConcretos.Lobisomem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Classe de testes unitários para a aplicação de multiplicadores da enumeração
 * {@link Dificuldade} nos atributos dos monstros.
 */
class DificuldadeTest {

    /**
     * Testa se a vida máxima de um monstro (Lobisomem) é corretamente ajustada
     * e se a dificuldade DIFÍCIL resulta em maior vida que a dificuldade FÁCIL.
     */
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

    /**
     * Testa se o dano de ataque de um monstro (Lobisomem) é corretamente ajustado
     * e se a dificuldade DIFÍCIL resulta em maior dano que a dificuldade FÁCIL.
     */
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