// Guerreiro: foca em fúria acumulável e golpes críticos baseados em sorte.
public class Guerreiro extends Heroi {
    private int furia; // aumenta levemente o dano

    public Guerreiro(String nome, Arma arma) {
        super(nome, 40, 6, arma, 1, 0.25); // HP, FOR, nv inicial, sorte base
        this.furia = 0;
    }

    @Override
    public void atacar(Personagem alvo, java.util.Random rng) {
        if (!estaVivo()) return;
        int base = this.forca + (arma != null ? arma.getDano() : 0);
        int bonusFuria = Math.min(6, furia);
        boolean crit = rng.nextDouble() < (0.10 + 0.40 * this.sorte); // 10% + sorte*40%
        int dano = base + bonusFuria;
        if (crit) dano *= 2;
        System.out.println(nome + " ataca com um golpe pesado" + (crit ? " [CRÍTICO]" : "") + "!");
        alvo.receberDano(dano);
        furia = Math.min(10, furia + 1); // acumula com ataques
    }

    @Override
    public void usarHabilidadeEspecial(Personagem alvo, java.util.Random rng) {
        // "Golpe Giratório": consome fúria para aumentar muito o dano, com chance de errar via sorte
        if (furia < 3) {
            System.out.println(nome + " tentou o Golpe Giratório, mas não tem fúria suficiente...");
            return;
        }
        boolean falha = rng.nextDouble() < (0.20 * (1.0 - this.sorte)); // quanto menor a sorte, maior chance de falha
        if (falha) {
            System.out.println(nome + " errou o Golpe Giratório!");
            furia = Math.max(0, furia - 2);
            return;
        }
        int base = this.forca + (arma != null ? arma.getDano() : 0);
        int dano = base + 2 * furia;
        System.out.println(nome + " usa GOLPE GIRATÓRIO! [fúria " + furia + "]");
        alvo.receberDano(dano);
        furia = 0; // consome toda a fúria
    }
}