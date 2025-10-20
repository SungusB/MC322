package com.rpglab.test;

import com.rpg.util.InputManager;
import org.junit.jupiter.api.*;
import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class InputManagerTest {

    private InputStream inBackup;
    private PrintStream outBackup;
    private ByteArrayOutputStream outContent;

    @BeforeEach
    void setup() {
        inBackup = System.in;
        outBackup = System.out;
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void teardown() {
        System.setIn(inBackup);
        System.setOut(outBackup);
        InputManager.reinicializarScanner();
    }

    private void provideInput(String data) {
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        InputManager.reinicializarScanner();
    }

    @Test
    void testLerSimNao_invalidoDepoisValido_deveInformarErro() {
        provideInput("talvez\ns\n");
        boolean result = InputManager.lerSimNao("Confirma?");
        String saida = outContent.toString();
        assertTrue(saida.toLowerCase().contains("resposta inválida") || saida.toLowerCase().contains("inválid"),
                "Deveria informar erro ao usuário quando a entrada é inválida");
        assertTrue(result, "Após entrada inválida, a segunda resposta 's' deve ser aceita como true");
    }

    @Test
    void testLerInteiro_invalidoDepoisValido_deveInformarErro() {
        provideInput("abc\n2\n");
        int valor = InputManager.lerInteiro("Escolha >", 1, 3);
        String saida = outContent.toString();
        assertTrue(saida.toLowerCase().contains("valor inválido") || saida.toLowerCase().contains("inválid"),
                "Deveria informar erro ao usuário quando o número está fora do intervalo ou não é inteiro");
        assertEquals(2, valor, "Após entrada inválida, a segunda entrada válida deve ser retornada");
    }

    @Test
    void testEsperarEnter_naoLancaExcecao() {
        provideInput("\n");
        assertDoesNotThrow(() -> InputManager.esperarEnter("Pressione ENTER"));
    }
}
