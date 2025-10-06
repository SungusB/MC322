package com.rpg.combate;

/**
 * Interface que define uma ação que pode ser executada em combate.
 */
public interface AcaoDeCombate
{
    /**
     * Executa a ação de combate do usuário contra o alvo.
     * @param usuario O combatente que está executando a ação.
     * @param alvo O combatente que está recebendo a ação.
     */
    void executar(Combatente usuario, Combatente alvo);
}