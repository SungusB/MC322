package com.rpg.personagens.Herois.HeroisConcretos.Juggernault;

import com.rpg.personagens.Personagem;
import com.rpg.personagens.Herois.Heroi;
import com.rpg.combate.AcaoDeCombate;
import com.rpg.combate.Combatente;
import com.rpg.personagens.Herois.HeroisConcretos.Juggernault.RecuperarFolego;
import java.util.List;
import java.util.Random;

/**
 * Herói concreto: Juggernaut. Uma classe resistente e focada em defesa e sustentabilidade (Habilidade: Recuperar Fôlego).
 */
public class Juggernaut extends Heroi {

    /**
     * Construtor para Juggernaut.
     * Define as estatísticas base (Vida 1900, Dano 140, Velocidade 30, Defesa 60%).
     */
    public Juggernaut() 
    {
        super("Juggernaut", 1900, 140, 30, 0.6);
    }

    /**
     * Retorna a habilidade especial única do Juggernaut: Recuperar Fôlego (Cura 350).
     * @return Uma nova instância de RecuperarFolego.
     */
    @Override
    public AcaoDeCombate getHabilidadeEspecial() 
    {
        return new RecuperarFolego(350);
    }

    /**
     * Define a inteligência artificial de combate do Juggernaut (se não for controlado pelo usuário).
     * Ação: Defesa=40%, Ataque=35%, Habilidade (Cura)=15%, Esquiva=10%.
     * @param alvo O combatente alvo da ação.
     * @return A ação de combate escolhida.
     */
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