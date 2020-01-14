public class Main {

    public static void main(String[] args) {
        Empleados listaEmpleados = new Empleados();
        //empleados.addEmpleado(new Empleado("Manuel", "Gonzalez"));

       listaEmpleados.addEmpleado(new Comisionado("Jorge", "Guillén", 5));
        listaEmpleados.addEmpleado(new PorHoras("Mario", "Gaspar", 20));
        listaEmpleados.addEmpleado(new Asalariado("Borja", "Hurón"));

        listaEmpleados.generarInforme();
    }


}
