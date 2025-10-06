package com.rpg.personagens.Herois;

import com.rpg.combate.AcaoDeCombate;
import com.rpg.personagens.Personagem;
import com.rpg.itens.Arma;
import com.rpg.exceptions.NivelInsuficienteException;
import java.util.ArrayList;
import java.util.List;


/**
 * Classe base abstrata para todos os Heróis.
 * Adiciona mecânicas de Nível, XP e Armas.
 */
public abstract class Heroi extends Personagem
{
    protected int xp;
    protected int nivel;
    protected Arma armaEquipada;
    protected double modificadorDeDano = 1.0; 
    protected double modificadorDeVelocidade = 1.0;

    /**
     * Construtor para criar um novo Herói.
     * @param nome O nome do herói.
     * @param vidaMaxima O valor máximo de pontos de vida.
     * @param danoAtaque O dano base de ataque físico.
     * @param velocidade O valor de velocidade.
     * @param percentualDefesa O percentual de redução de dano ao defender.
     */
    public Heroi(String nome, int vidaMaxima, int danoAtaque, int velocidade, double percentualDefesa)
    {
        super(nome, vidaMaxima, danoAtaque, velocidade, percentualDefesa);
        this.xp = 0;
        this.nivel = 1;
        this.armaEquipada = null;
    }

    /**
     * Define um multiplicador temporário de dano (ex: efeito de cenário).
     * @param multiplicador O multiplicador de dano.
     */
    public void setModificadorDeDano(double multiplicador) 
    {
        this.modificadorDeDano = multiplicador;
    }

    /**
     * Define um multiplicador temporário de velocidade (ex: efeito de cenário).
     * @param multiplicador O multiplicador de velocidade.
     */
    public void setModificadorDeVelocidade(double multiplicador) 
    {
        this.modificadorDeVelocidade = multiplicador;
    }

    /**
     * Reseta os modificadores de dano e velocidade para 1.0.
     */
    public void resetarModificadores() 
    {
        this.modificadorDeDano = 1.0;
        this.modificadorDeVelocidade = 1.0;
    }

    /**
     * Tenta equipar uma nova arma no herói.
     * @param novaArma O objeto Arma a ser equipado.
     * @throws NivelInsuficienteException Se o nível do herói for inferior ao nível mínimo exigido pela arma.
     */
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

    /**
     * Adiciona XP ao herói. Se o XP total for suficiente, o herói sobe de nível e o XP é resetado.
     * O requisito de XP para o próximo nível é: Nível * 100.
     * @param quantidade A quantidade de experiência a ser adicionada.
     */
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

    /**
     * Retorna o dano de ataque base, somado ao bônus da arma equipada e multiplicado por modificadores de cenário.
     * @return O dano de ataque final.
     */
    @Override
    public int getDanoAtaque() 
    {
        int danoBaseComArma = super.danoAtaque + ((armaEquipada != null) ? armaEquipada.getBonusDano() : 0);
        return (int) (danoBaseComArma * this.modificadorDeDano);
    }

    /**
     * Retorna a velocidade base, somada ao bônus da arma equipada e multiplicada por modificadores de cenário.
     * @return A velocidade final.
     */
    @Override
    public int getVelocidade() 
    {
        int velBaseComArma = super.velocidade + ((armaEquipada != null) ? armaEquipada.getBonusVelocidade() : 0);
        
        return (int) (velBaseComArma * this.modificadorDeVelocidade);
    }

    /**
     * Retorna a vida máxima base, somada ao bônus de vida da arma equipada.
     * @return A vida máxima final.
     */
    @Override
    public int getVidaMaxima()
    {
        int bonusVida = (armaEquipada != null) ? armaEquipada.getBonusVidaMaxima() : 0;
        return super.vidaMaxima + bonusVida;
    }

    /**
     * Retorna a lista contendo apenas a habilidade especial única do herói.
     * @return Uma lista de AcaoDeCombate (contendo apenas a habilidade especial).
     */
    @Override
    protected List<AcaoDeCombate> getAcoesUnicas() {
        List<AcaoDeCombate> acoes = new ArrayList<>();
        acoes.add(getHabilidadeEspecial()); // Just provide the special ability
        return acoes;
    }

    /**
     * Método abstrato para obter a ação de combate especial (habilidade) de cada subclasse de herói.
     * @return A habilidade especial do herói.
     */
    public abstract AcaoDeCombate getHabilidadeEspecial();
}