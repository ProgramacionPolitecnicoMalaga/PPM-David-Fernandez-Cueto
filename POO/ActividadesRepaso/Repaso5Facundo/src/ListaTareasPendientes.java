import java.util.ArrayList;

public class ListaTareasPendientes {

    ArrayList<Tarea> tareasPendientes;

    public ListaTareasPendientes () {
        tareasPendientes = new ArrayList<>();
    }

    public void addTareaPendiente (Tarea tarea) {
        tareasPendientes.add(tarea);
    }
}
