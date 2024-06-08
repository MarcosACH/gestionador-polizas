
public class Vehiculo {
    private String dominio;
    private int monto_compra;
    private int año_fabricacion;

    public Vehiculo(String dominio, int monto_compra, int año_fabricacion) {
        this.dominio = dominio;
        this.monto_compra = monto_compra;
        this.año_fabricacion = año_fabricacion;
    }

    public int getMontoCompra() {
        return monto_compra;
    }

    public int getAñoFabricacion() {
        return año_fabricacion;
    }

    @Override
    public String toString() {
        String salida = "";
        salida += "-- Vehiculo --";
        salida += "\n - Dominio: " + dominio;
        salida += "\n - Año: " + año_fabricacion;
        salida += "\n - Monto compra: " + monto_compra;
        return salida;
    }
}
