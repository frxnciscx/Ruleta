package controlador;

import modelo.Ruleta;
import modelo.Usuario;
import modelo.ApuestaBase;
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

    public void jugar(ApuestaBase apuesta) {
        ruleta.jugar(apuesta);

        int saldoDespues = ruleta.getSaldo();
        boolean acierto = ruleta.getUltimoAcierto();
        int numero = ruleta.getUltimoNumero();
        int ganancia = saldoDespues - usuario.getSaldo();

        usuario.actualizarSaldo(ganancia);

        Resultado res = new Resultado(numero, apuesta, acierto, saldoDespues);
        usuario.agregarResultado(res);
    }

    // Getters para la Vista
    public int getUltimoNumero() { return ruleta.getUltimoNumero(); }
    public String getUltimoColor() { return ruleta.getUltimoColor(); }
    public boolean getUltimoAcierto() { return ruleta.getUltimoAcierto(); }
    public int getSaldoActual() { return usuario.getSaldo(); }
}
