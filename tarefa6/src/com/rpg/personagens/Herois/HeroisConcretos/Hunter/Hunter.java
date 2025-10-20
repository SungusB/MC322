package com.rpg.personagens.Herois.HeroisConcretos.Hunter;

import com.rpg.personagens.Personagem;
import com.rpg.personagens.Herois.Heroi;
import com.rpg.combate.AcaoDeCombate;
import com.rpg.combate.Combatente;
import com.rpg.personagens.Herois.HeroisConcretos.Hunter.AtaqueDeRaiva;
import java.util.List;
import java.util.Random;

/**
 * Herói concreto: Hunter. Uma classe ágil e com alto dano explosivo (Habilidade: Ataque de Raiva).
 */
public class Hunter extends Heroi
{
    /**
     * Construtor para Hunter.
     * Define as estatísticas base (Vida 1600, Dano 280, Velocidade 60, Defesa 40%).
     */
    public Hunter()
    {
        super("Hunter", 1600, 280, 60, 0.4);
    }

    /**
     * Retorna a habilidade especial única do Hunter: Ataque de Raiva.
     * @return Uma nova instância de AtaqueDeRaiva.
     */
    @Override
    public AcaoDeCombate getHabilidadeEspecial()
    {
        return new AtaqueDeRaiva(this.getDanoAtaque());
    }

    /**
     * Define a inteligência artificial de combate do Hunter (se não for controlado pelo usuário).
     * Ação: Ataque=40%, Habilidade=35%, Esquiva=20%, Defesa=5%.
     * @param alvo O combatente alvo da ação.
     * @return A ação de combate escolhida.
     */
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