package com.rpg.tests;

import com.rpg.combate.AtaqueFisico;
import com.rpg.personagens.Herois.HeroisConcretos.Hunter.Hunter;
import com.rpg.personagens.Monstros.MonstrosConcretos.Zumbi;
import com.rpg.exceptions.AtaqueCriticoException;
import com.rpg.exceptions.NivelInsuficienteException;
import com.rpg.itens.ArmasConcretas.MachadoLunar;
import com.rpg.combate.AcaoDeCombate;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ExcecoesTest {

    @Test
    void testNivelInsuficienteException() {
        Hunter heroi = new Hunter(); 
        MachadoLunar machado = new MachadoLunar(); 

        NivelInsuficienteException thrown = assertThrows(
            NivelInsuficienteException.class, 
            () -> heroi.equiparArma(machado), 
            "Deve lançar NivelInsuficienteException ao tentar equipar uma arma de nível muito alto"
        );
        
        assertTrue(thrown.getMessage().contains("não tem nível suficiente para equipar Machado Lunar"));
    }

    @Test
    void testAtaqueCriticoException() {
        Hunter atacante = new Hunter();
        Zumbi alvo = new Zumbi();
        AtaqueFisico ataque = (AtaqueFisico) atacante.getAcoesDisponiveis().get(0);        
        boolean criticoLancado = false;
        final int MAX_TRIES = 1000;
        
        for (int i = 0; i < MAX_TRIES; i++) {
            try {
                alvo = new Zumbi(); 
                ataque.executar(atacante, alvo);
            } catch (AtaqueCriticoException e) {
                criticoLancado = true;
                break; 
            }
        }
        
        assertTrue(criticoLancado, "O AtaqueFisico deve lançar AtaqueCriticoException com 20% de chance em várias tentativas.");
    }
}