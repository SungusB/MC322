public class Arqueiro extends Heroi {
    private final double precisao = 0.75; // atributo único

    public Arqueiro(String nome, Arma arma) {
        super(nome, 32, 5, arma, 1, 0.35);
        this.acoes.add(new AtaqueFisico());
        this.acoes.add(new TiroPreciso(this));
        this.acoes.add(new BeberPocao(this, new PocaoDeCura(6)));
    }

    public double getPrecisao(){ return precisao; }
}