package com.rpg.menu;

import com.rpg.combate.Batalha;
import com.rpg.util.GerenciadorDePersistencia;
import com.rpg.util.InputManager;

public class MenuPosTurno 
{

    public MenuPosTurno() {}

    public void executar(Batalha batalha)
    {
        boolean continuar = true;

        while (continuar) {
            System.out.println("\n--- FIM DO TURNO / FASE ---");
            System.out.println("1. Ver Status do Herói");
            System.out.println("2. Equipar Itens (Loot)"); 
            System.out.println("3. Salvar Jogo");
            System.out.println("4. Continuar para a próxima fase");
            
            int escolha = InputManager.lerInteiro("Escolha uma opção: ", 1, 4);

            switch (escolha) {
                case 1:
                    System.out.println("Vida: " + batalha.getHeroi().getVidaMaxima()); 
                    break;
                case 2:
                    System.out.println("Funcionalidade de inventário...");
                    break;
                case 3:
                    System.out.println("Salvando o jogo...");
                    GerenciadorDePersistencia.salvarBatalha(batalha, "savegame");
                    break;
                case 4:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}