package controlador;

import modelo.Resultado;

import java.util.List;
import java.util.ArrayList;

public class RepositorioEnMemoria implements IRepositorioResultados {
    private final List<Resultado> historial;

    public RepositorioEnMemoria() {
        this.historial = new ArrayList<>();
    }

    @Override
    public void agregarResultado(Resultado r) {
        this.historial.add(r);
    }

    @Override
    public List<Resultado> getHistorial() {
        return this.historial;
    }   
}
