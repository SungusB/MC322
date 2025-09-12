// Herói abstrato: sistema de nível, XP e sorte.

public abstract class Heroi extends Personagem {

    protected int nivel;
    protected int experiencia;
    protected int expProximoNivel;
    protected double sorte; // 0..1

    protected Heroi(String nome, int hp, int forca, Arma arma, int nivel, double sorte) {
        super(nome, hp, forca, arma);
        this.nivel = Math.max(1, nivel);
        this.sorte = Math.min(1.0, Math.max(0.0, sorte));
        this.experiencia = 0;
        this.expProximoNivel = 20; // base simples
    }

    public int getNivel() {
        return nivel;
    }

    public double getSorte() {
        return sorte;
    }

    public void ganharExperiencia(int xp) {
        experiencia += Math.max(0, xp);
        while (experiencia >= expProximoNivel) {
            experiencia -= expProximoNivel;
            subirDeNivel();
        }
    }

    private void subirDeNivel() {
        nivel++;
        // fortalecer atributos de forma crescente e simples
        this.forca += 2;
        this.pontosDeVida += 5;
        // próxima meta de XP cresce 25%
        this.expProximoNivel += Math.max(5, (int) Math.ceil(expProximoNivel * 0.25));
        System.out.println(">>> " + nome + " subiu para o nível " + nivel + "! [+FOR, +HP]");
    }

    public boolean equiparArma(Arma novaArma) {
        if (novaArma == null) {
            return false;
        }

        if (nivel >= novaArma.getMinNivel()) {
            boolean melhor = (arma == null) || (novaArma.getDano() > arma.getDano());
            this.arma = novaArma;
            System.out.println(">>> " + nome + " equipou " + novaArma + (melhor ? " [UPGRADE]" : ""));
            return true;
        } else {
            System.out.println("!!! " + nome + " não tem nível para equipar " + novaArma);
            return false;
        }
    }

    @Override
    public void exibirStatus() {
        super.exibirStatus();
        System.out.println("    Nv: " + nivel + " | XP: " + experiencia + "/" + expProximoNivel + " | Sorte: " + String.format("%.2f", sorte));
    }

    public abstract void usarHabilidadeEspecial(Personagem alvo, java.util.Random rng);
}
