import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;

public class VentanaMenu {

    private final JFrame frame;
    private final Usuario usuario;

    private final JLabel lblTitulo = new JLabel("RULETA - Casino Black Cat");
    private final JLabel lblBienvenida = new JLabel("Bienvenido/a al menu principal.");
    private final JLabel lblInstrucciones = new JLabel("A la izquierda tienes las opciones:");
    private final JLabel lblUsuarioLogueado;

    private final JButton btnJugar = new JButton("Jugar");
    private final JButton btnHistorial = new JButton("Historial");
    private final JButton btnSalir = new JButton("Salir");

    public VentanaMenu(Usuario usuario) {
        this.usuario = usuario;
        this.frame = new JFrame("Menu Principal - Black Cat");
        this.lblUsuarioLogueado = new JLabel(usuario.getNombre());
        configurarVentana();
        agregarEventos();
    }

    private void configurarVentana() {
        frame.setLayout(null);
        frame.setSize(500, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        btnJugar.setBounds(20, 70, 100, 30);
        btnHistorial.setBounds(20, 110, 100, 30);
        btnSalir.setBounds(20, 150, 100, 30);

        lblTitulo.setBounds(150, 30, 300, 25);
        lblBienvenida.setBounds(150, 70, 300, 25);
        lblInstrucciones.setBounds(150, 95, 300, 25);

        lblUsuarioLogueado.setBounds(20, 230, 100, 25);

        frame.add(btnJugar); frame.add(btnHistorial); frame.add(btnSalir);
        frame.add(lblTitulo); frame.add(lblBienvenida); frame.add(lblInstrucciones);
        frame.add(lblUsuarioLogueado);
    }

    private void agregarEventos() {

        btnJugar.addActionListener(e -> {
            new VentanaJuego(usuario, frame).mostrarVentana();
        });

        btnHistorial.addActionListener(e -> {
            javax.swing.JOptionPane.showMessageDialog(frame, "Ventana 'Historial' (se implementara aparte).");
        });

        btnSalir.addActionListener(e -> {
            frame.dispose();
            new VentanaLogin().mostrarVentana();
        });
    }

    public void mostrarVentana() {
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}