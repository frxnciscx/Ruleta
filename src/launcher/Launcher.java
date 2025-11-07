package launcher;

import controlador.SessionController;
import controlador.ResultadoController;
import vista.VentanaLogin;

public class Launcher {

    public static void main(String[] args) {
        SessionController session = new SessionController();
        ResultadoController historial = new ResultadoController(session);

        VentanaLogin vLogin = new VentanaLogin(session, historial);
        vLogin.mostrarVentana();
    }
}