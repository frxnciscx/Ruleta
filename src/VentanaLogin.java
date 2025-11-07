import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class VentanaLogin {

    public static final List<Usuario> USUARIOS = new ArrayList<>();
    private final JFrame frame = new JFrame("Login - Casino Black Cat");
    private final JLabel lblUsuario = new JLabel("Usuario: ");
    private final JTextField txtUsuario = new JTextField();
    private final JLabel lblClave = new JLabel("Clave: ");
    private final JPasswordField txtClave = new JPasswordField();
    private final JButton btnIngresar = new JButton("Ingresar");
    private final JButton btnRegistrar = new JButton("Registrarse");


    public VentanaLogin() {
        if (USUARIOS.isEmpty()) {
            inicializarUsuarios();
        }
        inicializarVentana();
    }

    private void inicializarUsuarios() {
        USUARIOS.add(new Usuario("admin", "1234", "Administrador"));
        USUARIOS.add(new Usuario("fran", "abcd", "Francisca"));
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

        btnIngresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                login();
            }
        });

        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirRegistro();
            }
        });
    }

    public void mostrarVentana() {
        frame.setVisible(true);
    }


    private void login() {
        String u = txtUsuario.getText();
        String p = new String(txtClave.getPassword());

        Usuario usuarioValidado = validarCredenciales(u, p);

        if (usuarioValidado != null) {
            frame.dispose();
            new VentanaMenu(usuarioValidado).mostrarVentana();
        } else  {
            JOptionPane.showMessageDialog(frame, "Usuario o clave incorrecto", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private Usuario validarCredenciales(String u, String p) {
        for (Usuario usr : USUARIOS) {
            if (usr.validarCredenciales(u,p)) {
                return usr;
            }
        }
        return null;
    }

    private void abrirRegistro() {
        frame.dispose();
        new VentanaRegistro().mostrarVentana();
    }

    public static void main(String[] args) {
        new VentanaLogin().mostrarVentana();
    }
}