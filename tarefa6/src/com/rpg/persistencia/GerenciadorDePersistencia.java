package com.rpg.persistencia;

import java.io.*;
import java.nio.file.*;
import com.rpg.game.Batalha;

/**
 * Gerencia a persistência simples do estado do jogo.
 * Usa serialização binária de um DTO (Batalha) para minimizar alterações no projeto.
 */
public final class GerenciadorDePersistencia {

    private static final String DIR_SAVES = "saves";

    private GerenciadorDePersistencia() {}

    private static Path caminho(String nome) {
        return Paths.get(DIR_SAVES, nome + ".sav");
    }

    public static boolean existe(String nome) {
        return Files.exists(caminho(nome));
    }

    public static void salvarBatalha(Batalha b, String nomeBatalha) {
        try {
            Files.createDirectories(Paths.get(DIR_SAVES));
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(caminho(nomeBatalha).toFile()))) {
                oos.writeObject(b);
            }
            System.out.println("[SALVO] Jogo salvo como '" + nomeBatalha + "'.");
        } catch (IOException e) {
            System.err.println("[ERRO] Falha ao salvar jogo: " + e.getMessage());
        }
    }

    public static Batalha carregarBatalha(String nomeBatalha) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(caminho(nomeBatalha).toFile()))) {
            Object obj = ois.readObject();
            if (obj instanceof Batalha b) {
                System.out.println("[CARREGADO] Save '" + nomeBatalha + "' carregado.");
                return b;
            }
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("[ERRO] Falha ao carregar jogo: " + e.getMessage());
        }
        return null;
    }
}
