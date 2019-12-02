public class Actividad {

     final static int MANTENIMIENTO = 1;
     final static int DESARROLLO = 2;
     final static int REFACTORIZACIÓN = 3;
     final static int TEST = 4;
     final static int INDEFINIDO = 5;

    String descripción;
    Proyecto proyecto;

    public Actividad () {}

    public Actividad(int tipoDeActividad, Proyecto proyecto) {
        switch (tipoDeActividad) {
            case MANTENIMIENTO : descripción = "Matenimiento";
            break;
            case DESARROLLO : descripción = "Desarrollo de aplicación";
            break;
            case REFACTORIZACIÓN : descripción = "Refactorizar código";
            break;
            case TEST : descripción = "Realizar pruebas";
            break;
            case INDEFINIDO : descripción = "Tarea sin determinar";
            break;
        }
        this.proyecto = proyecto;
        proyecto.addActividadAProyecto(descripción);
    }

    public String getDescripción() {
        return descripción;
    }

    public void setDescripción(String descripción) {
        this.descripción = descripción;
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    @Override
    public String toString() {
        return "Actividad{" +
                "descripción='" + descripción + '\'' +
                ", proyecto=" + proyecto.nombre +
                ", duración=" + proyecto.duracionHoras +
                '}';
    }
}
