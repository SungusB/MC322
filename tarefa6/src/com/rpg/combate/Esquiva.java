package com.rpg.combate;

import com.rpg.personagens.Personagem;
import com.rpg.combate.AcaoDeCombate;
import com.rpg.combate.Combatente;

/**
 * Representa a ação de Esquiva.
 * Ativa o estado de esquiva do usuário, que concede uma chance de evitar o próximo ataque.
 */
public class Esquiva implements AcaoDeCombate 
{
    /**
     * Construtor para Esquiva.
     * @param velocidade A velocidade do personagem (apenas para referência na instância).
     */
    public Esquiva(int velocidade) 
    {}

    /**
     * Ativa o estado de esquiva do personagem para o turno atual.
     * @param usuario O personagem que está se esquivando.
     * @param alvo O alvo (não utilizado para esquiva, mas obrigatório pela interface).
     */
    @Override
    public void executar(Combatente usuario, Combatente alvo) 
    {
        System.out.println(usuario.getNome() + " prepara esquiva.");
        if (usuario instanceof Personagem) 
        {
            ((Personagem) usuario).setEstadoDeEsquiva(true);
        }
    }
}