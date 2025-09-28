package com.rpg.itens.ArmasConcretas;
import com.rpg.itens.Arma;
import com.rpg.itens.Item;

public class MachadoLunar extends Arma implements Item{

    public MachadoLunar() 
    {
        super("Machado Lunar", 3);
    }

    @Override
    public int getBonusDano() 
    {
        return 50; 
    }

    @Override
    public int getBonusVelocidade() 
    {
        return 0; 
    }

    @Override
    public int getBonusVidaMaxima() 
    {
        return 0; 
    }
}