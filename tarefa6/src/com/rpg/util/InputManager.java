// src/com/rpg/util/InputManager.java
package com.rpg.util;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Classe utilitária para gerenciar e simplificar a leitura de entrada do usuário (System.in).
 */
public class InputManager {
    // Torna o scanner não-final para permitir reinicialização
    private static Scanner scanner = new Scanner(System.in); 

    /**
     * Fecha o Scanner existente e cria um novo, usando o System.in atual.
     * Essencial para testes unitários que simulam entrada.
     */
    public static void reinicializarScanner() {
        // Verifica se o scanner é nulo para evitar NullPointerException na primeira chamada
        if (scanner != null) {
            scanner.close(); // Fechar o scanner anterior
        }
        // Cria um novo Scanner com o System.in atual (que pode ter sido modificado pelo teste)
        scanner = new Scanner(System.in); 
    }

    /**
     * Solicita ao usuário um número inteiro dentro de um intervalo.
     * Repete a solicitação até que a entrada seja válida.
     * @param mensagem A mensagem de prompt a ser exibida.
     * @param min O valor mínimo aceito.
     * @param max O valor máximo aceito.
     * @return O inteiro lido e validado.
     */
    public static int lerInteiro(String mensagem, int min, int max) 
    {
    
        int valor = 0;
        boolean valido = false;

        do 
        {
            System.out.print(mensagem + " ");
            try 
            {
                // Certifica-se de que o scanner está lendo do System.in atualizado
                String linha = scanner.nextLine().trim();
                valor = Integer.parseInt(linha);
                
                if (valor < min || valor > max) 
                {
                    System.out.println("Valor inválido! Digite um número entre " + min + " e " + max + ".");
                } 
                else 
                {
                    valido = true;
                }
            } 
            catch (NumberFormatException e) 
            {
                System.out.println("Entrada inválida! Digite um número inteiro.");
            }
        } while (!valido);

        return valor;
    }

    /**
     * Solicita ao usuário uma string (uma linha de texto).
     * @param mensagem A mensagem de prompt a ser exibida.
     * @return A string lida.
     */
    public static String lerString(String mensagem) 
    {
        System.out.print(mensagem + " ");
        return scanner.nextLine();
    }

    /**
     * Solicita ao usuário uma confirmação 's' (sim) ou 'n' (não).
     * Repete a solicitação até que a entrada seja válida.
     * @param mensagem A mensagem de prompt a ser exibida.
     * @return {@code true} se 's' foi digitado, {@code false} se 'n' foi digitado.
     */
    public static boolean lerSimNao(String mensagem) 
    {
        String entrada;
        do 
        {
            System.out.print(mensagem + " ");
            entrada = scanner.nextLine().trim().toLowerCase();

            if (entrada.equals("s")) return true;
            if (entrada.equals("n")) return false;

            System.out.println("Entrada inválida! Digite 's' para sim ou 'n' para não.");
        } while (true);
    }

    /**
     * Pausa o programa, esperando que o usuário pressione ENTER.
     * @param mensagem A mensagem de prompt a ser exibida.
     */
    public static void esperarEnter(String mensagem) 
    {
        System.out.print(mensagem);
        scanner.nextLine();
    }

    /**
     * Fecha o Scanner global, liberando os recursos de entrada.
     */
    public static void fecharScanner() 
    {
        scanner.close();
    }
}