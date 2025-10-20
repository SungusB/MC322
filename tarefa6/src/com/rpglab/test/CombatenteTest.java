package com.rpglab.test;

import com.rpg.combate.AcaoDeCombate;
import com.rpg.combate.AtaqueFisico;
import com.rpg.combate.Combatente;
import com.rpg.personagens.Herois.Heroi;
import com.rpg.personagens.Monstros.Monstro;
import com.rpg.personagens.Personagem;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

class CombatenteTest {

    // Herói anônimo mínimo para teste
    private Heroi novoHeroiBasico() {
        return new Heroi() {
            { // atributos base
                this.nome = "TesteHeroi";
                this.vidaMaxima = 500;
                this.vidaAtual = 500;
                this.danoAtaque = 120;
                this.velocidade = 50;
                this.defesaPercentual = 20;
            }
            @Override public AcaoDeCombate getHabilidadeEspecial() { return new AtaqueFisico(getDanoAtaque()); }
        };
    }

    // Monstro anônimo mínimo para teste
    private Monstro novoMonstroBasico(int vida, int dano) {
        return new Monstro() {
            { this.nome = "TesteMonstro"; this.vidaMaxima = vida; this.vidaAtual = vida; this.danoAtaque = dano; this.velocidade = 10; this.defesaPercentual = 0; }
            @Override public java.util.List<com.rpg.itens.Item> droparLoot() { return java.util.Collections.emptyList(); }
        };
    }

    @Test
    void receberDano_deveReduzirVidaAtualENaoApenasMatar() {
        Heroi h = novoHeroiBasico();
        Monstro m = novoMonstroBasico(200, 10);

        // Antes
        assertEquals(200, m.getVidaAtual());

        // Um ataque físico simples do herói
        AcaoDeCombate ataque = new AtaqueFisico(h.getDanoAtaque());
        ataque.executar(h, m);

        // Depois: ou morreu, ou reduziu a vida corretamente
        assertTrue(m.getVidaAtual() <= 200, "Vida atual deve ser reduzida");
        if (!m.estaVivo()) {
            assertEquals(0, m.getVidaAtual(), "Se morreu, vida atual deve ser 0");
        } else {
            assertTrue(m.getVidaAtual() < 200, "Se ainda vivo, vida atual deve ter diminuído");
        }
    }

    @Test
    void executarAcao_heroiAnonimoContraMonstro() {
        Heroi h = novoHeroiBasico();
        Monstro m = novoMonstroBasico(100, 5);

        List<AcaoDeCombate> acoes = h.getAcoesDisponiveis();
        assertFalse(acoes.isEmpty(), "Herói deve possuir ações disponíveis");

        AcaoDeCombate acao = acoes.get(0);
        acao.executar(h, m);
        assertTrue(m.getVidaAtual() < 100 || !m.estaVivo(), "Após ação do herói, o monstro deve perder vida ou morrer");
    }
}
