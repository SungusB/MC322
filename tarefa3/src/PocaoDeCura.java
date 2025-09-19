public class PocaoDeCura implements Item {
    private final int cura;
    public PocaoDeCura(int cura){ this.cura = Math.max(1, cura); }
    public int getCura(){ return cura; }
    @Override public String getNome(){ return "Poção de Cura (+" + cura + " HP)"; }
}