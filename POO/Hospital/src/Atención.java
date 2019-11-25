import java.util.Iterator;
import java.util.PriorityQueue;

public class Atención {

    public static void main(String[] args) {

        Hospital atención = new Hospital();

        atención.registrarPaciente(new Paciente("María", 42, 2));
        atención.registrarPaciente(new Paciente("Marcos", 45, 1));
        atención.registrarPaciente(new Paciente("Jesús", 21, 8));
        atención.registrarPaciente(new Paciente("Lucía", 65, 5));
        atención.registrarPaciente(new Paciente("Marcos", 12, 1));

        atención.atenderPaciente();
        atención.IncidenciaGravedad("Jesús");
        atención.atenderPaciente();

        Iterator<Paciente> iterador = atención.pacientes.iterator();
        while (iterador.hasNext()) {
            System.out.println(iterador.next());
        }

    }
}
