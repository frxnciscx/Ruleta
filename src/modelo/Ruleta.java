package modelo;

import java.util.Random;

public class Ruleta {

    private static final int[] NUMEROS_ROJOS = {1, 3, 5, 7, 9, 12, 14, 16, 18, 19, 21, 23, 27, 30, 32, 34, 36};

    private final Random rng;
    private int ultimoNumero;
    private boolean ultimoAcierto;
    private int saldo;

    public Ruleta(int saldoInicial) {
        this.rng = new Random();
        this.ultimoNumero = -1;
        this.saldo = saldoInicial;
    }

    public Ruleta() {
        this(0);
    }

    public void jugar(int monto, TipoApuesta tipoApuesta) {
        this.ultimoNumero = this.girarRuleta();
        this.ultimoAcierto = this.evaluarResultado(this.ultimoNumero, tipoApuesta);

        if (this.ultimoAcierto) {
            this.saldo += monto;
        } else {
            this.saldo -= monto;
        }
    }

    private int girarRuleta() {
        return rng.nextInt(37);
    }

    private boolean evaluarResultado(int numero, TipoApuesta tipo) {
        if (numero == 0) {
            return false;
        }

        return switch (tipo) {
            case ROJO -> esRojo(numero);
            case NEGRO -> !esRojo(numero);
            case PAR -> numero % 2 == 0;
            case IMPAR -> numero % 2 != 0;
        };
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

    public int getSaldo() {
        return saldo;
    }
}
