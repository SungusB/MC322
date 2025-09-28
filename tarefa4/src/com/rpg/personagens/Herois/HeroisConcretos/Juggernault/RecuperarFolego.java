package com.rpg.personagens.Herois.HeroisConcretos.Juggernault;

import com.rpg.combate.AcaoDeCombate;
import com.rpg.combate.Combatente;

public class RecuperarFolego implements AcaoDeCombate
{
    private final int cura;    

    public RecuperarFolego(int quantidadeCura) 
    {
        this.cura = quantidadeCura;
    }

    @Override
    public void executar(Combatente usuario, Combatente alvo)
    {
        System.out.println(usuario.getNome() + " recuperou folego, se curando em " + this.cura + " de vida");
        usuario.receberCura(this.cura);
    }
}