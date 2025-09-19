import java.util.*;

public class Main {
    public static void main(String[] args) {
        Random rng = new Random(); 
        System.out.println("==== RPG ====");

        Heroi heroi = new Guerreiro("Ayla", new VanatuSword());
        heroi.exibirStatus();

        GeradorDeFases gerador = new ConstrutorDeCenarioFixo();
        List<Fase> fases = gerador.gerar(3, rng);

        for (Fase fase : fases) {
            fase.iniciar(heroi, rng);
            if (!heroi.estaVivo()) {
                System.out.println("\nXXX GAME OVER — " + heroi.getNome() + " tombou em batalha.");
                return;
            }
            if (!fase.isConcluida()) {
                System.out.println("\n!!! A fase não foi concluída corretamente, encerrando...");
                return;
            }
        }
        System.out.println("\n>>> VITÓRIA! " + heroi.getNome() + " completou todas as fases!");
    }
}