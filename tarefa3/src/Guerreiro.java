public class Guerreiro extends Heroi {
    private int furia = 0; // atributo único

    public Guerreiro(String nome, Arma arma) {
        super(nome, 40, 6, arma, 1, 0.25);
        this.acoes.add(new AtaqueFisico());
        this.acoes.add(new GolpeGiratorio(this));
        this.acoes.add(new BeberPocao(this, new PocaoDeCura(6)));
    }

    public int getFuria(){ return furia; }
    public void ganharFuria(int f){ this.furia = Math.min(10, this.furia + Math.max(0,f)); }
    public int consumirFuria(){ int f = furia; furia = 0; return f; }
}