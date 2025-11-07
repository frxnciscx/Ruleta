package vista;

import controlador.SessionController;
import controlador.ResultadoController;
import modelo.Usuario;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;

public class VentanaMenu {

    private final SessionController session;
    private final ResultadoController historial;
    private final JFrame frame;

    private final JLabel lblTitulo = new JLabel("RULETA - Casino Black Cat");
    private final JLabel lblBienvenida = new JLabel("Bienvenido/a al menu principal.");
    private final JLabel lblUsuarioLogueado;
    private final JLabel lblSaldo;

    private final JButton btnJugar = new JButton("Jugar");
    private final JButton btnPerfil = new JButton("Perfil");
    private final JButton btnSalir = new JButton("Salir");

    public VentanaMenu(SessionController session, ResultadoController historial) {
        this.session = session;
        this.historial = historial;
        this.frame = new JFrame("Menu Principal - Black Cat");

        Usuario usuario = session.getUsuarioActual();
        this.lblUsuarioLogueado = new JLabel(usuario.getNombre());
        this.lblSaldo = new JLabel("Saldo: " + usuario.getSaldo());

        configurarVentana();
        agregarEventos();
    }

    private void configurarVentana() {
        frame.setLayout(null);
        frame.setSize(500, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        btnJugar.setBounds(20, 70, 100, 30);
        btnPerfil.setBounds(20, 110, 100, 30);
        btnSalir.setBounds(20, 150, 100, 30);

        lblTitulo.setBounds(150, 30, 300, 25);
        lblBienvenida.setBounds(150, 70, 300, 25);

        lblUsuarioLogueado.setBounds(20, 230, 100, 25);
        lblSaldo.setBounds(150, 230, 150, 25);

        frame.add(btnJugar);
        frame.add(btnPerfil);
        frame.add(btnSalir);
        frame.add(lblTitulo);
        frame.add(lblBienvenida);
        frame.add(lblUsuarioLogueado);
        frame.add(lblSaldo);
    }

    private void agregarEventos() {
        btnJugar.addActionListener(e -> abrirJuego());
        btnPerfil.addActionListener(e -> abrirPerfil());
        btnSalir.addActionListener(e -> cerrarSesion());
    }

    private void abrirJuego() {
        new VentanaRuleta(session, historial).mostrarVentana();
    }

    private void abrirPerfil() {
        new VentanaPerfil(session, this).mostrarVentana();
    }

    private void cerrarSesion() {
        session.cerrarSesion();
        frame.dispose();
        new VentanaLogin(session, historial).mostrarVentana();
    }

    public void refrescarDatos() {
        Usuario usuario = session.getUsuarioActual();
        lblUsuarioLogueado.setText(usuario.getNombre());
        lblSaldo.setText("Saldo: " + usuario.getSaldo());
    }

    public void mostrarVentana() {
        frame.setVisible(true);
    }
}