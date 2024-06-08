import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Poliza {
    private Cliente cliente;
    private Vehiculo vehiculo;
    private int monto_asegurado;
    private LocalDate fecha_inicio;
    private LocalDate fecha_caducacion;
    private int costo_anual;

    public Poliza(Cliente cliente, Vehiculo vehiculo, LocalDate fecha_inicio, LocalDate fecha_caducacion) {
        this.cliente = cliente;
        this.vehiculo = vehiculo;
        this.fecha_inicio = fecha_inicio;
        this.fecha_caducacion = fecha_caducacion;
        this.monto_asegurado = getMontoPolizaVehiculo();

        if (getEdadCliente() < 30) {
            this.costo_anual = (int) (monto_asegurado * 0.2);
        } else {
            this.costo_anual = (int) (monto_asegurado * 0.1);
        }
    }

    public Poliza(Cliente cliente, int monto_asegurado, LocalDate fecha_inicio, LocalDate fecha_caducacion) {
        this.cliente = cliente;
        this.monto_asegurado = monto_asegurado;
        this.fecha_inicio = fecha_inicio;
        this.fecha_caducacion = fecha_caducacion;

        if (getEdadCliente() < 35) {
            this.costo_anual = (int) (monto_asegurado * 0.05);
        } else {
            this.costo_anual = (int) (monto_asegurado * 0.1);
        }
    }

    public int getMontoPolizaVehiculo() {
        int antiguedad = fecha_inicio.getYear() - vehiculo.getAñoFabricacion();
        int porcentaje_cotizacion = (int) (1 - antiguedad * 0.05);
        int monto = vehiculo.getMontoCompra() * porcentaje_cotizacion;
        return monto;
    }

    public int getEdadCliente() {
        int edad = (int) ChronoUnit.YEARS.between(cliente.getFechaNac(), fecha_inicio);
        return edad;
    }

    public boolean esVigente() {
        return fecha_caducacion.isAfter(LocalDate.now()) || fecha_caducacion.isEqual(LocalDate.now());
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        String salida = "";
        salida += "-- Poliza --";
        salida += "\n " + cliente;
        salida += "\n - Monto asegurado: " + monto_asegurado;
        salida += "\n - Costo Anual: " + costo_anual;
        salida += "\n - Vigencia desde: " + fecha_inicio;
        salida += "\n - Vigencia hasta: " + fecha_caducacion;
        salida += "\n - Esta vigente: SI";
        return salida;
    }
}
