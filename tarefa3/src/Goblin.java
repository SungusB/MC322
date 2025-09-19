public class Goblin extends Monstro {
    public Goblin(int nivelFase) {
        super("Goblin", 14 + 2 * nivelFase, 3 + nivelFase, null, 8 + 2 * nivelFase);
        listaDeArmasParaLargar.add(new VanatuSword());
        listaDeArmasParaLargar.add(new WyrnSword());
        acoes.add(new AtaqueFurtivo(this));
    }
}