public interface Fase {
    void iniciar(Heroi heroi, java.util.Random rng);
    boolean isConcluida();
    TipoCenario getTipoDeCenario();
}