package com.rpg.personagens.Herois;

import com.rpg.combate.AcaoDeCombate;
import com.rpg.personagens.Personagem;
import com.rpg.itens.Arma;
import com.rpg.exceptions.NivelInsuficienteException;
import java.util.ArrayList;
import java.util.List;



public abstract class Heroi extends Personagem
{
    protected int xp;
    protected int nivel;
    protected Arma armaEquipada;
    protected double modificadorDeDano = 1.0; 
    protected double modificadorDeVelocidade = 1.0;

    public Heroi(String nome, int vidaMaxima, int danoAtaque, int velocidade, double percentualDefesa)
    {
        super(nome, vidaMaxima, danoAtaque, velocidade, percentualDefesa);
        this.xp = 0;
        this.nivel = 1;
        this.armaEquipada = null;
    }

    public void setModificadorDeDano(double multiplicador) 
    {
        this.modificadorDeDano = multiplicador;
    }

    public void setModificadorDeVelocidade(double multiplicador) 
    {
        this.modificadorDeVelocidade = multiplicador;
    }

    public void resetarModificadores() 
    {
        this.modificadorDeDano = 1.0;
        this.modificadorDeVelocidade = 1.0;
    }

    public void equiparArma(Arma novaArma) throws NivelInsuficienteException 
    {
        if (this.nivel >= novaArma.getNivelReq()) 
        {
            this.armaEquipada = novaArma;
            System.out.println(this.nome + " equipou " + novaArma.getNome() + ".");
        } 
        else 
        {
            throw new NivelInsuficienteException(this.nome + " não tem nível suficiente para equipar " + novaArma.getNome() + ".");
        }
}

    public void ganharXp(int quantidade)
    {
        this.xp += quantidade;
        System.out.println(this.nome + " recebeu " + quantidade + " de XP.");
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
        int danoBaseComArma = super.danoAtaque + ((armaEquipada != null) ? armaEquipada.getBonusDano() : 0);
        return (int) (danoBaseComArma * this.modificadorDeDano);
    }

    @Override
    public int getVelocidade() 
    {
        int velBaseComArma = super.velocidade + ((armaEquipada != null) ? armaEquipada.getBonusVelocidade() : 0);
        
        return (int) (velBaseComArma * this.modificadorDeVelocidade);
    }


    @Override
    public int getVidaMaxima()
    {
        int bonusVida = (armaEquipada != null) ? armaEquipada.getBonusVidaMaxima() : 0;
        return super.vidaMaxima + bonusVida;
    }

    @Override
    protected List<AcaoDeCombate> getAcoesUnicas() {
        List<AcaoDeCombate> acoes = new ArrayList<>();
        acoes.add(getHabilidadeEspecial()); // Just provide the special ability
        return acoes;
    }


    public abstract AcaoDeCombate getHabilidadeEspecial();
}