package com.rpg.itens;

import java.util.List;

/**
 * Interface que define entidades que podem gerar loot (itens).
 */
public interface Lootavel
{
    /**
     * Retorna a lista de itens gerada pela entidade ao ser derrotada.
     * @return Uma lista de objetos Item que caíram como loot.
     */
    List<Item> droparLoot();
}