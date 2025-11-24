package com.rpg.tests;

import com.rpg.personagens.Herois.HeroisConcretos.Hunter.Hunter;
import com.rpg.personagens.Monstros.MonstrosConcretos.Zumbi;
import com.rpg.personagens.Monstros.Monstro;
import com.rpg.combate.AcaoDeCombate;
import com.rpg.combate.Combatente;
import com.rpg.itens.Lootavel;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Testes básicos para as classes de combatentes (heróis e monstros).
 * Cobrem: implementação da interface, receberDano, atacar, e lootabilidade.
 */
class CombatenteTest 
{

    @Test
    void heroImplementaCombatente() 
    {
        Hunter hunter = new Hunter();
        assertTrue(hunter instanceof Combatente, "Heroi deve implementar Combatente");
    }

    @Test
    void monstroImplementaCombatente() 
    {
        Zumbi z = new Zumbi();
        assertTrue(z instanceof Combatente, "Monstro deve implementar Combatente");
    }

    @Test
    void heroiRecebeDanoEMorreSeZerado() 
    {
        Hunter hunter = new Hunter();
        hunter.receberDano(hunter.getVidaMaxima() + 1000);
        assertFalse(hunter.estaVivo(), "Heroi deve estar morto após dano superior à sua vida máxima");
    }

    @Test
    void monstroRecebeDanoEMorreSeZerado() 
    {
        Zumbi z = new Zumbi();
        z.receberDano(z.getVidaMaxima() + 1000);
        assertFalse(z.estaVivo(), "Monstro deve estar morto após dano superior à sua vida máxima");
    }

    @Test
    void HeroiMataMonstro() 
    {
        Hunter hunter = new Hunter();
        Zumbi z = new Zumbi();

        AcaoDeCombate ataque = hunter.getAcoesDisponiveis().get(0);
        ataque.executar(hunter, z);

        assertFalse(z.estaVivo(), "Ataque do herói deve matar o Zumbi fraco em um hit");
    }

    @Test
    void monstroELootavel() 
    {
        Monstro m = new Zumbi();
        assertTrue(m instanceof Lootavel, "Monstro deve implementar Lootavel");
    }
}
