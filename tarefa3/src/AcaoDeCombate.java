public interface AcaoDeCombate {
    String getNome();
    void executar(Combatente usuario, Combatente alvo, java.util.Random rng);
}