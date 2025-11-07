package modelo;

public class Resultado {

    private final int numero;
    private final TipoApuesta tipoApuesta;
    private final int monto;
    private final boolean acierto;
    private final int saldoResultante;

    public Resultado(int numero, TipoApuesta tipoApuesta, int monto, boolean acierto, int saldoResultante) {
        this.numero = numero;
        this.tipoApuesta = tipoApuesta;
        this.monto = monto;
        this.acierto = acierto;
        this.saldoResultante = saldoResultante;
    }

    public int getNumero() {
        return numero;
    }

    public TipoApuesta getTipoApuesta() {
        return tipoApuesta;
    }

    public int getMonto() {
        return monto;
    }

    public boolean isAcierto() {
        return acierto;
    }

    public int getSaldoResultante() {
        return saldoResultante;
    }
}
