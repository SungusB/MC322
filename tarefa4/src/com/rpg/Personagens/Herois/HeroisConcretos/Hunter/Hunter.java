package com.rpg.Personagens.Herois.HeroisConcretos.Hunter;

import com.rpg.Personagens.Personagem;
import com.rpg.Personagens.Herois.Heroi;
import com.rpg.Interfaces.Combate.AcaoDeCombate;
import com.rpg.Interfaces.Combate.Combatente;
import com.rpg.Personagens.Herois.HeroisConcretos.Hunter.AtaqueDeRaiva;
import java.util.List;
import java.util.Random;

public class Hunter extends Heroi
{
    public Hunter()
    {
        super("Hunter", 1100, 140, 60, 0.4);
    }

    @Override
    public AcaoDeCombate getHabilidadeEspecial()
    {
        return new AtaqueDeRaiva(this.getDanoAtaque());
    }

    @Override
    public AcaoDeCombate escolherAcao(Combatente alvo) {
        List<AcaoDeCombate> acoes = getAcoesDisponiveis();
        Random random = new Random();

        // Pesos: Ataque=40%, Habilidade=35%, Esquiva=20%, Defesa=5%
        int chance = random.nextInt(100);

        if (chance < 40) 
        { // 40% ed chance de ataque fisico
            return acoes.get(0); // Posição 0 é AtaqueFisico
        } 
        
        else if (chance < 75) 
        { // 35% de chance de Habilidade Especial
            return acoes.get(3); // Posição 3 é a Habilidade Especial
        } 
        
        else if (chance < 95) 
        { // 20% de chance de Esquiva
            return acoes.get(2); // Posição 2 é Esquiva
        } 
        
        else 
        { // 5% de chance de Defesa
            return acoes.get(1); // Posição 1 é Defesa
        }
    }
}