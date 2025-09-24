package com.rpg.Personagens.Herois.HeroisConcretos.Juggernault;


import com.rpg.Interfaces.Combate.AcaoDeCombate;
import com.rpg.Interfaces.Combate.Combatente;

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