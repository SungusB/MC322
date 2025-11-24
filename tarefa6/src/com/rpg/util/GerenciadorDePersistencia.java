package com.rpg.util;

import java.io.File;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import jakarta.xml.bind.JAXBException;

import com.rpg.combate.Batalha; 
import com.rpg.personagens.Herois.HeroisConcretos.Hunter.Hunter;
import com.rpg.personagens.Herois.HeroisConcretos.Juggernault.Juggernaut;

/**
 * Classe salvar e carregar o estado do jogo.
 */
public class GerenciadorDePersistencia {

    private static final String PASTA_SALVAMENTO = "saves/";
    private static final String EXTENSAO = ".xml";

    /**
     * Salva o objeto Batalha para um arquivo XML.
     * @param batalha O objeto Batalha.
     * @param nomeBatalha O nome do arquivo de salvamento.
     */
    public static void salvarBatalha(Batalha batalha, String nomeBatalha) {
        File pasta = new File(PASTA_SALVAMENTO);
        if (!pasta.exists()) {
            pasta.mkdirs();
        }

        File arquivo = new File(PASTA_SALVAMENTO + nomeBatalha + EXTENSAO);

        try 
        {
            JAXBContext context = JAXBContext.newInstance(Batalha.class, Hunter.class, Juggernaut.class);

            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            m.marshal(batalha, arquivo);

            System.out.println("Jogo salvo com sucesso em: " + arquivo.getAbsolutePath());

        } 
        catch (JAXBException e) 
        {
            System.err.println("ERRO: Falha ao salvar a batalha. Verifique as anotações JAXB.");
            e.printStackTrace();
        }
    }

    /**
     * Carrega Batalha a partir do arquivo XML.
     * @param nomeBatalha O nome do arquivo carregad.
     * @return O objeto Batalha ou null 
     */
    public static Batalha carregarBatalha(String nomeBatalha) {
        File arquivo = new File(PASTA_SALVAMENTO + nomeBatalha + EXTENSAO);

        if (!arquivo.exists()) {
            System.out.println("Save não encontrado: " + nomeBatalha);
            return null;
        }

        try {
            JAXBContext context = JAXBContext.newInstance(Batalha.class, Hunter.class, Juggernaut.class);
            Unmarshaller um = context.createUnmarshaller();

            Batalha batalhaCarregada = (Batalha) um.unmarshal(arquivo);
            System.out.println("Jogo carregado com sucesso!");
            return batalhaCarregada;

        } 
        catch (JAXBException e) 
        {
            System.err.println("ERRO: Nao foi possivel carregar batalha.");
            e.printStackTrace();
            return null;
        }
    }
}