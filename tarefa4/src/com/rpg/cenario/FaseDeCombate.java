package com.rpg.cenario;

import com.rpg.personagens.Herois.Heroi;
import com.rpg.personagens.Monstros.Monstro;
import com.rpg.combate.Combatente;
import com.rpg.combate.AcaoDeCombate;
import com.rpg.itens.Item;
import com.rpg.menu.MenuPosTurno;

import java.util.ArrayList;
import java.util.List;

public abstract class FaseDeCombate implements Fase {
    protected String nome;
    protected String descricao;
    protected TipoCenario cenario;
    protected List<Monstro> monstros;
    protected Heroi heroi;
    protected boolean concluida = false;

    public FaseDeCombate(String nome, TipoCenario cenario, List<Monstro> monstros) {
        this.nome = nome;
        this.cenario = cenario;
        this.monstros = monstros;
    }

    @Override
    public String getTipoDeCenario() {
        return this.descricao;
    }

    @Override
    public boolean isConcluida() {
        return this.concluida;
    }

    @Override
    public abstract void iniciar(Heroi heroi);

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

    private void turno(Combatente atacante, Combatente alvo) {
        AcaoDeCombate acao = atacante.escolherAcao(alvo);
        System.out.println(atacante.getNome() + " usa: " + acao.getClass().getSimpleName());
        acao.executar(atacante, alvo);
        if (heroi.estaVivo()) {
            this.concluida = true;
            System.out.println("\n*** Fase concluída: " + this.nome + " ***");
        }
    }

    public List<Monstro> getMonstros()
    {
        return this.monstros;
    }
}
