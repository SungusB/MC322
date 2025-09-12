public abstract class Arma
{
    protected int dano;
    protected int nivelMin;

    public Arma(int dano, int nivelMin)
    {
        this.dano = dano;
        this.nivelMin =nivelMin;
    }
    
    public int getDano(){return dano;}

    public int getnivelMin(){return nivelMin;}
}