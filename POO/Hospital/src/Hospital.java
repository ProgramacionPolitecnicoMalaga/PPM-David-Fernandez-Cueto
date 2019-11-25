import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

public class Hospital implements GestionDePacientes {

    PriorityQueue<Paciente> pacientes;

    public Hospital() {
        pacientes = new PriorityQueue<>(Paciente.COMPARATOR_URGENCIA);
    }


    public void registrarPaciente (Paciente paciente) {
        pacientes.add(paciente);
    }

    public void atenderPaciente () {
        Iterator<Paciente> iterador = pacientes.iterator();
        pacientes.poll();
    }


    public void IncidenciaGravedad (String nombre) {
        Iterator<Paciente> iterador = pacientes.iterator();
        while (iterador.hasNext()) {
            Paciente pacienteBuscado = iterador.next();
            if (pacienteBuscado.getNombre().equalsIgnoreCase(nombre)) {
                pacienteBuscado.setGravedad(true);
                pacienteBuscado.setIdEspecialidad(1);
                pacientes.remove(pacienteBuscado);
            }

        }
    }


    @Override
    public String toString() {
        return "Hospital{" +
                "pacientes=" + pacientes +
                '}';
    }

}
