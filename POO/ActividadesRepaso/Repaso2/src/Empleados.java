import java.util.ArrayList;

public class Empleados {

    ArrayList<Empleado> listaEmpleados;

    public Empleados () {
        listaEmpleados = new ArrayList<>();
    }

    public void addEmpleado (Empleado empleado) {
        listaEmpleados.add(empleado);
    }

    @Override
    public String toString() {
        return "Empleados{" +
                "listaEmpleados=" + listaEmpleados +
                '}';
    }
}
