import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;

public class Tarea {

    String descripcion;
    Date fechaLimite;
    boolean realizada;

    private static ArrayList<Tarea> historial = new ArrayList<>();
    private static ArrayList<Tarea> pendientes = new ArrayList<>();
    private static ArrayList<Tarea> completadas = new ArrayList<>();

    public Tarea () {}

    public Tarea (String descripcion, Date fechaLimite) {
        this.descripcion = descripcion;
        this.fechaLimite = fechaLimite;
        realizada = false;
        pendientes.add(this);
        historial.add(this);
    }

    public void completarTarea () {
        realizada = true;
        pendientes.remove(this);
        completadas.add(this);
    }

    public void mostrarTareasPendientes () {
        System.out.println("TAREAS PENDIENTES");
        Iterator<Tarea> iterator = pendientes.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("===============================");
    }

    public void mostrarTareasCompletadas () {

        System.out.println("TAREAS COMPLETADAS");
        Iterator<Tarea> iterator = completadas.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("====================================");
    }

    public void mostrarTareasPorFecha (Date date) {
        System.out.println("TAREAS EN FECHA");
        Iterator<Tarea> iterator = historial.iterator();
        while (iterator.hasNext()) {
            Tarea tarea = iterator.next();
            if (tarea.fechaLimite.equals(date)) {
                System.out.println(tarea);
            }
        }
    }

    public void mostrarTareasEnTiempo () {
        System.out.println("TAREAS EN TIEMPO");
        Date fechaActual = new Date();
        Iterator<Tarea> iterator = pendientes.iterator();
        while (iterator.hasNext()) {
            Tarea tarea = iterator.next();
            if (fechaActual.before(tarea.getFechaLimite())) {
                System.out.println(tarea);
            }
        }
    }

    public void mostrarTareasRetrasadas () {
        System.out.println("TAREAS RETRASADAS");
        Date fechaActual = new Date();
        Iterator<Tarea> iterator = pendientes.iterator();
        while (iterator.hasNext()) {
            Tarea tarea = iterator.next();
            if (tarea.getFechaLimite().after(fechaActual)) {
                System.out.println(tarea);
            }
        }
        System.out.println(fechaActual.toString());
    }

    public Date getFechaLimite() {
        return fechaLimite;
    }

    @Override
    public String toString() {
        return "Tarea{" +
                "descripcion='" + descripcion + '\'' +
                ", fechaLimite=" + fechaLimite +
                '}';
    }
}
