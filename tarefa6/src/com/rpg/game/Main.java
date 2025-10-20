package com.rpg.game;

import com.rpg.menu.MenuPrincipal;

/**
 * Ponto de entrada principal da aplicação RPG.
 * Responsável por iniciar o menu principal do jogo.
 */
public class Main {
    
    /**
     * Método principal que inicializa e exibe o MenuPrincipal.
     * @param args Argumentos de linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        
        MenuPrincipal menu = new MenuPrincipal();
        menu.exibir();

        System.out.println(":Q");
    }
}