import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FaseDeCombate implements Fase {
    private final TipoCenario tipo;
    private final int nivel;
    private final List<Monstro> monstros = new ArrayList<>();
    private final List<Evento> eventos = new ArrayList<>();
    private boolean concluida = false;

    public FaseDeCombate(TipoCenario tipo, int nivel){
        this.tipo = tipo;
        this.nivel = nivel;
    }

    public void adicionarMonstro(Monstro m){ if(m!=null) monstros.add(m); }
    public void adicionarEvento(Evento e){ if(e!=null) eventos.add(e); }
    public List<Monstro> getMonstros(){ return monstros; }
    public int getNivel(){ return nivel; }

    @Override public void iniciar(Heroi heroi, Random rng) {
        System.out.println("\n== " + tipo.name() + " — " + tipo.getDescricao() + " ==");
        tipo.aplicarEfeitos(heroi);
        for (Evento e : eventos) {
            if (e.verificarGatilho(heroi, this, rng)) e.executar(heroi, this, rng);
        }

        System.out.println("Monstros nesta fase: " + monstros.size());
        heroi.exibirStatus();

        for (Monstro m : new ArrayList<>(monstros)) {
            if (!heroi.estaVivo()) break;
            System.out.println("\n>> Um " + m.getNome() + " surge no caminho!");
            m.exibirStatus();
            int turno = 1;
            while (heroi.estaVivo() && m.estaVivo()) {
                System.out.println("-- TURNO " + (turno++) + " --");
                AcaoDeCombate acaoHeroi = heroi.escolherAcao(m, rng);
                acaoHeroi.executar(heroi, m, rng);
                if (!m.estaVivo()) break;
                AcaoDeCombate acaoMonstro = m.escolherAcao(heroi, rng);
                acaoMonstro.executar(m, heroi, rng);
            }
            if (!heroi.estaVivo()) break;
            System.out.println("** " + m.getNome() + " foi derrotado! +" + m.getXpConcedido() + " XP.");
            heroi.ganharExperiencia(m.getXpConcedido());
            if (m instanceof Lootavel l) {
                if (rng.nextDouble() < heroi.getSorte()) {
                    Item it = l.droparLoot(rng);
                    if (it instanceof Arma armaDrop) {
                        System.out.println("** Sorte! Dropou " + armaDrop + ".");
                        heroi.equiparArma(armaDrop);
                    } else if (it instanceof PocaoDeCura p) {
                        System.out.println("** Encontrou item: " + p.getNome() + ". Poção adicionada ao inventário!");
                        heroi.ganharPocao();
                    } else if (it != null) {
                        System.out.println("** Encontrou item: " + it.getNome());
                    }
                } else {
                    System.out.println("** Sem drops desta vez.");
                }
            }
        }
        concluida = heroi.estaVivo() && monstros.stream().allMatch(x -> !x.estaVivo());
    }

    @Override public boolean isConcluida(){ return concluida; }
    @Override public TipoCenario getTipoDeCenario(){ return tipo; }
}