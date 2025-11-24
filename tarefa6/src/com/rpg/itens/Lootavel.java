package com.rpg.itens;

import java.util.List;

/**
 * Interface que define entidades que podem gerar loot (itens).
 */
public interface Lootavel
{
    /**
     * @return Uma lista de objetos Item que caíram como loot.
     */
    List<Item> droparLoot();
}