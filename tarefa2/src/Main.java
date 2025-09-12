import java.util.*;

public class Main {
    public static void main(String[] args) {
        Random rng = new Random(); 
        System.out.println("==== DESAFIO DE SOBREVIVÊNCIA ====");

        // Mude para Arqueiro se quiser
        Heroi heroi = new Guerreiro("Ayla", new VanatuSword());
        heroi.exibirStatus();

        // Gerar fases com dificuldade crescente
        List<Fase> fases = ConstrutorDeCenario.gerarFases(4, rng);

        // Loop das fases
        for (int idx = 0; idx < fases.size(); idx++) {
            Fase fase = fases.get(idx);
            System.out.println();
            bannerAmbiente(fase.getAmbiente());
            fase.exibirResumo();
            heroi.exibirStatus();

            // enfrenta um monstro por vez
            for (int i = 0; i < fase.getMonstros().size(); i++) {
                Monstro m = fase.getMonstros().get(i);
                System.out.println();
                System.out.println(">>> Um " + m.getNome() + " surge no caminho!");
                m.exibirStatus();

                // combate enquanto ambos vivos
                int turno = 1;
                while (heroi.estaVivo() && m.estaVivo()) {
                    System.out.println("--- TURNO " + (turno++) + " ---");
                    // chance pequena de usar habilidade especial
                    if (rng.nextDouble() < 0.25) {
                        heroi.usarHabilidadeEspecial(m, rng);
                    } else {
                        heroi.atacar(m, rng);
                    }
                    if (!m.estaVivo()) break;

                    m.atacar(heroi, rng);
                }

                // verificar resultado do combate
                if (!heroi.estaVivo()) {
                    System.out.println("\nXXX GAME OVER — " + heroi.getNome() + " tombou em batalha.");
                    return;
                }

                System.out.println("*** " + m.getNome() + " foi derrotado! +" + m.getXpConcedido() + " XP.");
                heroi.ganharExperiencia(m.getXpConcedido());

                // Teste de sorte para drop de arma
                double rolagem = rng.nextDouble();
                boolean dropou = rolagem < heroi.getSorte();
                if (dropou) {
                    Arma drop = m.largaArma(rng);
                    if (drop != null) {
                        System.out.println("*** Sorte! O " + m.getNome() + " largou " + drop + ".");
                        // equipar se for melhor e permitido
                        if (heroi.getArma() == null || drop.getDano() > heroi.getArma().getDano()) {
                            heroi.equiparArma(drop);
                        } else {
                            System.out.println("   " + heroi.getNome() + " mantém a arma atual.");
                        }
                    }
                } else {
                    System.out.println("*** Sem drops desta vez (rolagem " + String.format("%.2f", rolagem) + ").");
                }
            }
        }

        System.out.println("\n>>> VITÓRIA! " + ((Heroi)heroi).getNome() + " superou todas as fases!");
    }

    private static void bannerAmbiente(String ambiente) {
        String msg = switch (ambiente) {
            case "Catacumbas Umidas" -> "O herói desce às catacumbas úmidas, onde ecos antigos ressoam...";
            case "Floresta de Névoa" -> "A névoa abraça a floresta; olhos brilham entre as árvores...";
            case "Ruínas Ancestrais" -> "Sob colunas quebradas, segredos velhos aguardam...";
            case "Desfiladeiro Helíaco" -> "O vento uiva nas fendas do desfiladeiro; passos precisam ser firmes...";
            case "Cripta do Eclipse" -> "Sombras dançam com a luz do eclipse — a coragem será posta à prova.";
            default -> "O herói adentra " + ambiente + "!";
        };
        System.out.println("=== " + msg + " ===");
    }
}