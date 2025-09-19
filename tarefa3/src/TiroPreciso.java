import java.util.Random;
public class TiroPreciso implements AcaoDeCombate {
    private final Arqueiro dono;
    public TiroPreciso(Arqueiro a){ this.dono = a; }
    @Override public String getNome(){ return "Tiro Preciso"; }
    @Override
    public void executar(Combatente usuario, Combatente alvo, Random rng) {
        if (!(usuario instanceof Personagem u) || !(alvo instanceof Personagem a)) return;
        boolean falha = rng.nextDouble() > (0.65 + 0.35 * dono.getSorte());
        if (falha) {
            System.out.println(u.getNome() + " errou o " + getNome() + "...");
            return;
        }
        int base = u.getForca() + (u.getArma() != null ? u.getArma().getDano() : 0);
        int dano = (int)Math.round(base * 1.8);
        System.out.println(u.getNome() + " usa " + getNome() + "!");
        a.receberDano(dano);
    }
}