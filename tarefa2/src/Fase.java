public class Fase
{
    public int numFase;
    public String nomeAmbiente;
    protected Monstro[] monstros; 

    public Fase(int numFase, String nomeAmbiente, Monstro monstros)
    {
        this.numFase = numFase;
        this.nomeAmbiente = nomeAmbiente;
        this.monstros = monstros;
    }

    public int getnumFase() {return numFase;}

    public String getnomeAmbiente() {return nomeAmbiente;}

    public Monstro getmonstros() {return monstros;}

    public void setnumFase(int x) {this.numFase = x;}

    public void setnomeAmbiente(String x) {this.nomeAmbiente = x;}

    public void setmonstros(Monstro x) {this.monstros =x;}
}