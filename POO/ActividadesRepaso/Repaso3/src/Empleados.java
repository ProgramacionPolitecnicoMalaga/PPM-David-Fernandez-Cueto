import java.util.ArrayList;
import java.util.Iterator;

public class Empleados {
        ArrayList<Empleado> listaEmpleados;

        public Empleados() {
            listaEmpleados = new ArrayList<>();
        }

        public void addEmpleado(Empleado empleado) {
            listaEmpleados.add(empleado);
        }

        public void generarInforme () {
            System.out.println(listaEmpleados);
            }


    public void mostrarLista() {
        System.out.println(listaEmpleados);
    }
}
