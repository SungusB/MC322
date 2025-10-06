package com.rpg.cenario;

import com.rpg.personagens.Herois.Heroi;
import com.rpg.personagens.Monstros.Monstro;
import com.rpg.combate.Combatente;
import com.rpg.combate.AcaoDeCombate;
import com.rpg.itens.Item;
import com.rpg.menu.MenuPosTurno;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe base para fases que envolvem combate direto contra monstros.
 * Estende a interface Fase.
 */
public abstract class FaseDeCombate implements Fase {
    protected String nome;
    protected String descricao;
    protected TipoCenario cenario;
    protected List<Monstro> monstros;
    protected Heroi heroi;
    protected boolean concluida = false;

    /**
     * Construtor para FaseDeCombate.
     * @param nome O nome da fase.
     * @param cenario O tipo de cenário (que aplica efeitos).
     * @param monstros A lista inicial de monstros desta fase.
     */
    public FaseDeCombate(String nome, TipoCenario cenario, List<Monstro> monstros) {
        this.nome = nome;
        this.cenario = cenario;
        this.monstros = monstros;
    }

    /**
     * @return A descrição do tipo de cenário.
     */
    @Override
    public String getTipoDeCenario() {
        return this.descricao;
    }

    /**
     * @return {@code true} se todos os monstros foram derrotados e o herói está vivo.
     */
    @Override
    public boolean isConcluida() {
        return this.concluida;
    }

    /**
     * Inicia a fase, aplicando o herói e os efeitos do cenário.
     * O método é abstrato para permitir customização em subclasses.
     * @param heroi O herói que está participando da fase.
     */
    @Override
    public abstract void iniciar(Heroi heroi);

    /**
     * Executa a sequência de combates contra todos os monstros da fase.
     * Inclui a lógica de turnos e o menu pós-combate.
     */
    public void executarCombate() {
        if (this.heroi == null) {
            throw new IllegalStateException("Fase não iniciada. Chame iniciar(Heroi) antes de executarCombate().");
        }

        for (Monstro monstro : new ArrayList<>(monstros)) {
            System.out.println("\n>>> Um " + monstro.getNome() + " surge! <<<");

            while (heroi.estaVivo() && monstro.estaVivo()) {
                // Quem é mais rápido ataca primeiro
                Combatente primeiro = (heroi.getVelocidade() >= monstro.getVelocidade()) ? heroi : monstro;
                Combatente segundo = (primeiro == heroi) ? monstro : heroi;

                turno(primeiro, segundo);
                if (!segundo.estaVivo()) break;

                turno(segundo, primeiro);
                if (!primeiro.estaVivo()) break;

                System.out.println("A batalha continua feroz...");
            }

            if (!heroi.estaVivo()) {
                System.out.println("Seu herói caiu em combate...");
                return;
            }

            if (!monstro.estaVivo()) {
                System.out.println(monstro.getNome() + " foi derrotado!");
                List<Item> loot = monstro.droparLoot();
                if (!loot.isEmpty()) {
                    System.out.println("Você encontrou loot:");
                    for (Item it : loot) System.out.println(" - " + it.getNome());
                }
                MenuPosTurno menu = new MenuPosTurno();
                menu.setLoot(loot);
                boolean continuar = menu.exibir(heroi, !loot.isEmpty());
                if (!continuar) return;
            }
        }

        concluida = true;
        System.out.println("*** Fase concluída: " + this.nome + " ***");
    }

    /**
     * Executa um único turno de combate entre um atacante e um alvo.
     * @param atacante O combatente que ataca.
     * @param alvo O combatente que recebe a ação.
     */
    private void turno(Combatente atacante, Combatente alvo) {
        AcaoDeCombate acao = atacante.escolherAcao(alvo);
        System.out.println(atacante.getNome() + " usa: " + acao.getClass().getSimpleName());
        acao.executar(atacante, alvo);
        // O check de vitória foi movido para o loop principal para melhor controle
        // Mas mantemos a lógica de fim de fase aqui se for o caso
        if (!alvo.estaVivo()) {
             System.out.println(alvo.getNome() + " foi derrotado!");
             // Lógica de loot e XP é tratada em executarCombate()
        }
    }

    /**
     * Retorna a lista de monstros desta fase.
     * @return A lista de monstros.
     */
    public List<Monstro> getMonstros()
    {
        return this.monstros;
    }
}