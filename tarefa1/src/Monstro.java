/**
 * Classe abstrata Monstro, herda de Personagem.
 */
public abstract class Monstro extends Personagem {
    protected int xpConcedido;

    public Monstro(String nome, int pv, int forca, int xpConcedido) {
        super(nome, pv, forca);
        this.xpConcedido = Math.max(0, xpConcedido);
    }

    public int getXpConcedido() {
        return xpConcedido;
    }

    @Override
    public void exibirStatus() {
        System.out.printf("[Monst] %-12s | PV: %3d | Força: %2d | XP ao cair: %3d%n",
                nome, pontosDeVida, forca, xpConcedido);
    }
}
