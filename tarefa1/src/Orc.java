import java.util.concurrent.ThreadLocalRandom;

/** Orc: monstro concreto, brutal. */
public class Orc extends Monstro {
    private final int brutalidade; // imutável depois do construtor

    public Orc(String nome, int pv, int forca, int xp, int brutalidade) {
        super(nome, pv, forca, xp);
        this.brutalidade = Math.max(0, brutalidade);
    }

    @Override
    public void atacar(Personagem alvo) {
        if (teste(CHANCE_ERRO_PADRAO)) {
            System.out.printf("%s ERROU o esmagamento!%n", nome);
            return;
        }
        int variacao = ThreadLocalRandom.current().nextInt(1, 7); // 1..6
        int danoBase = forca + (brutalidade / 3) + variacao;

        boolean crit = teste(CHANCE_CRIT_PADRAO);
        int dano = crit ? Math.max(1, (int)Math.round(danoBase * 1.5)) : danoBase;

        System.out.printf("%s esmaga com o porrete%s! (Dano: %d)%n",
                nome, crit ? " CRÍTICO" : "", dano);
        alvo.receberDano(dano);
    }
}
