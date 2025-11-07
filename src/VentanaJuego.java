import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaJuego {

    private final Usuario usuario;
    private final Ruleta motorRuleta;

    private final JFrame frame;
    private final JLabel lblTipoApuesta = new JLabel("Tipo de apuesta:");
    private final JComboBox<String> cmbTipoApuesta = new JComboBox<>(new String[]{"Color", "Paridad"});
    private final JLabel lblSeleccion = new JLabel("Seleccione color:");
    private final JComboBox<String> cmbSeleccion = new JComboBox<>(new String[]{"Rojo", "Negro"});
    private final JLabel lblMonto = new JLabel("Monto:");
    private final JTextField txtMonto = new JTextField("100");
    private final JButton btnGirar = new JButton("Girar");
    private final JLabel lblSaldo; // Muestra el saldo actual
    private final JLabel lblResultado = new JLabel("¡Haga su apuesta!");


    public VentanaJuego(Usuario usuario, JFrame frameMenu) {
        this.usuario = usuario;
        this.motorRuleta = new Ruleta();
        this.frame = new JFrame("Juego Ruleta - Black Cat");

        this.lblSaldo = new JLabel("Saldo: " + usuario.getSaldo());

        configurarVentana(frameMenu);
        agregarEventos();
    }

    private void configurarVentana(JFrame frameMenu) {
        frame.setLayout(null);
        frame.setSize(550, 300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(frameMenu);

        // Posicionamiento de componentes
        lblTipoApuesta.setBounds(30, 30, 120, 25);
        cmbTipoApuesta.setBounds(160, 30, 150, 25);
        lblSeleccion.setBounds(30, 70, 120, 25);
        cmbSeleccion.setBounds(160, 70, 150, 25);
        lblMonto.setBounds(30, 110, 120, 25);
        txtMonto.setBounds(160, 110, 100, 25);
        btnGirar.setBounds(270, 110, 80, 25);
        lblSaldo.setBounds(370, 110, 150, 25);
        lblResultado.setBounds(30, 170, 480, 25);

        frame.add(lblTipoApuesta); frame.add(cmbTipoApuesta);
        frame.add(lblSeleccion); frame.add(cmbSeleccion);
        frame.add(lblMonto); frame.add(txtMonto);
        frame.add(btnGirar); frame.add(lblSaldo);
        frame.add(lblResultado);
    }


    private void agregarEventos() {
        cmbTipoApuesta.addActionListener(e -> {
            if (cmbTipoApuesta.getSelectedItem().equals("Color")) {
                lblSeleccion.setText("Seleccione color:");
                cmbSeleccion.setModel(new DefaultComboBoxModel<>(new String[]{"Rojo", "Negro"}));
            } else {
                lblSeleccion.setText("Seleccione paridad:");
                cmbSeleccion.setModel(new DefaultComboBoxModel<>(new String[]{"Par", "Impar"}));
            }
        });
        btnGirar.addActionListener(e -> accionGirar());
    }

    private void accionGirar() {
        int monto;
        try {
            monto = Integer.parseInt(txtMonto.getText());
            if (monto <= 0 || monto > usuario.getSaldo()) {
                JOptionPane.showMessageDialog(frame, "Monto inválido o insuficiente.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Monto debe ser un número.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        char tipoApuesta = getTipoApuestaSeleccionada();
        int ganancia = motorRuleta.jugar(monto, tipoApuesta);
        usuario.actualizarSaldo(ganancia);
        actualizarResultado(tipoApuesta);
    }

    private char getTipoApuestaSeleccionada() {
        String tipo = (String) cmbTipoApuesta.getSelectedItem();
        String seleccion = (String) cmbSeleccion.getSelectedItem();

        if (tipo.equals("Color")) {
            return (seleccion.equals("Rojo")) ? 'R' : 'N';
        } else {
            return (seleccion.equals("Par")) ? 'P' : 'I';
        }
    }

    private void actualizarResultado(char tipoApuesta) {
        int numero = motorRuleta.getUltimoNumero();
        boolean acierto = motorRuleta.getUltimoAcierto();
        String color = (numero == 0) ? "Verde" : (motorRuleta.esRojo(numero) ? "Rojo" : "Negro");
        String resultado = acierto ? "GANASTE" : "PERDISTE";

        lblResultado.setText(String.format("Número: %d (%s) | Apuesta: %c | Monto: %s | %s",
                numero, color, tipoApuesta, txtMonto.getText(), resultado));

        lblSaldo.setText("Saldo: " + usuario.getSaldo());
    }

    public void mostrarVentana() {
        frame.setVisible(true);
    }
}