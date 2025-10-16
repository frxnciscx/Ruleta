package vista;

import modelo.Usuario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaMenu {

    private final JFrame frame = new JFrame("Menu Principal - Casino Black Cat");
    private final JLabel lblBienvenida = new JLabel();
    private final JButton btnJugar = new JButton("Jugar Ruleta");
    private final JButton btnSalir = new JButton("Cerrar Sesion");

    private final Usuario usuario;

    public VentanaMenu(Usuario usuario) {
        this.usuario = usuario;
        inicializarVentana();
    }

    private void inicializarVentana() {
        frame.setLayout(null);
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        lblBienvenida.setText("Bienvenid@, " + usuario.getNombre());
        lblBienvenida.setBounds(60, 20, 200, 25);
        btnJugar.setBounds(80, 60, 130, 30);
        btnSalir.setBounds(80, 100, 130, 30);

        frame.add(lblBienvenida);
        frame.add(btnJugar);
        frame.add(btnSalir);

        //eventos
        btnJugar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirRuleta();
            }
        });

        btnSalir.addActionListener(e -> salir());
    }

    public void mostrarVentana() {
        frame.setVisible(true);
    }

    private void abrirRuleta() {
        frame.dispose();
        new VentanaRuleta(usuario).mostrarVentana;
    }

    private void salir() {
        frame.dispose();
        new VentanaLogin().mostrarVentana();
    }
}
