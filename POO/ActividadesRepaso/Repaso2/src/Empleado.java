import java.util.ArrayList;

public class Empleado {

    String nombre;
    int[] ventas = new int[5];
    Empleados listaEmpleados;

    public Empleado() {
    }

    public Empleado (String nombre, int L, int M, int X, int J, int V) {
        this.nombre = nombre;
        ventas[0] = L;
        ventas[1] = M;
        ventas[2] = X;
        ventas[3] = J;
        ventas[4] = V;
    }


    @Override
    public String toString() {
        return "Empleado{" +
                "nombre='" + nombre + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        return nombre.equals(obj);
    }

    public String getNombre() {
        return nombre;
    }
}
