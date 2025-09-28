package com.rpg.itens;

import java.util.List;

public interface Lootavel
{
    //retorna o loot gerado por entidade;
    List<Item> droparLoot();
}

