public class Usuario {
    private String username;
    private String password;
    private String nombre;
    private int saldo;

    public Usuario(String username, String password, String nombre) {
        this.username = username;
        this.password = password;
        this.nombre = nombre;
        this.saldo = 1000;
    }

    //verifica si las credenciales coinciden
    public boolean validarCredenciales(String u, String p) {
        return this.username.equals(u) && this.password.equals(p);
    }

    public String getNombre() {
        return nombre;
    }

    public int getSaldo() {
        return saldo;
    }

    public void actualizarSaldo(int monto) {
        this.saldo += monto;
    }
}