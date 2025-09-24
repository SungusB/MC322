package com.rpg.Personagens.Monstros.MonstrosConcretos;

import com.rpg.Interfaces.Recompensa.Item;
import com.rpg.Interfaces.Combate.AcaoDeCombate;
import com.rpg.Interfaces.Combate.Combatente;
import com.rpg.Personagens.Monstros.Monstro;
import java.util.ArrayList;
import java.util.List;

public class Zumbi extends Monstro 
{

    public Zumbi() 
    {
        // super(nome, vida, dano, vel, def, xp) - Dummy
        super("Zumbi", 250, 60, 10, 0.0, 25);
    }

    @Override
    public List<Item> droparLoot() 
    {
        // Zumbis não dropam itens.
        return new ArrayList<>();
    }

    // So ataca
    @Override
    public AcaoDeCombate escolherAcao(Combatente alvo) 
    {
        List<AcaoDeCombate> acoes = getAcoesDisponiveis();
        return acoes.get(0);
    }
}