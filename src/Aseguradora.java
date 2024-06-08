import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Aseguradora {
    private List<Poliza> polizas_automotor;
    private List<Poliza> polizas_vida;

    public Aseguradora() {
        this.polizas_automotor = new ArrayList<>();
        this.polizas_vida = new ArrayList<>();
    }

    public Poliza asegurarVehiculo(Cliente cliente, Vehiculo vehiculo, LocalDate fecha_inicio,
            LocalDate fecha_caducacion) {
        Poliza poliza_automotor = new Poliza(cliente, vehiculo, fecha_inicio, fecha_caducacion);
        this.polizas_automotor.add(poliza_automotor);
        return poliza_automotor;
    }

    public Poliza asegurarVida(Cliente cliente, int monto_asegurado, LocalDate fecha_inicio,
            LocalDate fecha_caducacion) {
        Poliza poliza_vida = new Poliza(cliente, monto_asegurado, fecha_inicio, fecha_caducacion);
        this.polizas_vida.add(poliza_vida);
        return poliza_vida;
    }

    public void mostrarPolizas() {
        System.out.println("--- Polizas Vigentes ---");
        for (Poliza poliza : polizas_automotor) {
            if (poliza.esVigente()) {
                String salida = "";
                salida += poliza;
                salida += "\n" + poliza.getVehiculo();
                System.out.println(salida);
            }
        }

        for (Poliza poliza : polizas_vida) {
            if (poliza.esVigente()) {
                String salida = "";
                salida += poliza;
                System.out.println(salida);
            }
        }
    }

    public void transferirPoliza(Poliza poliza, Cliente nuevo_cliente) {
        if (polizas_automotor.contains(poliza) & poliza.esVigente()) {
            poliza.setCliente(nuevo_cliente);
        }
    }
}
