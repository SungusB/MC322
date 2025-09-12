import java.util.ArrayList;
import java.util.List;

// Fase do jogo: define ambiente, nível e monstros.
public class Fase {
    private final int nivel;
    private final String ambiente;
    private final List<Monstro> monstros = new ArrayList<>();

    public Fase(int nivel, String ambiente) {
        this.nivel = nivel;
        this.ambiente = ambiente;
    }

    public int getNivel() { return nivel; }
    public String getAmbiente() { return ambiente; }
    public List<Monstro> getMonstros() { return monstros; }

    public void adicionarMonstro(Monstro m) {
        if (m != null) monstros.add(m);
    }

    public void exibirResumo() {
        System.out.println("--- FASE Nível " + nivel + " — " + ambiente + " ---");
        System.out.println("Monstros: " + monstros.size());
    }
}