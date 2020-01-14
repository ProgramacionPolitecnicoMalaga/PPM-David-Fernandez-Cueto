public class Main {

    public static void main(String[] args) {

        Interfaz interfaz = new Interfaz();
        Empleados listaEmpleados = new Empleados();

        listaEmpleados.addEmpleado(new Empleado("Isabel", 4, 6, 7, 5, 6));
        listaEmpleados.addEmpleado(new Empleado("Vicente", 5, 6, 5, 4, 2));



        //System.out.println(interfaz.empleadosVentasNumeroItems(empleado, 7));

        System.out.println(listaEmpleados.listaEmpleados);
        System.out.println(interfaz.empleadosVentasNumeroItems(listaEmpleados, 7));

        System.out.println(interfaz.calcularPromedioVentas("Isabel", listaEmpleados));

        System.out.println(interfaz.empleadoMayorNumVentas(listaEmpleados));

        listaEmpleados.addEmpleado(new Empleado("Mariano", 6, 7, 4, 3, 8));

        System.out.println(interfaz.empleadoMayorNumVentas(listaEmpleados));

    }
}
