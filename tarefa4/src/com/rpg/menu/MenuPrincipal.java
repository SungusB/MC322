package com.rpg.menu;

import com.rpg.cenario.ConstrutorDeCenarioFixo;
import com.rpg.cenario.Dificuldade;
import com.rpg.cenario.Fase;
import com.rpg.cenario.FaseDeCombate;
import com.rpg.combate.Combatente;
import com.rpg.util.InputManager;
import com.rpg.personagens.Herois.Heroi;
import com.rpg.personagens.Herois.HeroisConcretos.Hunter.Hunter;
import com.rpg.personagens.Herois.HeroisConcretos.Juggernault.Juggernaut;

import java.util.List;

public class MenuPrincipal {

    public void exibir() {
        boolean executando = true;

        while (executando) {
            System.out.println("\nA VIAGEM AO REINO DE PORTUGAL - RPG");
            System.out.println("==================================================");
            System.out.println("[1] Iniciar Novo Jogo");
            System.out.println("[2] Ver Informações das Classes de Heróis");
            System.out.println("[3] Ver Informações das Classes de Monstros");
            System.out.println("[4] Sair do Jogo");
            System.out.println("==================================================");

            int opcao = InputManager.lerInteiro("Digite sua opção >", 1, 4);

            switch (opcao) {
                case 1 -> iniciarNovoJogo();
                case 2 -> mostrarInfoHerois();
                case 3 -> mostrarInfoMonstros();
                case 4 -> {
                    System.out.println("Saindo do jogo... Até logo!");
                    executando = false;
                    }
                }
            }

            InputManager.fecharScanner();
        }

    private void iniciarNovoJogo() {
        System.out.println("\n=== Escolha seu Herói ===");
        System.out.println("[1] Hunter - Mais ágil, dano explosivo.");
        System.out.println("[2] Juggernaut - Mais resistente, cura em combate.");

        int escolha = InputManager.lerInteiro("Selecione >", 1, 2);
        Heroi heroi = (escolha == 1) ? new Hunter() : new Juggernaut();
        System.out.println("Você escolheu: " + heroi.getNome());

        // Escolha da dificuldade
        System.out.println("\nEscolha a dificuldade:");
        System.out.println("[1] Fácil");
        System.out.println("[2] Normal");
        System.out.println("[3] Difícil");
        int difEscolha = InputManager.lerInteiro("Selecione >", 1, 3);

        Dificuldade dificuldade;
        switch (difEscolha) {
            case 1 -> dificuldade = Dificuldade.FACIL;
            case 2 -> dificuldade = Dificuldade.NORMAL;
            case 3 -> dificuldade = Dificuldade.DIFICIL;
            default -> dificuldade = Dificuldade.NORMAL;
        }

        ConstrutorDeCenarioFixo construtor = new ConstrutorDeCenarioFixo();
        List<Fase> campanha = construtor.gerar(3);

        for (Fase fase : campanha) {
            fase.iniciar(heroi);

            if (fase instanceof FaseDeCombate fd) {

                for (var monstro : fd.getMonstros()) { 
                    monstro.aplicarDificuldade(dificuldade);
                }

                fd.executarCombate(); 
            }

            if (!heroi.estaVivo()) {
                System.out.println("Fim da campanha.");
                return;
            }
        }

        System.out.println("Parabéns! Você concluiu todas as fases da campanha!");
    }



    private void mostrarInfoHerois() {
        System.out.println("\n=== CLASSES DE HERÓIS ===");
        System.out.println("Hunter: Vida 1100, Dano 140, Velocidade 60, Defesa 40%. Habilidade: Ataque de Raiva (dano x2).");
        System.out.println("Juggernaut: Vida 1500, Dano 100, Velocidade 20, Defesa 60%. Habilidade: Recuperar Fôlego (cura 350).");
        InputManager.esperarEnter("Pressione ENTER para voltar ao menu...");
    }

    private void mostrarInfoMonstros() {
        System.out.println("\n=== CLASSES DE MONSTROS ===");
        System.out.println("Fogo Fátuo: rápido, esquiva e ataca. Chance de dropar Espada Rúnica (20%).");
        System.out.println("Lobisomem: boss, vida alta, dropa Machado Lunar (100%).");
        System.out.println("Soldado Português: comum, versátil.");
        System.out.println("Soldado Português de Elite: mais forte, dropa Adaga Lusíada (100%).");
        System.out.println("Zumbi: lento e fraco, só ataca.");
        InputManager.esperarEnter("Pressione ENTER para voltar ao menu...");
    }
}
