public class GeneradorNominas {

    public String generarNomina (Empleado empleado) {
        return empleado.nombre + " - Salario: " + empleado.salario;
    }
}
