public class Esqueleto extends Monstro {
    public Esqueleto(int nivelFase) {
        super("Esqueleto", 16 + 3 * nivelFase, 4 + nivelFase, null, 10 + 2 * nivelFase);
        listaDeArmasParaLargar.add(new WyrnSword());
        if (nivelFase >= 4) listaDeArmasParaLargar.add(new HelixSword());
        acoes.add(new LancaCostelas(this));
    }
}