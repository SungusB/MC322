public enum TipoCenario {
    FLORESTA("Floresta enevoada que renova o ânimo") {
        @Override public void aplicarEfeitos(Heroi heroi) {
            heroi.receberCura(2);
            System.out.println("[Cenário] A floresta cura levemente " + heroi.getNome() + " (+2 HP).");
        }
    },
    CAVERNA("Caverna úmida com ecos sombrios") {
        @Override public void aplicarEfeitos(Heroi heroi) {
            System.out.println("[Cenário] O silêncio opressor aumenta a tensão...");
        }
    },
    CASTELO("Castelo em ruínas sob um céu de tempestade") {
        @Override public void aplicarEfeitos(Heroi heroi) {
            System.out.println("[Cenário] Relâmpagos iluminam o caminho do herói.");
        }
    };

    private final String descricao;
    TipoCenario(String descricao) { this.descricao = descricao; }
    public String getDescricao() { return descricao; }
    public abstract void aplicarEfeitos(Heroi heroi);
}