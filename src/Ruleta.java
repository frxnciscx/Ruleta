import java.util.Random;

public class Ruleta {
    public static final int[] NUMEROS_ROJOS = {1, 3, 5, 7, 9, 12, 14, 16, 18, 19, 21, 23, 27, 30, 32, 34, 36};
    public static Random rng = new Random();
    private int ultimoNumero;
    private boolean ultimoAcierto;

    public Ruleta() {
        this.rng = new Random();
        this.ultimoNumero = -1; //valor inical
        this.ultimoAcierto = false;
    }

    public int jugar(int monto, char tipoApuesta) {
        this.ultimoNumero = this.girarRuleta();

        this.ultimoAcierto = this.evaluarResultado(this.ultimoNumero, tipoApuesta);

        if (this.ultimoAcierto) {
            return monto; //gano
        } else {
            return -monto; //perdio
        }
    }

    private int girarRuleta() {
        return rng.nextInt(37);
    }

    private boolean evaluarResultado(int numero, char tipo) {
        if (tipo == 'R') {
            return esRojo(numero);
        }
        if (tipo == 'N') {
            return !esRojo(numero) && numero != 0;
        }
        if (tipo == 'P') {
            return numero != 0 && numero % 2 == 0;
        }
        if (tipo == 'I') {
            return numero % 2 == 1;
        }
        return false;
    }

    public boolean esRojo(int n) {
        if (n == 0) return false;
        for (int r : NUMEROS_ROJOS) {
            if (r == n) return true;
        }
        return false;
    }

    public int getUltimoNumero() {
        return ultimoNumero;
    }

    public boolean getUltimoAcierto() {
        return ultimoAcierto;
    }
}
