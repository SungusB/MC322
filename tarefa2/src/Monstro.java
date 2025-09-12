import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// Monstro abstrato: concede XP e pode largar armas de uma lista.
public abstract class Monstro extends Personagem {
    protected int xpConcedido;
    protected final List<Arma> listaDeArmasParaLargar = new ArrayList<>();

    protected Monstro(String nome, int hp, int forca, Arma arma, int xp) {
        super(nome, hp, forca, arma);
        this.xpConcedido = Math.max(1, xp);
        // monstros ignoram requisito de nível; arma é cosmética/dano apenas
    }

    @Override
    public void exibirStatus() {
        super.exibirStatus();
        System.out.println("    XP ao ser derrotado: " + xpConcedido);
    }

    public int getXpConcedido() { return xpConcedido; }

    public Arma largaArma(Random rng) {
        if (listaDeArmasParaLargar.isEmpty()) return null;
        return listaDeArmasParaLargar.get(rng.nextInt(listaDeArmasParaLargar.size()));
    }
}