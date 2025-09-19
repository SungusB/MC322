import java.util.Random;

public class EmboscadaEvento implements Evento {
    @Override
    public boolean verificarGatilho(Heroi heroi, Fase fase, Random rng) {
        return rng.nextDouble() < 0.30 && fase instanceof FaseDeCombate;
    }

    @Override
    public void executar(Heroi heroi, Fase fase, Random rng) {
        if (!(fase instanceof FaseDeCombate f)) return;
        int escolha = rng.nextInt(3);
        Monstro extra = switch (escolha) {
            case 0 -> new Goblin(f.getNivel());
            case 1 -> new Esqueleto(f.getNivel());
            default -> new Orc(f.getNivel());
        };
        f.adicionarMonstro(extra);
        System.out.println("[Evento] Emboscada! Um " + extra.getNome() + " se junta aos inimigos nesta fase!");
    }
}