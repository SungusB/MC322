package com.rpg.itens.ArmasConcretas;
import com.rpg.itens.Arma;
import com.rpg.itens.Item;

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
