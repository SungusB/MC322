import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class ConstrutorDeCenario 
{
    public static List<Fase> gerarFases(int nFases) 
    {
        List<Fase> fases = new ArrayList<>();
        ThreadLocalRandom rnd = ThreadLocalRandom.current();

        for (int i = 1; i <= nFases; i++) 
        {
            Fase fase = null;

            if (i == 1) 
            {
                // ===== CENÁRIO 1 =====
                String nomeAmbiente = "Treinamento";
                Monstro[] encontros = new Monstro[]
                {
                        new Goblin("Goblin Velhaco", 25 + rnd.nextInt(11), 6 + rnd.nextInt(5), 40, 4 + rnd.nextInt(5)),  
                        new Esqueleto("Esqueleto Antigo", 35 + rnd.nextInt(11), 8 + rnd.nextInt(5), 50, 7 + rnd.nextInt(4)),  
                        new Orc("Orc Colossal", 45 + rnd.nextInt(11), 10 + rnd.nextInt(5), 75, 12 + rnd.nextInt(6))  
                };
                fase = new Fase(i, nomeAmbiente, encontros);

            } else if (i == 2) {
                // ===== CENÁRIO 2 =====
                String nomeAmbiente = "???";
                Monstro[] encontros = new Monstro[]{

                };
                fase = new Fase(i, nomeAmbiente, encontros);

            } else if (i == 3) {
                // ===== CENÁRIO 3 =====
                String nomeAmbiente = "???";
                Monstro[] encontros = new Monstro[]{
                };
                fase = new Fase(i, nomeAmbiente, encontros);
            }

            if (fase != null) {
                fases.add(fase);
            }
        }

        return fases;
    }
}
