import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class VentanLogin {
    public static final List<Usuario> USUARIOS = new ArrayList<>();

    private final JFrame frame = new JFrame("Login - Casino Black Cat");
    private final JLabel lblUsuario = new JLabel("Usuario:");
    private final JTextField txtUsuario = new JTextField();
    private final JLabel lblClave = new JLabel("Clave:");
    private final JPasswordField txtClave = new JPasswordField();
    private final JButton btnIngresar = new JButton("Ingresar");

    public VentanLogin() {
        inicializarUsuarios();
        inicializarVentana();
    }

    private void inicializarUsuarios() {
        USUARIOS.add(new Usuario("Francisca", "1234", "Francisca"));
        USUARIOS.add(new Usuario("Admin", "1234", "Administrados"));
    }

    private void inicializarVentana() {
        frame.setLayout(null);
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        lblUsuario.setBounds(30, 30, 80, 25);
        txtUsuario.setBounds(110, 30, 130, 25);
        lblClave.setBounds(30, 70, 80, 25);
        txtClave.setBounds(110, 70, 130, 25);
        btnIngresar.setBounds(90, 110, 100, 30);

        frame.add(lblUsuario);
        frame.add(txtUsuario);
        frame.add(lblClave);
        frame.add(txtClave);
        frame.add(btnIngresar);

        btnIngresar.addActionListener(new  ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                login();
            }
        });
    }

    public void mostrarVentana() {
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void login() {
        String usuario = txtUsuario.getText();
        String clave = new String(txtClave.getPassword());

        String nombre = validarCredenciales(usuario, clave);
        if (!nombre.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Bienvenido "+nombre);
            frame.dispose();
            new VentanaPrincipal(nombre).mostrarVentana;
        } else  {
            JOptionPane.showMessageDialog(frame, "Usuario o Clave incorrecto", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private String validarCredenciales(String u, String p) {
        for (Usuario user : USUARIOS) {
            if (user.validarCredenciales(u,p)) {
                return user.getNombre();
            }
        }
        return "";
    }
}
