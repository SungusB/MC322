package com.rpg.itens.ArmasConcretas;
import com.rpg.itens.Arma;
import com.rpg.itens.Item;

public class AdagaLusiada extends Arma implements Item{

    public AdagaLusiada() {
        super("Adaga Lusiada", 1);
    }

    @Override
    public int getBonusDano() {
        return 20; 
    }

    @Override
    public int getBonusVelocidade() {
        return 15; 
    }

    @Override
    public int getBonusVidaMaxima() {
        return 0; 
    }
}