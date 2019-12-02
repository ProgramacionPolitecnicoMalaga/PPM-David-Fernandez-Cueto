import java.util.LinkedList;

public class Proyecto {

    String nombre;
    String departamento;
    double fprod;
    String Descripción;
    long duracionHoras;
    LinkedList<String> listaActividades;

    public Proyecto () {}

    public Proyecto(String nombre, String departamento, double fprod, String descripción, long duracionHoras) {
        this.nombre = nombre;
        this.departamento = departamento;
        this.fprod = fprod;
        Descripción = descripción;
        this.duracionHoras = duracionHoras;
        listaActividades = new LinkedList<>();
    }

    public void addActividadAProyecto (String descripciónActividad) {
        listaActividades.add(descripciónActividad);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public double getFprod() {
        return fprod;
    }

    public void setFprod(double fprod) {
        this.fprod = fprod;
    }

    public String getDescripción() {
        return Descripción;
    }

    public void setDescripción(String descripción) {
        Descripción = descripción;
    }

    @Override
    public String toString() {
        return "Proyecto{" +
                "nombre='" + nombre + '\'' +
                ", departamento='" + departamento + '\'' +
                ", fprod=" + fprod +
                ", Descripción='" + Descripción + '\'' +
                ", duracionHoras=" + duracionHoras +
                '}';
    }
}
