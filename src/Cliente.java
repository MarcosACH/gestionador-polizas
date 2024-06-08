import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Cliente {
    private String nombre;
    private String apellido;
    private LocalDate fecha_nac;

    public Cliente(String nombre, String apellido, LocalDate fecha_nac) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fecha_nac = fecha_nac;
    }

    public LocalDate getFechaNac() {
        return fecha_nac;
    }

    public int getEdad() {
        int edad = (int) ChronoUnit.YEARS.between(fecha_nac, LocalDate.now());
        return edad;
    }

    @Override
    public String toString() {
        return "- Cliente: " + nombre + " " + apellido + " " + "(" + getEdad() + ")";
    }
}
