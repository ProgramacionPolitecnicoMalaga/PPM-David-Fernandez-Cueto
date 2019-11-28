public class Actividad {

    private final static int MANTENIMIENTO = 1;
    private final static int DESARROLLO = 2;
    private final static int REFACTORIZACIÓN = 3;
    private final static int TEST = 4;
    private final static int INDEFINIDO = 5;

    String descripción;


    public Actividad(int tipoDeActividad) {
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

    }

    @Override
    public String toString() {
        return "Actividad{" +
                "descripción='" + descripción + '\'' +
                '}';
    }
}
