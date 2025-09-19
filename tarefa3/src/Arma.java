public abstract class Arma implements Item {
    protected final String nome;
    protected final int dano;
    protected final int minNivel;

    protected Arma(String nome, int dano, int minNivel) {
        this.nome = nome;
        this.dano = Math.max(0, dano);
        this.minNivel = Math.max(1, minNivel);
    }
    public String getNome() { return nome; }
    public int getDano() { return dano; }
    public int getMinNivel() { return minNivel; }
    @Override public String toString() { return nome + " (+" + dano + " dano, nv " + minNivel + "+)"; }
}