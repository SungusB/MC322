import java.util.concurrent.ThreadLocalRandom;

/**
 * Cenário de Sobrevivência
 * - Um herói enfrenta 3 encontros com monstros diferentes.
 * - Turno: herói ataca; se monstro vivo, contra-ataca.
 * - Aleatoriedade: atributos iniciais e variação de dano nos ataques.
 * - Pausa de 20 s entre turnos para leitura.
 */
public class Main {
    private static void cabecalho(String titulo) {
        System.out.println();
        System.out.println("===== " + titulo + " =====");
    }

    /** pause */
    private static void dormirMs(long ms) {
        try { Thread.sleep(ms); } catch (InterruptedException ignored) {}
    }

    public static void main(String[] args) {
        var rnd = ThreadLocalRandom.current();

        // Escolha um herói (use Guerreiro ou Arqueiro).
        Heroi heroi = new Guerreiro(
                "Arthus",
                90 + rnd.nextInt(21),   // PV 90..110
                12 + rnd.nextInt(6),    // Força 12..17
                1,
                8 + rnd.nextInt(5)      // Fúria 8..12
        );
        // Heroi heroi = new Arqueiro("Lyra",
        //         85 + rnd.nextInt(21),   // 85..105
        //         11 + rnd.nextInt(6),    // 11..16
        //         1,
        //         10 + rnd.nextInt(7));   // 10..16

        // Três monstros com variações
        Monstro[] encontros = new Monstro[]{
                new Goblin("Goblin Velhaco",
                        25 + rnd.nextInt(11), // 25..35
                        6 + rnd.nextInt(5),   // 6..10
                        40,
                        4 + rnd.nextInt(5)),  // 4..8
                new Esqueleto("Esqueleto Antigo",
                        35 + rnd.nextInt(11), // 35..45
                        8 + rnd.nextInt(5),   // 8..12
                        50,
                        7 + rnd.nextInt(4)),  // 7..10
                new Orc("Orc Colossal",
                        45 + rnd.nextInt(11), // 45..55
                        10 + rnd.nextInt(5),  // 10..14
                        75,
                        12 + rnd.nextInt(6))  // 12..17
        };

        // Apresentação do desafio
        cabecalho("O HERÓI ENTRA NA MASMORRA PARA ENFRENTAR TRÊS DESAFIOS!");
        heroi.exibirStatus();

        for (int turno = 0; turno < 3; turno++) {
            Monstro monstro = encontros[turno];
            cabecalho(String.format("INÍCIO DO TURNO %d", turno + 1));
            System.out.printf("Um %s aparece!%n", monstro.nome);
            monstro.exibirStatus();

            // Herói ataca primeiro
            heroi.atacar(monstro);

            // Se o monstro caiu, herói recebe XP e NÃO há contra-ataque
            if (!monstro.estaVivo()) {
                System.out.printf("%s foi derrotado!%n", monstro.nome);
                heroi.ganharExperiencia(monstro.getXpConcedido());
            } else {
                // Monstro ainda vivo contra-ataca
                monstro.atacar(heroi);
            }

            // Checa sobrevivência do herói
            if (!heroi.estaVivo()) {
                cabecalho("GAME OVER");
                System.out.println("O herói tombou na masmorra...");
                return;
            }

            // Status ao final do turno
            cabecalho("FIM DO TURNO — STATUS ATUAL");
            heroi.exibirStatus();
            monstro.exibirStatus();

            // Pausa de 20 segundos antes do próximo turno (para leitura)
            dormirMs(20_000);
        }

        // Conclusão
        cabecalho("VITÓRIA!");
        System.out.println("O herói sobreviveu aos três desafios e retorna triunfante!");
        heroi.exibirStatus();
    }
}
