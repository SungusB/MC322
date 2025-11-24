package com.rpg.itens;

import com.rpg.itens.ArmasConcretas.AdagaLusiada;
import com.rpg.itens.ArmasConcretas.EspadaRunica;
import com.rpg.itens.ArmasConcretas.MachadoLunar;

// Imports essenciais para o JAXB funcionar com classes abstratas
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlSeeAlso;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso({AdagaLusiada.class, EspadaRunica.class, MachadoLunar.class})
public abstract class Arma
{
    protected String nome;
    protected int nivelReq;

    // Construtor vazio OBRIGATÓRIO para JAXB
    public Arma() {}

    public Arma(String nome, int nivelReq)
    {
        this.nome = nome;
        this.nivelReq = nivelReq;
    }

    public String getNome() { return nome; }
    public int getNivelReq() { return nivelReq; }

    public abstract int getBonusDano();
    public abstract int getBonusVelocidade();
    public abstract int getBonusVidaMaxima();
}