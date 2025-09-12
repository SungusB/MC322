import java.util.concurrent.ThreadLocalRandom;

/** Goblin: monstro concreto, ágil e traiçoeiro. */
public class Goblin extends Monstro {
    private final int malicia; // valor fixo após construir

    public Goblin(String nome, int pv, int forca, int xp, int malicia) {
        super(nome, pv, forca, xp);
        this.malicia = Math.max(0, malicia);
    }

    @Override
    public void atacar(Personagem alvo) {
        if (teste(CHANCE_ERRO_PADRAO)) {
            System.out.printf("%s ERROU a adaga!%n", nome);
            return;
        }
        int variacao = ThreadLocalRandom.current().nextInt(0, 4); // 0..3
        int danoBase = forca + (malicia / 4) + variacao;

        boolean crit = teste(CHANCE_CRIT_PADRAO);
        int dano = crit ? Math.max(1, (int)Math.round(danoBase * 1.5)) : danoBase;

        System.out.printf("%s ataca com adaga enferrujada%s! (Dano: %d)%n",
                nome, crit ? " CRÍTICA" : "", dano);
        alvo.receberDano(dano);
    }
}
