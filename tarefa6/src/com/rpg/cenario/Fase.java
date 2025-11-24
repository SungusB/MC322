package com.rpg.cenario;

import com.rpg.personagens.Herois.Heroi;
import jakarta.xml.bind.annotation.XmlSeeAlso;

@XmlSeeAlso({FaseDeCombate.class})
public interface Fase
{
    void iniciar(Heroi heroi);
    boolean isConcluida();
    String getTipoDeCenario();
    
    default void executar(Heroi heroi) {
        iniciar(heroi);
    }
}