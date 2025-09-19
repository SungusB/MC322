import java.util.Random;
public class AtaqueFurtivo implements AcaoDeCombate {
    private final Monstro dono;
    public AtaqueFurtivo(Monstro m){ this.dono = m; }
    @Override public String getNome(){ return "Ataque Furtivo"; }
    @Override
    public void executar(Combatente usuario, Combatente alvo, Random rng) {
        if (!(usuario instanceof Personagem u) || !(alvo instanceof Personagem a)) return;
        int base = u.getForca() + (u.getArma() != null ? u.getArma().getDano() : 0);
        boolean furtivo = rng.nextDouble() < 0.30;
        int dano = furtivo ? (int)Math.round(base * 1.4) : base;
        System.out.println(u.getNome() + " realiza " + getNome() + (furtivo ? " [+40%]" : "") + "!");
        a.receberDano(dano);
    }
}