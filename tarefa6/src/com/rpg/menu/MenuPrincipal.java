package com.rpg.menu;

import com.rpg.cenario.Fase;
import com.rpg.cenario.ConstrutorDeCenarioFixo;
import com.rpg.cenario.GeradorDeFases;
import com.rpg.combate.Batalha;
import com.rpg.personagens.Herois.Heroi;
import com.rpg.personagens.Herois.HeroisConcretos.Hunter.Hunter;
import com.rpg.personagens.Herois.HeroisConcretos.Juggernault.Juggernaut;
import com.rpg.util.InputManager; 

import java.io.File;
import java.util.List;

public class MenuPrincipal {

    public MenuPrincipal() {}

    public Batalha exibirMenu() {
        System.out.println("\n=== MENU PRINCIPAL RPG ===");
        System.out.println("1. Iniciar Novo Jogo");
        
        boolean existeSave = new File("saves/savegame.xml").exists();
        if (existeSave) {
            System.out.println("2. Carregar Jogo");
        } else {
            System.out.println("2. (Sem jogo salvo)");
        }
        
        System.out.println("3. Info Heróis");
        System.out.println("4. Info Monstros");
        System.out.println("0. Sair");

        int escolha = InputManager.lerInteiro("Escolha: ", 0, 4);

        switch (escolha) {
            case 1:
                return configurarNovoJogo();
            case 2:
                if (existeSave) {
                    return carregarJogoExistente();
                } else {
                    System.out.println("Não existe nenhum jogo salvo para carregar.");
                }
                break;
            case 3:
                exibirInfoHerois(); 
                break;
            case 4:
                exibirInfoMonstros(); 
                break;
            case 0:
                System.exit(0);
            default:
                System.out.println("Opção inválida.");
        }
        return null; 
    }

    private Batalha configurarNovoJogo() {
        Heroi heroi = escolherHeroi();
        GeradorDeFases gerador = new ConstrutorDeCenarioFixo();
        List<Fase> campanha = gerador.gerar(3); 
        
        System.out.println("A campanha vai começar com o herói " + heroi.getNome() + "!");
        return new Batalha(heroi, campanha);
    }

    private Batalha carregarJogoExistente() {
        System.out.println("Carregando aventura...");
        return Batalha.carregarJogo("savegame"); 
    }

    private Heroi escolherHeroi() {
        System.out.println("\nEscolha seu Herói:");
        System.out.println("1. Hunter (Dano alto, pouca vida)");
        System.out.println("2. Juggernaut (Tanque, muita vida)");
        
        int opcao = InputManager.lerInteiro("Digite o número: ", 1, 2);
        if (opcao == 2) return new Juggernaut();
        return new Hunter(); 
    }

    private void exibirInfoHerois() { System.out.println("Info: Hunter e Juggernaut..."); }
    private void exibirInfoMonstros() { System.out.println("Info: Zumbis, Lobisomens..."); }
}