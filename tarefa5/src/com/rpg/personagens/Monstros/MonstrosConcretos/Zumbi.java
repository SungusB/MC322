package com.rpg.personagens.Monstros.MonstrosConcretos;

import com.rpg.itens.Item;
import com.rpg.combate.AcaoDeCombate;
import com.rpg.combate.Combatente;
import com.rpg.personagens.Monstros.Monstro;
import java.util.ArrayList;
import java.util.List;

/**
 * Monstro concreto: Zumbi. Um monstro fraco, lento e sem defesa.
 * Não dropa itens.
 */
public class Zumbi extends Monstro 
{

    /**
     * Construtor para Zumbi.
     * Define as estatísticas base (Vida 250, Dano 60, Vel 10, Def 0.0, XP 25).
     */
    public Zumbi() 
    {
        // super(nome, vida, dano, vel, def, xp) - Dummy
        super("Zumbi", 250, 60, 10, 0.0, 25);
    }

    /**
     * Implementa a lógica de drop de loot.
     * Zumbis não dropam itens, retornando uma lista vazia.
     * @return Uma lista vazia de Itens.
     */
    @Override
    public List<Item> droparLoot() 
    {
        // Zumbis não dropam itens.
        return new ArrayList<>();
    }

    /**
     * Define a inteligência artificial de combate do Zumbi.
     * O Zumbi sempre escolhe Ataque Básico.
     * @param alvo O combatente alvo da ação.
     * @return A ação de combate escolhida (AtaqueFisico).
     */
    // So ataca
    @Override
    public AcaoDeCombate escolherAcao(Combatente alvo) 
    {
        List<AcaoDeCombate> acoes = getAcoesDisponiveis();
        return acoes.get(0);
    }
}