package com.rpg.personagens.Herois.HeroisConcretos.Juggernault;

import com.rpg.combate.AcaoDeCombate;
import com.rpg.combate.Combatente;

/**
 * Habilidade especial do Juggernaut. Cura o usuário em uma quantidade fixa de vida.
 */
public class RecuperarFolego implements AcaoDeCombate
{
    private final int cura;    

    /**
     * Construtor para RecuperarFolego.
     * @param quantidadeCura A quantidade de pontos de vida a ser recuperada.
     */
    public RecuperarFolego(int quantidadeCura) 
    {
        this.cura = quantidadeCura;
    }

    /**
     * Executa a ação, aplicando a cura ao próprio Juggernaut.
     * @param usuario O Juggernaut.
     * @param alvo O alvo (não utilizado para cura, mas obrigatório pela interface).
     */
    @Override
    public void executar(Combatente usuario, Combatente alvo)
    {
        System.out.println(usuario.getNome() + " recuperou folego, se curando em " + this.cura + " de vida");
        usuario.receberCura(this.cura);
    }
}