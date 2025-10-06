package com.rpg.menu;

import com.rpg.util.InputManager;
import com.rpg.personagens.Herois.Heroi;
import com.rpg.itens.Item;
import com.rpg.itens.Arma;
import com.rpg.exceptions.NivelInsuficienteException;

import java.util.List;

/**
 * Classe responsável por exibir o menu de opções após a derrota de um monstro.
 * Permite interagir com o loot, ver informações do herói ou continuar/desistir.
 */
public class MenuPosTurno {

    private List<Item> lootAtual;

    /**
     * Construtor para MenuPosTurno.
     * Inicializa o loot com uma lista vazia.
     */
    public MenuPosTurno() {
        this.lootAtual = List.of();
    }

    /**
     * Define a lista de loot disponível para o menu atual.
     * @param loot A lista de itens dropados pelo monstro derrotado.
     */
    public void setLoot(List<Item> loot) {
        this.lootAtual = loot;
    }

    /**
     * Exibe o menu pós-combate e gerencia as ações do usuário (interagir com loot, ver info, continuar, desistir).
     * @param heroi O herói atual.
     * @param lootDisponivel Indica se há loot para ser processado.
     * @return {@code true} se o usuário escolheu continuar a aventura, {@code false} se desistiu.
     */
    public boolean exibir(Heroi heroi, boolean lootDisponivel) {
        boolean continuar = true;

        while (true) {
            System.out.println("\n=== Pós-Combate ===");
            System.out.println("[1] Interagir com o Loot " + (lootDisponivel ? "" : "(nenhum disponível)"));
            System.out.println("[2] Ver Informações do Personagem");
            System.out.println("[3] Desistir do Jogo");
            System.out.println("[4] Continuar a aventura");

            int opcao = InputManager.lerInteiro("Escolha uma opção >", 1, 4);

            switch (opcao) {
                case 1 -> {
                    if (lootDisponivel && !lootAtual.isEmpty()) {
                        System.out.println("Você encontrou o seguinte loot:");
                        for (int i = 0; i < lootAtual.size(); i++) {
                            System.out.println("[" + (i + 1) + "] " + lootAtual.get(i).getNome());
                        }

                        int escolha = InputManager.lerInteiro(
                                "Escolha o item para tentar equipar ou 0 para ignorar", 
                                0, lootAtual.size()
                        );

                        if (escolha != 0) {
                            Item item = lootAtual.get(escolha - 1);
                            if (item instanceof Arma arma) {
                                try {
                                    heroi.equiparArma(arma);
                                    lootAtual.remove(item);
                                    if (lootAtual.isEmpty()) lootDisponivel = false;
                                } catch (NivelInsuficienteException e) {
                                    System.out.println(e.getMessage());
                                }
                            } else {
                                System.out.println("Não é possível equipar este item agora.");
                            }
                        }
                    } else {
                        System.out.println("Não há loot para coletar.");
                    }
                }

                case 2 -> {
                    System.out.println("\n=== Informações do Personagem ===");
                    System.out.println(heroi);
                    InputManager.esperarEnter("Pressione ENTER para continuar...");
                }

                case 3 -> {
                    System.out.println("Você desistiu da aventura...");
                    continuar = false;
                    return continuar;
                }

                case 4 -> {
                    return true;
                }
            }
        }
    }
}