package com.rpg.combate;

/**
 * Interface que define qualquer entidade capaz de participar de um combate no RPG.
 */
public interface Combatente
{
    /**
     * Retorna o nome do combatente.
     * @return O nome do combatente.
     */
    String getNome();

    /**
     * Verifica se o combatente ainda está vivo.
     * @return {@code true} se a vida atual for maior que zero, {@code false} caso contrário.
     */
    boolean estaVivo();

    /**
     * Processa o recebimento de dano pelo combatente.
     * @param dano O valor do dano base a ser recebido.
     */
    void receberDano(int dano);

    /**
     * Aplica cura ao combatente, aumentando sua vida atual.
     * A vida não pode exceder a vida máxima.
     * @param cura A quantidade de pontos de vida a ser restaurada.
     */
    void receberCura(int cura);

    /**
     * Define a lógica para o combatente escolher uma ação a ser executada em um turno.
     * @param alvo O combatente que será o alvo da ação.
     * @return A ação de combate (Ataque, Defesa, Esquiva, Habilidade, etc.) escolhida.
     */
    AcaoDeCombate escolherAcao(Combatente alvo);
}