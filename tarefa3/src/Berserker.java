import java.util.Random;
public class Berserker implements AcaoDeCombate {
    private final Monstro dono;
    public Berserker(Monstro m){ this.dono = m; }
    @Override public String getNome(){ return "Berserker"; }
    @Override
    public void executar(Combatente usuario, Combatente alvo, Random rng) {
        if (!(usuario instanceof Personagem u) || !(alvo instanceof Personagem a)) return;
        int base = u.getForca() + (u.getArma() != null ? u.getArma().getDano() : 0);
        boolean enfurecido = rng.nextDouble() < 0.20;
        int dano = base + (enfurecido ? 4 : 0);
        System.out.println(u.getNome() + " ruge e ataca com brutalidade" + (enfurecido ? " [BERSEKER]" : "") + "!");
        a.receberDano(dano);
    }
}