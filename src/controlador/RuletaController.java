package controlador;

import modelo.Ruleta;
import modelo.Usuario;
import modelo.TipoApuesta;
import modelo.Resultado;

public class RuletaController {

    private final SessionController session;
    private final Usuario usuario;
    private final Ruleta ruleta;

    public RuletaController(SessionController session) {
        this.session = session;
        this.usuario = session.getUsuarioActual();
        this.ruleta = new Ruleta(usuario.getSaldo());
    }

    public void jugar(int monto, TipoApuesta tipoApuesta) {
        int saldoAntes = ruleta.getSaldo();

        ruleta.jugar(monto, tipoApuesta);

        int saldoDespues = ruleta.getSaldo();
        boolean acierto = ruleta.getUltimoAcierto();
        int numero = ruleta.getUltimoNumero();
        int ganancia = saldoDespues - saldoAntes;

        usuario.actualizarSaldo(ganancia);

        Resultado res = new Resultado(numero, tipoApuesta, monto, acierto, saldoDespues);

        usuario.agregarResultado(res);
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
