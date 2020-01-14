public class Asalariado extends  Empleado {
    //Sueldo sueldo;

    public Asalariado(String nombre, String apellidos) {
        super(nombre, apellidos);
        this.salario = sueldo.sueldoBase;
        tipoEmpleado = "Asalariado";

    }
}
