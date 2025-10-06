package com.rpg.combate;

import com.rpg.personagens.Personagem;
import com.rpg.combate.Combatente;
import com.rpg.combate.AcaoDeCombate;

/**
 * Representa a ação de Defesa.
 * Ativa o estado de defesa do usuário, que reduz o dano recebido no próximo ataque.
 */
public class Defesa implements AcaoDeCombate 
{

    /**
     * Construtor para Defesa.
     * @param percentualDefesa O percentual de redução de dano do personagem (apenas para referência na instância).
     */
    public Defesa(double percentualDefesa) {}

    /**
     * Ativa o estado de defesa do personagem para o turno atual.
     * @param usuario O personagem que está se defendendo.
     * @param alvo O alvo (não utilizado para defesa, mas obrigatório pela interface).
     */
    @Override
    public void executar(Combatente usuario, Combatente alvo) {
        System.out.println(usuario.getNome() + " está se defendendo.");
        if (usuario instanceof Personagem) 
        {
            ((Personagem) usuario).setEstadoDeDefesa(true);
        }
    }
}