package controlador;

import modelo.Ruleta;
import modelo.Usuario;
import modelo.TipoApuesta;

public class RuletaController {

    private final Usuario usuario;
    private final Ruleta ruleta;

    public RuletaController(Usuario usuario) {
        this.usuario = usuario;
        this.ruleta = new Ruleta(usuario.getSaldo());
    }

    public void jugar(int monto, TipoApuesta tipoApuesta) {
        int saldoAntes = ruleta.getSaldo();

        ruleta.jugar(monto, tipoApuesta);

        int saldoDespues = ruleta.getSaldo();

        int ganancia = saldoDespues - saldoAntes;

        usuario.actualizarSaldo(ganancia);
    }

    public int getUltimoNumero() {
        return ruleta.getUltimoNumero();
    }

    public boolean getUltimoAcierto() {
        return ruleta.getUltimoAcierto();
    }

    public boolean esRojo(int n) {
        return ruleta.esRojo(n);
    }

    public int getSaldoActual() {
        return usuario.getSaldo();
    }
}
