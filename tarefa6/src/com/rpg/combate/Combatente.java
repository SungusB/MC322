package com.rpg.combate;

/**
 * Interface que define qualquer entidade capaz de participar de um combate no RPG.
 * Atualizada para remover a necessidade de casting (Requisito 3.5).
 */
public interface Combatente
{
    String getNome();
    boolean estaVivo();
    void receberDano(int dano);
    void receberCura(int cura);
    AcaoDeCombate escolherAcao(Combatente alvo);

    
    /**
     * Retorna o valor total de ataque do combatente
     */
    int getAtaque();

    /**
     * Retorna o valor total de defesa do combatente.
     */
    int getDefesa();

    /**
     * Prepara o estado de defesa para o turno.
     */
    void prepararDefesa();

    /**
     * Prepara o estado de esquiva para o turno.
     */
    void prepararEsquiva();
}