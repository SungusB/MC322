public class Orc extends Monstro {
    public Orc(int nivelFase) {
        super("Orc", 22 + 4 * nivelFase, 5 + nivelFase, new VanatuSword(), 12 + 2 * nivelFase);
        listaDeArmasParaLargar.add(new VanatuSword());
        if (nivelFase >= 3) listaDeArmasParaLargar.add(new WyrnSword());
        acoes.add(new Berserker(this));
    }
}