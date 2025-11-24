package com.rpg.cenario;

import com.rpg.personagens.Herois.Heroi;
import com.rpg.personagens.Monstros.Monstro;
import com.rpg.combate.Combatente;
import com.rpg.combate.AcaoDeCombate;
import com.rpg.itens.Item;
import com.rpg.cenario.FasesConcretas.FaseSonho;
import com.rpg.cenario.FasesConcretas.FaseFloresta;
import com.rpg.cenario.FasesConcretas.FaseMeiaNoite;

import jakarta.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso({FaseSonho.class, FaseFloresta.class, FaseMeiaNoite.class})
public abstract class FaseDeCombate implements Fase {
    
    protected String nome;
    protected String descricao;
    protected TipoCenario cenario;

    @XmlElementWrapper(name = "monstros")
    @XmlElement(name = "monstro")
    protected List<Monstro> monstros;

    @XmlTransient
    protected Heroi heroi;
    
    protected boolean concluida = false;

    // Construtor JAXB: Inicializa lista vazia e mutável
    public FaseDeCombate() {
        this.monstros = new ArrayList<>();
    }

    // Construtor Normal: Garante que a lista recebida se torne mutável
    public FaseDeCombate(String nome, TipoCenario cenario, List<Monstro> monstros) {
        this.nome = nome;
        this.cenario = cenario;
        this.descricao = cenario != null ? cenario.getDescricao() : "";
        this.monstros = new ArrayList<>(monstros);
    }

    @Override
    public String getTipoDeCenario() { return this.descricao; }

    @Override
    public boolean isConcluida() { return this.concluida; }

    @Override
    public abstract void iniciar(Heroi heroi);

    @Override
    public void executar(Heroi heroi) {
        iniciar(heroi);
        executarCombate();
    }

    public void executarCombate() {
        if (this.heroi == null) throw new IllegalStateException("Fase não iniciada.");

        for (Monstro monstro : new ArrayList<>(monstros)) {
            if (!monstro.estaVivo()) continue; 

            System.out.println("\n>>> Um " + monstro.getNome() + " surge! <<<");

            while (heroi.estaVivo() && monstro.estaVivo()) {
                Combatente primeiro = (heroi.getVelocidade() >= monstro.getVelocidade()) ? heroi : monstro;
                Combatente segundo = (primeiro == heroi) ? monstro : heroi;

                turno(primeiro, segundo);
                if (!segundo.estaVivo()) break;
                turno(segundo, primeiro);
            }

            if (!heroi.estaVivo()) {
                System.out.println("Seu herói caiu em combate...");
                return;
            }

            if (!monstro.estaVivo()) {
                System.out.println(monstro.getNome() + " foi derrotado!");
                List<Item> loot = monstro.droparLoot();
                if (!loot.isEmpty()) {
                    System.out.println("Loot deixado para trás (coleta automática ao fim da batalha).");
                }
            }
        }
        concluida = true;
        System.out.println("*** Fase concluída: " + this.nome + " ***");
    }

    private void turno(Combatente atacante, Combatente alvo) {
        AcaoDeCombate acao = atacante.escolherAcao(alvo);
        System.out.println(atacante.getNome() + " usa: " + acao.getClass().getSimpleName());
        acao.executar(atacante, alvo);
    }
}