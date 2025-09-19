import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ConstrutorDeCenarioFixo implements GeradorDeFases {
    private static final TipoCenario[] ORDEM = {
        TipoCenario.FLORESTA, TipoCenario.CAVERNA, TipoCenario.CASTELO
    };

    @Override
    public List<Fase> gerar(int quantidadeDeFases, Random rng) {
        List<Fase> fases = new ArrayList<>();
        for (int i = 0; i < quantidadeDeFases; i++) {
            TipoCenario tipo = ORDEM[i % ORDEM.length];
            FaseDeCombate f = new FaseDeCombate(tipo, i+1);

            int qtd = 2 + (i+1);
            for (int k = 0; k < qtd; k++) {
                int t = rng.nextInt(3);
                switch (t) {
                    case 0 -> f.adicionarMonstro(new Goblin(i+1));
                    case 1 -> f.adicionarMonstro(new Esqueleto(i+1));
                    default -> f.adicionarMonstro(new Orc(i+1));
                }
            }
            f.adicionarEvento(new EmboscadaEvento());
            fases.add(f);
        }
        return fases;
    }
}