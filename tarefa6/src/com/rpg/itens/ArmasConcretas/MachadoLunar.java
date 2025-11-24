package com.rpg.itens.ArmasConcretas;
import com.rpg.itens.Arma;
import com.rpg.itens.Item;

/**
 * Arma concreta: Machado Lunar. 
 */
public class MachadoLunar extends Arma implements Item{

    /**
     * Construtor para MachadoLunar.
     */
    public MachadoLunar() 
    {
        super("Machado Lunar", 3);
    }

    /**
     * @return Bônus de Dano: 50.
     */
    @Override
    public int getBonusDano() 
    {
        return 50; 
    }

    /**
     * @return Bônus de Velocidade: 0.
     */
    @Override
    public int getBonusVelocidade() 
    {
        return 0; 
    }

    /**
     * @return Bônus de Vida Máxima: 0.
     */
    @Override
    public int getBonusVidaMaxima() 
    {
        return 0; 
    }
}