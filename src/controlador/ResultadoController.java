package controlador;

import modelo.Resultado;

import java.util.ArrayList;
import java.util.List;

public class ResultadoController {

    private final List<Resultado> historial;

    public ResultadoController() {
        this.historial = new ArrayList<>();
    }

    public void agregarResultado(Resultado resultado) {
        this.historial.add(resultado);
    }

    public List<Resultado> getHistorial() {
        return historial;
    }
}
