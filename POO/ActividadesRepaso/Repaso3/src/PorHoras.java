public class PorHoras extends Empleado {
    int horas;
    //Sueldo sueldo;

    public PorHoras(String nombre, String apellidos, int horas) {
        super(nombre, apellidos);
        this.horas = horas;
        salario = horas*sueldo.sueldoPorHora;
        tipoEmpleado = "Por horas";
    }
}
