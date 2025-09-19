import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Heroi extends Personagem {
    protected int nivel;
    protected int experiencia;
    protected int expProximoNivel;
    protected double sorte;
    protected final List<AcaoDeCombate> acoes = new ArrayList<>();
    protected int pocoes = 1;

    protected Heroi(String nome, int hp, int forca, Arma arma, int nivel, double sorte) {
        super(nome, hp, forca, arma);
        this.nivel = Math.max(1, nivel);
        this.sorte = Math.min(1.0, Math.max(0.0, sorte));
        this.experiencia = 0;
        this.expProximoNivel = 20;
    }

    public int getNivel(){ return nivel; }
    public double getSorte(){ return sorte; }
    public List<AcaoDeCombate> getAcoes(){ return acoes; }
    public int getPocoes(){ return pocoes; }
    public boolean consumirPocao(){ if(pocoes > 0){ pocoes--; return true; } return false; }
    public void ganharPocao(){ pocoes++; }

    public void ganharExperiencia(int xp) {
        experiencia += Math.max(0, xp);
        while (experiencia >= expProximoNivel) {
            experiencia -= expProximoNivel;
            subirDeNivel();
        }
    }

    private void subirDeNivel() {
        nivel++;
        this.forca += 2;
        this.pontosDeVida += 5;
        this.expProximoNivel += Math.max(5, (int)Math.ceil(expProximoNivel * 0.25));
        System.out.println(">>> " + nome + " subiu para o nível " + nivel + "! [+FOR, +HP]");
    }

    public boolean equiparArma(Arma novaArma) {
        if (novaArma == null) return false;
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
    public AcaoDeCombate escolherAcao(Combatente alvo, Random rng) {
        if (acoes.isEmpty()) return new AtaqueFisico();
        // Heurística simples: se vida <= 40% máx estimado (aprox) e tem poção, tenta beber poção
        if (this.getPocoes() > 0 && this.getPontosDeVida() <= 10) { // limiar simples
            for (AcaoDeCombate ac : acoes) if (ac instanceof BeberPocao) return ac;
        }
        if (rng.nextDouble() < 0.25) {
            for (AcaoDeCombate ac : acoes) if (!(ac instanceof AtaqueFisico) && !(ac instanceof BeberPocao)) return ac;
        }
        return acoes.get(0);
    }

    @Override
    public void exibirStatus() {
        super.exibirStatus();
        System.out.println("    Nv: " + nivel + " | XP: " + experiencia + "/" + expProximoNivel + " | Sorte: " + String.format("%.2f", sorte) + " | Poções: " + pocoes);
    }
}