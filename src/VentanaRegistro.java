import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaRegistro {

    private final JFrame frame = new JFrame("Registro - Casino Black Cat");
    private final JLabel lblUsuario = new JLabel("Usuario: ");
    private final JTextField txtUsuario = new JTextField();
    private final JLabel lblClave = new JLabel("Clave: ");
    private final JPasswordField txtClave = new JPasswordField();
    private final JLabel lblNombre = new JLabel("Nombre: ");
    private final JTextField txtNombre = new JTextField();
    private final JButton btnRegistrar = new JButton("Registrar");
    private final JButton btnVolver = new JButton("Volver");

    public VentanaRegistro() {
        frame.setLayout(null);
        frame.setSize(320, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        lblUsuario.setBounds(30, 30, 80, 25);
        txtUsuario.setBounds(120, 30, 150, 25);
        lblClave.setBounds(30, 70, 80, 25);
        txtClave.setBounds(120, 70, 150, 25);
        lblNombre.setBounds(30, 110, 80, 25);
        txtNombre.setBounds(120, 110, 150, 25);
        btnRegistrar.setBounds(50, 160, 100, 30);
        btnVolver.setBounds(170, 160, 100, 30);

        frame.add(lblUsuario);
        frame.add(txtUsuario);
        frame.add(lblClave);
        frame.add(txtClave);
        frame.add(lblNombre);
        frame.add(txtNombre);
        frame.add(btnRegistrar);
        frame.add(btnVolver);

        btnRegistrar.addActionListener(new  ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrarUsuario();
            }
        });

        btnVolver.addActionListener(e -> volverLogin());
    }

    public void mostrarVentana() {
        frame.setVisible(true);
    }

    private void registrarUsuario() {
        String u = txtUsuario.getText();
        String p = new String(txtClave.getPassword());
        String nombre = txtNombre.getText();

        if (u.isEmpty() || p.isEmpty() || nombre.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Completa todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        VentanaLogin.USUARIOS.add(new Usuario(u, p, nombre));

        JOptionPane.showMessageDialog(frame, "Usuario registrado con exito");
        frame.dispose();
        new VentanaLogin().mostrarVentana(); // vuelve al login
    }

    private void volverLogin() {
        frame.dispose();
        new VentanaLogin().mostrarVentana();
    }

}
