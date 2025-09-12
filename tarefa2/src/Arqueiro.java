import java.util.concurrent.ThreadLocalRandom;

/** Arqueiro: herói concreto com atributo único 'precisao'. */
public class Arqueiro extends Heroi {
    private int precisao; // varia, não pode ser final

    public Arqueiro(String nome, int pv, int forca, int nivel, int precisao) {
        super(nome, pv, forca, nivel);
        this.precisao = Math.max(0, precisao);
    }

    @Override
    public void atacar(Personagem alvo) {
        if (teste(CHANCE_ERRO_PADRAO)) {
            System.out.printf("%s ERROU a flecha!%n", nome);
            return;
        }
        int variacao = ThreadLocalRandom.current().nextInt(0, 5); // 0..4
        int danoBase = forca + (precisao / 4) + variacao;

        boolean crit = teste(CHANCE_CRIT_PADRAO);
        int dano = crit ? Math.max(1, (int)Math.round(danoBase * 1.5)) : danoBase;

        System.out.printf("%s dispara uma flecha certeira%s! (Dano: %d)%n",
                nome, crit ? " CRÍTICA" : "", dano);
        alvo.receberDano(dano);
        if (precisao > 0) precisao -= 1;
    }

    @Override
    public void usarHabilidadeEspecial(Personagem alvo) {
        if (teste(CHANCE_ERRO_PADRAO)) {
            System.out.printf("%s ERROU a RAJADA DE FLECHAS!%n", nome);
            return;
        }
        int variacao = ThreadLocalRandom.current().nextInt(4, 10); // 4..9
        int danoBase = forca + 7 + (precisao / 2) + variacao;

        boolean crit = teste(CHANCE_CRIT_ESPECIAL);
        int dano = crit ? Math.max(1, (int)Math.round(danoBase * 1.5)) : danoBase;

        System.out.printf("%s usa RAJADA DE FLECHAS%s! (Dano: %d)%n",
                nome, crit ? " CRÍTICA" : "", dano);
        alvo.receberDano(dano);
        precisao = Math.max(0, precisao - 2);
    }

    @Override
    public void exibirStatus() {
        System.out.printf("[Arq. ] %-12s | PV: %3d | Força: %2d | Nível: %2d | XP: %3d | Precisão: %2d%n",
                nome, pontosDeVida, forca, nivel, experiencia, precisao);
    }
}
