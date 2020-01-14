public class Comisionado extends Empleado {
    int ventas;
    //Sueldo sueldo;

    public Comisionado(String nombre, String apellidos, int ventas) {
        super(nombre, apellidos);
        this.ventas = ventas;
        salario = sueldo.sueldoBase + sueldo.comision*ventas;
        tipoEmpleado = "Comisionado";
    }
}
