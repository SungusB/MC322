import java.util.Random;

public class Orc extends Monstro {
    public Orc(int nivelFase) {
        super("Orc", 22 + 4 * nivelFase, 5 + nivelFase, new VanatuSword(), 12 + 2 * nivelFase);
        listaDeArmasParaLargar.add(new VanatuSword());
        if (nivelFase >= 3) listaDeArmasParaLargar.add(new WyrnSword());
    }

    @Override
    public void atacar(Personagem alvo, Random rng) {
        int base = this.forca + (arma != null ? arma.getDano() : 0);
        boolean berseker = rng.nextDouble() < 0.20;
        int dano = base + (berseker ? 4 : 0);
        System.out.println(nome + " ruge e ataca com brutalidade" + (berseker ? " [BERSEKER]" : "") + "!");
        alvo.receberDano(dano);
    }
}