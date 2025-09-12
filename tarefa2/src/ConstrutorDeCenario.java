import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// Métodos estáticos para gerar fases crescentes em dificuldade
public class ConstrutorDeCenario {
    private static final String[] AMBIENTES = {
        "Catacumbas Umidas", "Floresta de Névoa", "Ruínas Ancestrais", "Desfiladeiro Helíaco", "Cripta do Eclipse"
    };

    public static List<Fase> gerarFases(int nFases, Random rng) {
        List<Fase> fases = new ArrayList<>();
        for (int i = 1; i <= nFases; i++) {
            String ambiente = AMBIENTES[(i - 1) % AMBIENTES.length];
            Fase f = new Fase(i, ambiente);
            // quantidade de monstros cresce levemente
            int qtd = 2 + i;
            for (int k = 0; k < qtd; k++) {
                // escolha pseudo-aleatória de tipo
                int t = rng.nextInt(3);
                switch (t) {
                    case 0 -> f.adicionarMonstro(new Goblin(i));
                    case 1 -> f.adicionarMonstro(new Esqueleto(i));
                    default -> f.adicionarMonstro(new Orc(i));
                }
            }
            fases.add(f);
        }
        return fases;
    }
}