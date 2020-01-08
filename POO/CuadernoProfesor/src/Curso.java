import java.util.LinkedList;

public class Curso {

    String id;
    String nombre;
    LinkedList<Asignatura> asignaturas;
    //LinkedList<Alumno> alumnos;

    public Curso() {}

    public Curso(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        asignaturas = new LinkedList<>();
    }

    public void addAsignaturaAlCurso(Asignatura asignatura) {
        asignaturas.add(asignatura);
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

    public LinkedList<Asignatura> getAsignaturas() {
        return asignaturas;
    }

    public void setAsignaturas(LinkedList<Asignatura> asignaturas) {
        this.asignaturas = asignaturas;
    }
/*
    public LinkedList<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(LinkedList<Alumno> alumnos) {
        this.alumnos = alumnos;
    }
*/


    @Override
    public String toString() {
        return "Curso{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
