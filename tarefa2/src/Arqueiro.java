// Arqueiro: foco em precisão. Chance de disparo duplo com base na sorte.
public class Arqueiro extends Heroi {
    private final double precisao; // 0..1

    public Arqueiro(String nome, Arma arma) {
        super(nome, 32, 5, arma, 1, 0.35);
        this.precisao = 0.75;
    }

    @Override
    public void atacar(Personagem alvo, java.util.Random rng) {
        if (!estaVivo()) return;
        int base = this.forca + (arma != null ? arma.getDano() : 0);
        boolean duplo = rng.nextDouble() < (this.sorte * this.precisao); // sorte influencia disparo extra
        int vezes = duplo ? 2 : 1;
        for (int i = 1; i <= vezes; i++) {
            System.out.println(nome + " dispara uma flecha" + (duplo ? " #" + i : "") + "!");
            alvo.receberDano((int)Math.round(base * (duplo ? 0.7 : 1.0))); // se duplo, cada um causa 70%
        }
    }

    @Override
    public void usarHabilidadeEspecial(Personagem alvo, java.util.Random rng) {
        // "Tiro Preciso": dano alto com chance de errar reduzida pela sorte
        boolean falha = rng.nextDouble() > (0.65 + 0.35 * this.sorte);
        if (falha) {
            System.out.println(nome + " errou o Tiro Preciso...");
            return;
        }
        int base = this.forca + (arma != null ? arma.getDano() : 0);
        int dano = (int)Math.round(base * 1.8);
        System.out.println(nome + " usa TIRO PRECISO!");
        alvo.receberDano(dano);
    }
}