package com.rpg.itens.ArmasConcretas;
import com.rpg.itens.Arma;
import com.rpg.itens.Item;

/**
 * Arma concreta: Espada Rúnica. Arma de nível baixo (Nv 1) com bônus de vida máxima.
 */
public class EspadaRunica extends Arma implements Item{

    /**
     * Construtor para EspadaRunica.
     */
    public EspadaRunica() {
        super("Espada Rúnica", 1);
    }

    /**
     * @return Bônus de Dano: 25.
     */
    @Override
    public int getBonusDano() {
        return 25; 
    }

    /**
     * @return Bônus de Velocidade: 0.
     */
    @Override
    public int getBonusVelocidade() {
        return 0; 
    }

    /**
     * @return Bônus de Vida Máxima: 200.
     */
    @Override
    public int getBonusVidaMaxima() {
        return 200; 
    }
}