import java.util.Comparator;

public class COMPARATORID implements Comparator<Paciente> {
    @Override
    public int compare(Paciente paciente, Paciente t1) {
        return paciente.getIdEspecialidad() < t1.getIdEspecialidad() ? 1 :
                paciente.getIdEspecialidad() > t1.getIdEspecialidad() ? -1:
                        0;
    }
}
