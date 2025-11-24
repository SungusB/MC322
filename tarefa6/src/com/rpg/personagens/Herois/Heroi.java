package com.rpg.personagens.Herois;

import com.rpg.combate.AcaoDeCombate;
import com.rpg.personagens.Personagem;
import com.rpg.itens.Arma;
import com.rpg.exceptions.NivelInsuficienteException;
import com.rpg.personagens.Herois.HeroisConcretos.Hunter.Hunter;
import com.rpg.personagens.Herois.HeroisConcretos.Juggernault.Juggernaut;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlSeeAlso;

import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "heroi")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso({Hunter.class, Juggernaut.class})
public abstract class Heroi extends Personagem {
    
    protected int xp;
    protected int nivel;
    
    @XmlElement(name = "armaEquipada") 
    protected Arma armaEquipada;
    
    protected double modificadorDeDano = 1.0; 
    protected double modificadorDeVelocidade = 1.0;

    public Heroi() {
        super();
    }

    public Heroi(String nome, int vidaMaxima, int danoAtaque, int velocidade, double percentualDefesa) {
        super(nome, vidaMaxima, danoAtaque, velocidade, percentualDefesa);
        this.xp = 0;
        this.nivel = 1;
        this.armaEquipada = null;
    }

    
    public void setModificadorDeDano(double multiplicador) { 
        this.modificadorDeDano = multiplicador; 
    }

    public void setModificadorDeVelocidade(double multiplicador) { 
        this.modificadorDeVelocidade = multiplicador; 
    }
    
    public void resetarModificadores() {
        this.modificadorDeDano = 1.0;
        this.modificadorDeVelocidade = 1.0;
    }
    
    public void equiparArma(Arma novaArma) throws NivelInsuficienteException {
        if (this.nivel >= novaArma.getNivelReq()) {
            this.armaEquipada = novaArma;
            System.out.println(this.nome + " equipou " + novaArma.getNome());
        } else {
            throw new NivelInsuficienteException("Nível insuficiente para equipar " + novaArma.getNome());
        }
    }

    public void ganharXp(int quantidade) {
        this.xp += quantidade;
        System.out.println(this.nome + " ganhou " + quantidade + " XP.");
        
        if (this.xp >= nivel * 100) {
            this.nivel++;
            this.xp = 0; 
            System.out.println("PARABÉNS! " + this.nome + " subiu para o nível " + this.nivel + "!");
            
            this.vidaAtual = this.getVidaMaxima();
        }
    }

    @Override
    public int getDanoAtaque() {
        int danoBaseComArma = super.danoAtaque + ((armaEquipada != null) ? armaEquipada.getBonusDano() : 0);
        return (int) (danoBaseComArma * this.modificadorDeDano);
    }

    @Override
    public int getVelocidade() {
        int velBaseComArma = super.velocidade + ((armaEquipada != null) ? armaEquipada.getBonusVelocidade() : 0);
        return (int) (velBaseComArma * this.modificadorDeVelocidade);
    }

    @Override
    public int getVidaMaxima() {
        int bonusVida = (armaEquipada != null) ? armaEquipada.getBonusVidaMaxima() : 0;
        return super.vidaMaxima + bonusVida;
    }


    @Override
    protected List<AcaoDeCombate> getAcoesUnicas() {
        List<AcaoDeCombate> acoes = new ArrayList<>();
        acoes.add(getHabilidadeEspecial()); 
        return acoes;
    }

    public abstract AcaoDeCombate getHabilidadeEspecial();
    
    @Override
    public int getAtaque() {
        return this.getDanoAtaque();
    }

    @Override
    public int getDefesa() {
        return 0; 
    }
    
    
    public int getNivel() { return nivel; }
    public void setNivel(int nivel) { this.nivel = nivel; }
    
    public int getXp() { return xp; }
    public void setXp(int xp) { this.xp = xp; }

    public Arma getArmaEquipada() { return armaEquipada; }
    public void setArmaEquipada(Arma arma) { this.armaEquipada = arma; }
}