import java.util.Random;
public class AtaqueFisico implements AcaoDeCombate {
    @Override public String getNome(){ return "Ataque Físico"; }
    @Override
    public void executar(Combatente usuario, Combatente alvo, Random rng) {
        if (!(usuario instanceof Personagem u) || !(alvo instanceof Personagem a)) return;
        int base = u.getForca() + (u.getArma() != null ? u.getArma().getDano() : 0);
        System.out.println(u.getNome() + " ataca com " + getNome() + "!");
        a.receberDano(base);
        if (u instanceof Guerreiro g) g.ganharFuria(1);
    }
}