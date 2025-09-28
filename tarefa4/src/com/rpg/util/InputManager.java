package com.rpg.util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputManager {
    private static final Scanner scanner = new Scanner(System.in);

    public static int lerInteiro(String mensagem, int min, int max) 
    {
    
        int valor = 0;
        boolean valido = false;

        do 
        {
            System.out.print(mensagem + " ");
            try 
            {
                valor = Integer.parseInt(scanner.nextLine().trim());
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

    public static String lerString(String mensagem) 
    {
        System.out.print(mensagem + " ");
        return scanner.nextLine();
    }

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

    public static void esperarEnter(String mensagem) 
    {
        System.out.print(mensagem);
        scanner.nextLine();
    }

    public static void fecharScanner() 
    {
        scanner.close();
    }
}