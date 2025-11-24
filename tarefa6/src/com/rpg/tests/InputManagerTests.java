package com.rpg.tests;

import com.rpg.util.InputManager;
import org.junit.jupiter.api.*;
import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class InputManagerTest 
{

    private final InputStream systemInBackup = System.in;
    private ByteArrayInputStream testIn;

    private void provideInput(String data) 
    {
        testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
        InputManager.reinicializarScanner(); 
    }

    @AfterEach
    void restoreSystemIn() 
    {
        System.setIn(systemInBackup);
        InputManager.reinicializarScanner();
    }

    @Test
    void testLerString_valida() 
    {
        provideInput("Sungus\n");
        String resultado = InputManager.lerString("Digite seu nome:");
        assertEquals("Sungus", resultado);
    }

    @Test
    void testLerSim() 
    {
        provideInput("s\n");
        boolean resultado = InputManager.lerSimNao("Confirma?");
        assertTrue(resultado);
    }

    @Test
    void testLerNao() 
    {
        provideInput("n\n");
        boolean resultado = InputManager.lerSimNao("Confirma?");
        assertFalse(resultado);
    }

    @Test
    void testLerSimNao_invalidoDepoisValido() 
    {
        provideInput("talvez\nn\n");
        boolean resultado = InputManager.lerSimNao("Confirma?");
        assertFalse(resultado);
    }

    @Test
    void testEsperarEnter() 
    {
        provideInput("\n");
        assertDoesNotThrow(() -> InputManager.esperarEnter("Pressione ENTER"));
    }
}