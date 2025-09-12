import java.util.concurrent.ThreadLocalRandom;

/**
 * Classe abstrata base para qualquer entidade viva do jogo.
 * Atributos: nome, pontosDeVida, forca.
 * Métodos: receberDano(), exibirStatus(), estaVivo(), atacar() abstrato.
 */
public abstract class Personagem {
    protected String nome;
    protected int pontosDeVida;
    protected int forca;

    // Probabilidades globais (pode ajustar aqui)
    protected static final double CHANCE_ERRO_PADRAO = 0.08;   // 8% miss
    protected static final double CHANCE_CRIT_PADRAO = 0.15;   // 15% crítico
    protected static final double CHANCE_CRIT_ESPECIAL = 0.25; // 25% crítico em especiais

    public Personagem(String nome, int pontosDeVida, int forca) {
        this.nome = nome;
        this.pontosDeVida = Math.max(0, pontosDeVida);
        this.forca = Math.max(0, forca);
    }

    /** Reduz os pontos de vida, sem deixar negativo. */
    public void receberDano(int dano) {
        if (dano < 0) dano = 0;
        this.pontosDeVida = Math.max(0, this.pontosDeVida - dano);
        System.out.printf(">>> %s recebeu %d de dano. (PV: %d)%n", nome, dano, pontosDeVida);
    }

    public void exibirStatus() {
        System.out.printf("[Status] %-12s | PV: %3d | Força: %2d%n", nome, pontosDeVida, forca);
    }

    public boolean estaVivo() {
        return pontosDeVida > 0;
    }

    /** Random helper: retorna true com probabilidade 'prob' (0..1). */
    protected static boolean teste(double prob) {
        return ThreadLocalRandom.current().nextDouble() < prob;
    }

    /** Contrato de ataque: cada subclasse define seu estilo. */
    public abstract void atacar(Personagem alvo);
}
