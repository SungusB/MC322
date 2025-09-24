package com.rpg.Armas.ArmasConcretas;

import com.rpg.Armas.Arma;
import com.rpg.Interfaces.Recompensa.Item;

public class EspadaRunica extends Arma implements Item{

    public EspadaRunica() {
        super("Espada Rúnica", 1);
    }

    @Override
    public int getBonusDano() {
        return 25; 
    }

    @Override
    public int getBonusVelocidade() {
        return 0; 
    }

    @Override
    public int getBonusVidaMaxima() {
        return 200; 
    }
}
