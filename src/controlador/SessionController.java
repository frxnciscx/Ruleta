package controlador;

import modelo.Usuario;

public class SessionController {

    private Usuario usuarioActual;

    public SessionController() {
        this.usuarioActual = null;
    }

    public void registrarUsuario(String u, String p, String n) {
        if (u == null || u.isBlank() || p == null || p.isBlank() || n == null || n.isBlank()) {
            System.err.println("Datos de registro incompletos");
            return;
        }
        this.usuarioActual = new Usuario(u, p, n);
    }

    public boolean iniciarSesion(String u, String p) {
        if (usuarioActual == null) {
            return false;
        }
        return usuarioActual.validarCredenciales(u, p);
    }

    public boolean hayUsuario() {
        return usuarioActual != null;
    }

    public Usuario getUsuarioActual() {
        return usuarioActual;
    }

    public void cerrarSesion() {
        usuarioActual = null;
    }
}
