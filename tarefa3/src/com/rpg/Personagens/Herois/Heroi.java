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
        this.xp = xp;
        this.nivel = nivel;
        this.armaEquipada = null;
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