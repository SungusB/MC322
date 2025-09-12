import java.util.Random;

public class Esqueleto extends Monstro {
    public Esqueleto(int nivelFase) {
        super("Esqueleto", 16 + 3 * nivelFase, 4 + nivelFase, null, 10 + 2 * nivelFase);
        listaDeArmasParaLargar.add(new WyrnSword());
        if (nivelFase >= 4) listaDeArmasParaLargar.add(new HelixSword());
    }

    @Override
    public void atacar(Personagem alvo, Random rng) {
        int base = this.forca + (arma != null ? arma.getDano() : 0);
        boolean perfurante = rng.nextDouble() < 0.25;
        int dano = base + (perfurante ? 3 : 0);
        System.out.println(nome + " arremessa fragmentos de costela" + (perfurante ? " [PERFURANTE]" : "") + "!");
        alvo.receberDano(dano);
    }
}