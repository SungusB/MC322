import java.util.Random;
public class GolpeGiratorio implements AcaoDeCombate {
    private final Guerreiro dono;
    public GolpeGiratorio(Guerreiro g){ this.dono = g; }
    @Override public String getNome(){ return "Golpe Giratório"; }
    @Override
    public void executar(Combatente usuario, Combatente alvo, Random rng) {
        if (!(usuario instanceof Personagem u) || !(alvo instanceof Personagem a)) return;
        int furia = dono.consumirFuria();
        if (furia < 3) {
            System.out.println(u.getNome() + " tentou " + getNome() + " mas não tinha fúria suficiente...");
            return;
        }
        boolean falha = rng.nextDouble() < (0.20 * (1.0 - ((Heroi)u).getSorte()));
        if (falha) {
            System.out.println(u.getNome() + " errou o " + getNome() + "!");
            return;
        }
        int base = u.getForca() + (u.getArma() != null ? u.getArma().getDano() : 0);
        int dano = base + 2 * furia;
        System.out.println(u.getNome() + " usa " + getNome() + "! [fúria " + furia + "]");
        a.receberDano(dano);
    }
}