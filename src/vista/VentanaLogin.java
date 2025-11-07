package vista;

import controlador.SessionController;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class VentanaLogin {

    private final SessionController session;

    private final JFrame frame = new JFrame("Login - Casino Black Cat");
    private final JLabel lblUsuario = new JLabel("Usuario: ");
    private final JTextField txtUsuario = new JTextField();
    private final JLabel lblClave = new JLabel("Clave: ");
    private final JPasswordField txtClave = new JPasswordField();
    private final JButton btnIngresar = new JButton("Ingresar");
    private final JButton btnRegistrar = new JButton("Registrarse");

    public VentanaLogin(SessionController session) {
        this.session = session;
        inicializarVentana();
    }

    private void inicializarVentana() {
        frame.setLayout(null);
        frame.setSize(300, 230);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        lblUsuario.setBounds(30, 30, 80, 25);
        txtUsuario.setBounds(110, 30, 130, 25);
        lblClave.setBounds(30, 70, 80, 25);
        txtClave.setBounds(110, 70, 130, 25);
        btnIngresar.setBounds(90, 110, 100, 30);
        btnRegistrar.setBounds(90, 150, 100, 30);

        frame.add(lblUsuario);
        frame.add(txtUsuario);
        frame.add(lblClave);
        frame.add(txtClave);
        frame.add(btnIngresar);
        frame.add(btnRegistrar);

        btnIngresar.addActionListener(e -> intentarLogin());
        btnRegistrar.addActionListener(e -> abrirRegistro());
    }

    public void mostrarVentana() {
        frame.setVisible(true);
    }

    private void intentarLogin() {
        String u = txtUsuario.getText();
        String p = new String(txtClave.getPassword());

        if (session.iniciarSesion(u, p)) {
            frame.dispose();
            new VentanaMenu(session).mostrarVentana();
        } else {
            JOptionPane.showMessageDialog(frame, "Usuario o clave incorrecto", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void abrirRegistro() {
        frame.dispose();
        new VentanaRegistro(session).mostrarVentana();
    }
}