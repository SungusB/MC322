import java.util.concurrent.ThreadLocalRandom;

/** Esqueleto: monstro concreto, resistente a cortes. */
public class Esqueleto extends Monstro {
    private final int ossosAntigos; // pode ser final (imutável)

    public Esqueleto(String nome, int pv, int forca, int xp, int ossosAntigos) {
        super(nome, pv, forca, xp);
        this.ossosAntigos = Math.max(0, ossosAntigos);
    }

    @Override
    public void atacar(Personagem alvo) {
        if (teste(CHANCE_ERRO_PADRAO)) {
            System.out.printf("%s ERROU o golpe!%n", nome);
            return;
        }
        int variacao = ThreadLocalRandom.current().nextInt(0, 5); // 0..4
        int danoBase = forca + (ossosAntigos / 5) + variacao;

        boolean crit = teste(CHANCE_CRIT_PADRAO);
        int dano = crit ? Math.max(1, (int)Math.round(danoBase * 1.5)) : danoBase;

        System.out.printf("%s golpeia com espada lascada%s! (Dano: %d)%n",
                nome, crit ? " CRÍTICO" : "", dano);
        alvo.receberDano(dano);
    }
}
