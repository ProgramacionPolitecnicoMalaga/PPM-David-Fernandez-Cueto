import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class Persona {

    String nombre;
    String tipo;
    ArrayList<String> notificaciones;
    ArrayList<String> tareasPendientes;
    ArrayList<String> tareasRealizadas;

    public Persona(String nombre) {
        this.nombre = nombre;
        this.tipo = tipo;
        notificaciones = new ArrayList<>();
        tareasPendientes = new ArrayList<>();
        tareasRealizadas = new ArrayList<>();
    }

    public void realizarTarea (int indiceTarea) {
        String tarea = tareasPendientes.get(indiceTarea);
        tareasPendientes.remove(indiceTarea);
        tareasRealizadas.add(tarea);
    }

    public void imprimirTareasPendientes() {
        System.out.println("TAREAS PENDIENTES DE REALIZAR");
        for (String tarea : tareasPendientes) {
            System.out.println(tarea);
        }
    }

    public void imprimirTareasRealizadas() {
        System.out.println("TAREAS COMPLETADAS");
        for (String tarea : tareasRealizadas) {
            System.out.println(tarea);
        }    }
}
