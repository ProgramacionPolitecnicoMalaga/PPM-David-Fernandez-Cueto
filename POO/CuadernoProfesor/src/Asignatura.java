import java.util.HashMap;
import java.util.LinkedList;

public class Asignatura {

    String id;
    String nombre;
   // LinkedList<Indicador> indicadores;
    LinkedList<Alumno> alumnos;
    HashMap<Alumno, LinkedList<Indicador>> notas;

    public Asignatura() {}

    public Asignatura(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        notas = new HashMap<>();
        alumnos = new LinkedList<>();
    }

    public void matricularAlumno (Alumno alumno)  {
        alumnos.add(alumno);
        notas.put(alumno, new LinkedList<Indicador>());
    }

    public void setIndicadorAlumno (Alumno alumno, Indicador indicador) {
        notas.get(alumno).add(indicador);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LinkedList<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(LinkedList<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    public HashMap<Alumno, LinkedList<Indicador>> getNotas() {
        return notas;
    }

    @Override
    public String toString() {
        return "Asignatura{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
