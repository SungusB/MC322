package com.rpg.personagens.Herois.HeroisConcretos.Juggernault;

import com.rpg.personagens.Personagem;
import com.rpg.personagens.Herois.Heroi;
import com.rpg.combate.AcaoDeCombate;
import com.rpg.combate.Combatente;
import com.rpg.personagens.Herois.HeroisConcretos.Juggernault.RecuperarFolego;
import java.util.List;
import java.util.Random;

public class Juggernaut extends Heroi {

    public Juggernaut() 
    {
        super("Juggernaut", 1500, 100, 20, 0.6);
    }

    @Override
    public AcaoDeCombate getHabilidadeEspecial() 
    {
        return new RecuperarFolego(350);
    }

    @Override
    public AcaoDeCombate escolherAcao(Combatente alvo) 
    {
        List<AcaoDeCombate> acoes = getAcoesDisponiveis();
        Random random = new Random();

        // Pesos: Defesa=40%, Ataque=35%, Habilidade=15%, Esquiva=10% 
        int chance = random.nextInt(100);

        if (chance < 40) 
        { // 40% de chance de Defesa
            return acoes.get(1); // Posição 1 é Defesa
        } 
        
        else if (chance < 75) 
        { // 35% de chance de Ataque Básico
            return acoes.get(0); // Posição 0 é AtaqueFisico
        } 
        
        else if (chance < 90) 
        { // 15% de chance de Habilidade (Cura)
            return acoes.get(3); // Posição 3 é a Habilidade Especial
        }
        
        else 
        { // 10% de chance de Esquiva
            return acoes.get(2); // Posição 2 é Esquiva
        }
    }
}