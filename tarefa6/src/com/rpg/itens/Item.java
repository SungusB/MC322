package com.rpg.itens;

import jakarta.xml.bind.annotation.XmlSeeAlso;

@XmlSeeAlso({Arma.class})
public interface Item
{
    String getNome();
}