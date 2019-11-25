import java.util.Comparator;

public class Paciente{

    String nombre;
    int edad;
    int idEspecialidad;
    boolean gravedad;

    public Paciente(String nombre, int edad, int idEspecialidad) {
        this.nombre = nombre;
        this.edad = edad;
        this.idEspecialidad = idEspecialidad;
        gravedad = false;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getIdEspecialidad() {
        return idEspecialidad;
    }

    public void setIdEspecialidad(int idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }

    public boolean isGravedad() {
        return gravedad;
    }

    public void setGravedad(boolean gravedad) {
        this.gravedad = gravedad;
    }


    public static final Comparator<Paciente> COMPARATOR_URGENCIA = new Comparator<Paciente>() {
        @Override
        public int compare(Paciente paciente, Paciente t1) {
            return paciente.getIdEspecialidad() > t1.getIdEspecialidad() ? 1 :
                    paciente.getIdEspecialidad() < t1.getIdEspecialidad() ? -1:
                    0;
        }
    };



    @Override
    public String toString() {
        return "Paciente{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", idEspecialidad=" + idEspecialidad +
                ", gravedad=" + gravedad +
                '}';
    }
}
