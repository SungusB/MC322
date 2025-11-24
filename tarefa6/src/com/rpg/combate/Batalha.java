package com.rpg.combate;

import com.rpg.cenario.Fase;
import com.rpg.personagens.Herois.Heroi;
import com.rpg.util.GerenciadorDePersistencia;
import com.rpg.menu.MenuPosTurno;
import jakarta.xml.bind.annotation.*;
import java.util.List;

/**
 * Classe responsável por gerenciar o estado de uma aventura.
 */
@XmlRootElement(name = "batalha")
@XmlAccessorType(XmlAccessType.FIELD)
public class Batalha {

    @XmlElement(name = "heroi")
    private Heroi heroi;

    @XmlElementWrapper(name = "campanha")
    @XmlElement(name = "fase")
    private List<Fase> campanha;

    @XmlElement
    private int indiceFaseAtual;

    public Batalha() { }

    public Batalha(Heroi heroi, List<Fase> campanha) {
        this.heroi = heroi;
        this.campanha = campanha;
        this.indiceFaseAtual = 0;
    }

    public static Batalha carregarJogo(String nomeBatalha) {
        return GerenciadorDePersistencia.carregarBatalha(nomeBatalha);
    }

    public void jogar() {
        System.out.println(">>> Aventura Iniciada! <<<");
        
        while (!isFinalizada()) {
            executarProxFase();
            
            try { Thread.sleep(1000); } catch (InterruptedException e) {}
        }

        System.out.println("=== Fim da Aventura ===");
    }

    /**
     * Executa a lógica de uma única fase e o menu pós-turno.
     */
    public void executarProxFase() {
        if (heroi == null || !heroi.estaVivo()) return;
        if (campanha == null || indiceFaseAtual >= campanha.size()) return;

        Fase faseAtual = campanha.get(indiceFaseAtual);
        
        if (faseAtual.isConcluida()) {
            indiceFaseAtual++;
            return;
        }

        System.out.println("\n=== INICIANDO FASE " + (indiceFaseAtual + 1) + " ===");
        
        faseAtual.executar(heroi);

        if (heroi.estaVivo()) {
                System.out.println("Fase " + (indiceFaseAtual + 1) + " vencida!");
            indiceFaseAtual++;

            if (indiceFaseAtual < campanha.size()) {
                MenuPosTurno menu = new MenuPosTurno();
                menu.executar(this); 
            } else {
                System.out.println("\nPARABÉNS! Você completou todas as fases da campanha!");
            }
        } else {
            System.out.println("\nGAME OVER: Você foi derrotado na fase " + (indiceFaseAtual + 1) + ".");
        }
    }

    public boolean isFinalizada() {
        return !heroi.estaVivo() || indiceFaseAtual >= campanha.size();
    }

    public Heroi getHeroi() { return heroi; }
    public void setHeroi(Heroi heroi) { this.heroi = heroi; }
    public List<Fase> getCampanha() { return campanha; }
    public void setCampanha(List<Fase> campanha) { this.campanha = campanha; }
    public int getIndiceFaseAtual() { return indiceFaseAtual; }
    public void setIndiceFaseAtual(int indiceFaseAtual) { this.indiceFaseAtual = indiceFaseAtual; }
}