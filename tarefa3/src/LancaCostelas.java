import java.util.Random;
public class LancaCostelas implements AcaoDeCombate {
    private final Monstro dono;
    public LancaCostelas(Monstro m){ this.dono = m; }
    @Override public String getNome(){ return "Lança-Costelas"; }
    @Override
    public void executar(Combatente usuario, Combatente alvo, Random rng) {
        if (!(usuario instanceof Personagem u) || !(alvo instanceof Personagem a)) return;
        int base = u.getForca() + (u.getArma() != null ? u.getArma().getDano() : 0);
        boolean perfurante = rng.nextDouble() < 0.25;
        int dano = base + (perfurante ? 3 : 0);
        System.out.println(u.getNome() + " arremessa fragmentos de costela" + (perfurante ? " [PERFURANTE]" : "") + "!");
        a.receberDano(dano);
    }
}