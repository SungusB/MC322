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

/**
 * Testa as exceções personalizadas do sistema de RPG.
 */
public class ExcecoesTest {

    // Testa a exceção NivelInsuficienteException (Checked Exception)
    @Test
    void testNivelInsuficienteException() {
        // Hunter começa no nível 1
        Hunter heroi = new Hunter(); 
        // Machado Lunar requer nível 3
        MachadoLunar machado = new MachadoLunar(); 

        // 1. AssertThat: Verifica se a exceção é lançada
        NivelInsuficienteException thrown = assertThrows(
            NivelInsuficienteException.class, 
            () -> heroi.equiparArma(machado), 
            "Deve lançar NivelInsuficienteException ao tentar equipar uma arma de nível muito alto"
        );
        
        // 2. AssertThat: Verifica a mensagem de erro
        assertTrue(thrown.getMessage().contains("não tem nível suficiente para equipar Machado Lunar"));
    }

    // Testa a nova exceção AtaqueCriticoException (Unchecked Exception)
    @Test
    void testAtaqueCriticoException() {
        Hunter atacante = new Hunter();
        Zumbi alvo = new Zumbi();
        // Ação na posição 0 é AtaqueFisico
        AtaqueFisico ataque = (AtaqueFisico) atacante.getAcoesDisponiveis().get(0);
        
        boolean criticoLancado = false;
        final int MAX_TRIES = 1000;
        
        // O AtaqueFisico tem 20% de chance de crítico. 
        // Usamos um loop para garantir que a chance seja ativada pelo menos uma vez.
        for (int i = 0; i < MAX_TRIES; i++) {
            try {
                // Cria um novo Zumbi para cada tentativa para evitar que ele morra antes do crítico
                alvo = new Zumbi(); 
                ataque.executar(atacante, alvo);
            } catch (AtaqueCriticoException e) {
                criticoLancado = true;
                // Saímos assim que a exceção é lançada
                break; 
            }
        }
        
        assertTrue(criticoLancado, "O AtaqueFisico deve lançar AtaqueCriticoException com 20% de chance em várias tentativas.");
    }
}