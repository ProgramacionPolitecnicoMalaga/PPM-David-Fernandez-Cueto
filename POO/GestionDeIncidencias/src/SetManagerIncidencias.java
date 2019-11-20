import java.util.HashSet;
import java.util.Iterator;

public class SetManagerIncidencias implements ManagerIncidencias {

    HashSet<Incidencia> incidenciasActivas;

    public SetManagerIncidencias () {
        incidenciasActivas = new HashSet<>();

    }
    @Override
    public void insertarIncidencia(Incidencia incidencia) {
        incidenciasActivas.add(incidencia);
    }

    @Override
    public void resolverIncidencia(Incidencia incidencia) {
        incidenciasActivas.remove(incidencia);

    }

    public void imprimirIncidencias() {
        Iterator<Incidencia> it = incidenciasActivas.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
