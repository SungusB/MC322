package com.rpg.itens.ArmasConcretas;
import com.rpg.itens.Arma;
import com.rpg.itens.Item;

/**
 * Arma concreta: Adaga Lusíada. Arma de nível baixo (Nv 1) com bônus de velocidade.
 */
public class AdagaLusiada extends Arma implements Item{

    /**
     * Construtor para AdagaLusiada.
     */
    public AdagaLusiada() {
        super("Adaga Lusiada", 1);
    }

    /**
     * @return Bônus de Dano: 20.
     */
    @Override
    public int getBonusDano() {
        return 20; 
    }

    /**
     * @return Bônus de Velocidade: 15.
     */
    @Override
    public int getBonusVelocidade() {
        return 15; 
    }

    /**
     * @return Bônus de Vida Máxima: 0.
     */
    @Override
    public int getBonusVidaMaxima() {
        return 0; 
    }
}