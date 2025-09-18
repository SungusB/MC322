package com.rpg.Personagens.Herois;

import com.rpg.Interfaces.Combate.AcaoDeCombate;
import com.rpg.Personagens.Personagem;
import com.rpg.Personagens.AtaqueFisico;
import com.rpg.Armas.Arma;
import java.util.ArrayList;
import java.util.List;

import javax.lang.model.type.NullType;


public abstract class Heroi extends Personagem
{
    protected int xp;
    protected int nivel;
    protected Arma armaEquipada;

    public Heroi(String nome, int vidaMaxima, int danoAtaque, int velocidade, double percentualDefesa)
    {
        super(nome, vidaMaxima, danoAtaque, velocidade, percentualDefesa);
        this.xp = 0;
        this.nivel = 1;
        this.armaEquipada = null;
    }

    public void equiparArma(Arma novaArma)
    {
        if (this.nivel >= novaArma.getNivelReq())
        {  
            this.armaEquipada=novaArma;
            System.out.println(this.nome + " equipou " + novaArma.getNome() + ".");
        }
        else 
        {
            System.out.println(this.nome + " nao tem nivel suficiente.");
        }
    }

    public void ganharXp(int quantidade)
    {
        this.xp += quantidade;
        System.out.println(this.nome + " recebeu " + quantidade + " de XP.")
        if (this.xp >= nivel*100)
        {
            this.nivel += 1;
            this.xp = 0;
            System.out.println(this.nome + " upou de nivel.");
        }
    }

    @Override
    public int getDanoAtaque()
    {
        int bonusDano = (armaEquipada != null) ? armaEquipada.getBonusDano() : 0;
        return super.danoAtaque + bonusDano;
    }

    @Override
    public int getVelocidade()
    {
        int bonusVel = (armaEquipada != null) ? armaEquipada.getBonusVelocidade() : 0;
        return super.velocidade + bonusVel;
    }



    @Override
    public final List <AcaoDeCombate> getAcoesDisponiveis()
    {
        List<AcaoDeCombate> acoes = new ArrayList<>;

        acoes.add(new AtaqueFisico(this.danoAtaque));
        acoes.add(new Defesa(this.percentualDefesa));
        acoes.add(new Esquiva(this.velocidade));
        
        AcaoDeCombate habilidadeEspecial = getHabilidadeEspecial();
        acoes.add(habilidadeEspecial);
        
        return acoes;
    }

    public abstract AcaoDeCombate getHabilidadeEspecial();
}