// Base abstrata para entidades vivas no jogo
public abstract class Personagem {
    protected final String nome;
    protected int pontosDeVida;
    protected int forca;
    protected Arma arma;

    protected Personagem(String nome, int pontosDeVida, int forca, Arma arma) {
        this.nome = nome;
        this.pontosDeVida = Math.max(0, pontosDeVida);
        this.forca = Math.max(0, forca);
        this.arma = arma;
    }

    public String getNome() { return nome; }
    public int getPontosDeVida() { return pontosDeVida; }
    public int getForca() { return forca; }
    public Arma getArma() { return arma; }

    public boolean estaVivo() { return pontosDeVida > 0; }

    public void receberDano(int dano) {
        int real = Math.max(0, dano);
        pontosDeVida -= real;
        if (pontosDeVida < 0) pontosDeVida = 0;
        System.out.println("  " + nome + " recebeu " + real + " de dano. [HP=" + pontosDeVida + "]");
    }

    public void exibirStatus() {
        String armaDesc = (arma == null ? "Desarmado" : arma.toString());
        System.out.println("[" + getClass().getSimpleName() + "] " + nome +
            " | HP: " + pontosDeVida + " | FOR: " + forca + " | Arma: " + armaDesc);
    }

    public abstract void atacar(Personagem alvo, java.util.Random rng);
}