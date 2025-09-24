package com.rpg.Armas.ArmasConcretas;

import com.rpg.Armas.Arma;
import com.rpg.Interfaces.Recompensa.Item;

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