import java.util.Random;
public class BeberPocao implements AcaoDeCombate {
    private final Heroi heroi;
    private final PocaoDeCura pocao;
    public BeberPocao(Heroi heroi, PocaoDeCura pocao){
        this.heroi = heroi;
        this.pocao = pocao;
    }
    @Override public String getNome(){ return "Beber Poção"; }
    @Override
    public void executar(Combatente usuario, Combatente alvo, Random rng) {
        if (!(usuario instanceof Heroi h)) return;
        if (!h.consumirPocao()) {
            System.out.println(h.getNome() + " tentou " + getNome() + " mas não tinha poções...");
            return;
        }
        System.out.println(h.getNome() + " bebe uma " + pocao.getNome() + "!");
        h.receberCura(pocao.getCura());
    }
}