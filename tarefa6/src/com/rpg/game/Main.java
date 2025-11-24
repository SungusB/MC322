package com.rpg.game;

import com.rpg.combate.Batalha;
import com.rpg.menu.MenuPrincipal;

public class Main {

    public static void main(String[] args) {
        System.out.println("Bem-vindo ao RPG Lab!");
        
        MenuPrincipal menuPrincipal = new MenuPrincipal();
        
        while (true) {
            Batalha batalhaAtual = menuPrincipal.exibirMenu();

            if (batalhaAtual != null) {
                batalhaAtual.jogar();
            }
        }
    }
}