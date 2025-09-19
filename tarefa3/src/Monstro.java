import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Monstro extends Personagem implements Lootavel {
    protected int xpConcedido;
    protected final List<Arma> listaDeArmasParaLargar = new ArrayList<>();
    protected final List<AcaoDeCombate> acoes = new ArrayList<>();

    protected Monstro(String nome, int hp, int forca, Arma arma, int xp) {
        super(nome, hp, forca, arma);
        this.xpConcedido = Math.max(1, xp);
        this.acoes.add(new AtaqueFisico()); // ação padrão
    }

    public int getXpConcedido(){ return xpConcedido; }

    public Arma largaArma(Random rng) {
        if (listaDeArmasParaLargar.isEmpty()) return null;
        return listaDeArmasParaLargar.get(rng.nextInt(listaDeArmasParaLargar.size()));
    }

    @Override
    public Item droparLoot(Random rng) {
        if (rng.nextDouble() < 0.5) return new PocaoDeCura(5);
        return largaArma(rng);
    }

    @Override
    public AcaoDeCombate escolherAcao(Combatente alvo, Random rng) {
        if (acoes.size() > 1 && rng.nextDouble() < 0.20) return acoes.get(acoes.size()-1);
        return acoes.get(0);
    }
}