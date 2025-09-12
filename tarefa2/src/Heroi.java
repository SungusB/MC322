/**
 * Classe abstrata Heroi, herda de Personagem.
 * Adiciona: nivel, experiencia; ganharExperiencia(); exibirStatus() override; usarHabilidadeEspecial() abstrato.
 */
public abstract class Heroi extends Personagem {
    protected int nivel;
    protected int experiencia; // XP acumulado
    protected Arma armaEquipada;

    public Heroi(String nome, int pontosDeVida, int forca, int nivel) {
        super(nome, pontosDeVida, forca);
        this.nivel = Math.max(1, nivel);
        this.experiencia = 0;
        this.armaEquipada = null;
    }

    /** Ganha XP; sobe de nível a cada 100*nível XP*/
    public void ganharExperiencia(int xp) {
        if (xp <= 0) return;
        experiencia += xp;
        System.out.printf("+++ %s ganhou %d XP (total: %d).%n", nome, xp, experiencia);

        // Regra de level-up simples: sempre que XP >= 100*nivel, sobe e consome esse limiar.
        while (experiencia >= 100 * nivel) {
            experiencia -= 100 * nivel;
            nivel++;
            forca += 2;            // pequeno bônus
            pontosDeVida += 10;    // pequeno bônus
            System.out.printf("*** %s SUBIU para o nível %d! (+2 Força, +10 PV)%n", nome, nivel);
        }
    }

    public void equiparArma(Arma arma)
     {
        if (arma == null) 
        {
            System.out.printf("%s largou a arma.%n", nome);
            this.armaEquipada = null;
            return;
        }

        if (nivel < arma.getMinNivel()) 
        {
            System.out.printf("!!! %s nivel insuficient para usar %s (requer nível %d).%n", nome, arma.getClass().getSimpleName(), arma.getMinNivel());
            return;
        }

        this.armaEquipada = arma;
        System.out.printf("%s equipou %s!%n", nome, arma);
    }

    public int getDanoTotal() 
    {
        int bonus = (armaEquipada != null) ? armaEquipada.getDano() : 0;
        return forca + bonus;
    }

    @Override
    public void exibirStatus() {
        System.out.printf("[Herói ] %-12s | PV: %3d | Força: %2d | Nível: %2d | XP: %3d%n",
                nome, pontosDeVida, forca, nivel, experiencia);
    }

    /** Cada herói tem uma habilidade especial única. */
    public abstract void usarHabilidadeEspecial(Personagem alvo);
}
