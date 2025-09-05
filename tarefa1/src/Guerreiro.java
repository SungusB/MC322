import java.util.concurrent.ThreadLocalRandom;

/** Guerreiro: herói concreto com atributo único 'furia'. */
public class Guerreiro extends Heroi {
    private int furia; // varia, não pode ser final

    public Guerreiro(String nome, int pv, int forca, int nivel, int furia) {
        super(nome, pv, forca, nivel);
        this.furia = Math.max(0, furia);
    }

    @Override
    public void atacar(Personagem alvo) {
        // Miss?
        if (teste(CHANCE_ERRO_PADRAO)) {
            System.out.printf("%s ERROU o golpe de espada!%n", nome);
            return;
        }
        int variacao = ThreadLocalRandom.current().nextInt(0, 6); // 0..5
        int danoBase = forca + (furia / 5) + variacao;

        // Crítico?
        boolean crit = teste(CHANCE_CRIT_PADRAO);
        int dano = crit ? Math.max(1, (int)Math.round(danoBase * 1.5)) : danoBase;

        System.out.printf("%s desfere um golpe de espada%s! (Dano: %d)%n",
                nome, crit ? " CRÍTICO" : "", dano);
        alvo.receberDano(dano);
        if (furia > 0) furia -= 1;
    }

    @Override
    public void usarHabilidadeEspecial(Personagem alvo) {
        // Miss?
        if (teste(CHANCE_ERRO_PADRAO)) {
            System.out.printf("%s ERROU o GOLPE GIRATÓRIO!%n", nome);
            return;
        }
        int variacao = ThreadLocalRandom.current().nextInt(3, 9); // 3..8
        int danoBase = forca + 5 + (furia / 3) + variacao;

        // Crítico especial?
        boolean crit = teste(CHANCE_CRIT_ESPECIAL);
        int dano = crit ? Math.max(1, (int)Math.round(danoBase * 1.5)) : danoBase;

        System.out.printf("%s usa GOLPE GIRATÓRIO%s! (Dano: %d)%n",
                nome, crit ? " CRÍTICO" : "", dano);
        alvo.receberDano(dano);
        furia = Math.max(0, furia - 3);
    }

    @Override
    public void exibirStatus() {
        System.out.printf("[Guer.] %-12s | PV: %3d | Força: %2d | Nível: %2d | XP: %3d | Fúria: %2d%n",
                nome, pontosDeVida, forca, nivel, experiencia, furia);
    }
}
