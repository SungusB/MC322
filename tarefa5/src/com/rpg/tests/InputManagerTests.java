package com.rpg.tests;

import com.rpg.util.InputManager;
import org.junit.jupiter.api.*;
import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Classe de testes unitários para a classe utilitária {@link InputManager}.
 * Simula a entrada do usuário (System.in) para testar os métodos de leitura.
 */
class InputManagerTest 
{

    private final InputStream systemInBackup = System.in;
    private ByteArrayInputStream testIn;

    /**
     * Define uma nova entrada simulada para o System.in para o teste atual.
     * @param data A string que simula a entrada do usuário, incluindo quebras de linha.
     */
    private void provideInput(String data) 
    {
        testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
        // IMPORTANTE: Reinicializa o Scanner estático para usar o novo System.in
        InputManager.reinicializarScanner(); 
    }

    /**
     * Método de limpeza que é executado após cada teste.
     * Restaura o System.in original e reinicializa o Scanner.
     */
    @AfterEach
    void restoreSystemIn() 
    {
        System.setIn(systemInBackup);
        // Opcional: Reinicializar o Scanner para o próximo teste ou uso normal
        InputManager.reinicializarScanner();
    }

    /**
     * Testa se o método {@code lerString} consegue ler e retornar corretamente
     * uma string de entrada válida.
     */
    @Test
    void testLerString_valida() 
    {
        provideInput("Sungus\n");
        String resultado = InputManager.lerString("Digite seu nome:");
        assertEquals("Sungus", resultado);
    }

    /**
     * Testa se o método {@code lerSimNao} retorna {@code true} quando o usuário digita 's'.
     */
    @Test
    void testLerSimNao_sim() 
    {
        provideInput("s\n");
        boolean resultado = InputManager.lerSimNao("Confirma?");
        assertTrue(resultado);
    }

    /**
     * Testa se o método {@code lerSimNao} retorna {@code false} quando o usuário digita 'n'.
     */
    @Test
    void testLerSimNao_nao() 
    {
        provideInput("n\n");
        boolean resultado = InputManager.lerSimNao("Confirma?");
        assertFalse(resultado);
    }

    /**
     * Testa se o método {@code lerSimNao} trata entradas inválidas
     * e só retorna o resultadoado após receber uma entrada válida ('s' ou 'n').
     */
    @Test
    void testLerSimNao_invalidoDepoisValido() 
    {
        provideInput("talvez\nn\n");
        boolean resultado = InputManager.lerSimNao("Confirma?");
        assertFalse(resultado);
    }

    /**
     * Testa se o método {@code esperarEnter} é executado sem lançar exceções
     * quando recebe uma quebra de linha simulada (pressionar ENTER).
     */
    @Test
    void testEsperarEnter() 
    {
        provideInput("\n");
        assertDoesNotThrow(() -> InputManager.esperarEnter("Pressione ENTER"));
    }
}