public abstract class Personagem implements Combatente {
    protected final String nome;
    protected int pontosDeVida;
    protected int forca;
    protected Arma arma;

    protected Personagem(String nome, int hp, int forca, Arma arma) {
        this.nome = nome;
        this.pontosDeVida = Math.max(0, hp);
        this.forca = Math.max(0, forca);
        this.arma = arma;
    }

    public String getNome(){ return nome; }
    public boolean estaVivo(){ return pontosDeVida > 0; }
    public int getPontosDeVida(){ return pontosDeVida; }
    public int getForca(){ return forca; }
    public Arma getArma(){ return arma; }

    public void receberDano(int dano){
        int d = Math.max(0, dano);
        pontosDeVida -= d;
        if(pontosDeVida < 0) pontosDeVida = 0;
        System.out.println("  " + nome + " recebeu " + d + " de dano. [HP=" + pontosDeVida + "]");
    }
    public void receberCura(int cura){
        int c = Math.max(0, cura);
        pontosDeVida += c;
        System.out.println("  " + nome + " curou " + c + " pontos. [HP=" + pontosDeVida + "]");
    }

    public void exibirStatus() {
        String armaDesc = (arma == null ? "Desarmado" : arma.toString());
        System.out.println("[" + getClass().getSimpleName() + "] " + nome + " | HP: " + pontosDeVida + " | FOR: " + forca + " | Arma: " + armaDesc);
    }

    @Override
    public abstract AcaoDeCombate escolherAcao(Combatente alvo, java.util.Random rng);
}