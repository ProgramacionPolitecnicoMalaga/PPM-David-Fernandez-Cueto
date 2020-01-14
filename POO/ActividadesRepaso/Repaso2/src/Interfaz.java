import java.util.ArrayList;
import java.util.Iterator;

public class Interfaz {

    //Empleado empleado;
    //Empleados empleados;

    public Interfaz () {}

    public void mostarMenu() {

    }

    public Empleados empleadosVentasNumeroItems (Empleados empleados, int cantidad) {
     Empleados listaAbuscar = new Empleados();
        Iterator<Empleado> iterador = empleados.listaEmpleados.iterator();
        while (iterador.hasNext()) {
            Empleado empleado = iterador.next();
            boolean encontrado = false;
            for (int i = 0; i < empleado.ventas.length && encontrado == false; i++) {
                if (empleado.ventas[i] == cantidad) {
                    listaAbuscar.listaEmpleados.add(empleado);
                    encontrado = true;

                }
            }
        }
    return listaAbuscar; }

    public void imprimirLista(Empleados lista) {
        Iterator<Empleado> iterator = lista.listaEmpleados.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    public double calcularPromedioVentas (String nombre, Empleados lista) {
        int suma = 0;
        double promedio = 0;
        Iterator<Empleado> iterator = lista.listaEmpleados.iterator();
        Empleado empleadoAbuscar = null;
        boolean encontrado = false;
        while (iterator.hasNext() && !encontrado) {
            Empleado empleado = iterator.next();
            if (empleado.getNombre().equals(nombre)) {
                empleadoAbuscar = empleado;
                encontrado = true;
                for (int f = 0; f < empleadoAbuscar.ventas.length; f++) {
                    suma = suma + empleadoAbuscar.ventas[f];
                }
                promedio = suma/5;

            }
        }

    return promedio; }

    public String empleadoMayorNumVentas(Empleados lista) {

        Empleado empleadoAbuscar = null;
        Iterator<Empleado> iterator = lista.listaEmpleados.iterator();
        int mayor = 0;
        String nombre = "";

        while (iterator.hasNext()) {
            Empleado empleado = iterator.next();

            for (int i = 0; i < empleado.ventas.length; i++) {
                if (empleado.ventas[i] > mayor) {
                    mayor = empleado.ventas[i];
                    nombre = empleado.getNombre();
                }
            }
        }
    return  nombre; }


}
