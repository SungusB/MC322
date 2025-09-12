import java.util.Random;

public class Goblin extends Monstro {
    public Goblin(int nivelFase) {
        super("Goblin", 14 + 2 * nivelFase, 3 + nivelFase, null, 8 + 2 * nivelFase);
        listaDeArmasParaLargar.add(new VanatuSword());
        listaDeArmasParaLargar.add(new WyrnSword());
    }

    @Override
    public void atacar(Personagem alvo, Random rng) {
        int base = this.forca + (arma != null ? arma.getDano() : 0);
        boolean furtivo = rng.nextDouble() < 0.30;
        int dano = furtivo ? (int)Math.round(base * 1.4) : base;
        System.out.println(nome + " realiza um ataque furtivo" + (furtivo ? " [+40%]" : "") + "!");
        alvo.receberDano(dano);
    }
}