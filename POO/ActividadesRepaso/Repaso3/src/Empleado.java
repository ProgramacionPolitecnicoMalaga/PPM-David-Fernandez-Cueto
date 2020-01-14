public class Empleado {
    String nombre;
    String apellidos;
    double salario;
    Sueldo sueldo = new Sueldo();
    String tipoEmpleado;

    public Empleado(String nombre, String apellidos) {
        this.nombre = nombre;
        this.apellidos = apellidos;
    }


    @Override
    public String toString() {
        return "Empleado{" +
                "nombre='" + nombre + '\'' +
                ", Apellidos='" + apellidos + '\'' +
                ", salario=" + salario +
                ", tipo=" + tipoEmpleado +
                '}';
    }
}
