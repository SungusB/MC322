public interface Evento {
    boolean verificarGatilho(Heroi heroi, Fase fase, java.util.Random rng);
    void executar(Heroi heroi, Fase fase, java.util.Random rng);
}