import java.util.Iterator;

public class MainClass {

    public static void main(String[] args) {
        SetManagerIncidencias manager = new SetManagerIncidencias();

        manager.insertarIncidencia(new Incidencia(1, "PABERSE MATAO", "Contabilidad"));
        manager.insertarIncidencia(new Incidencia(2, "SE FUE LA LUZ", "Almacén"));
        manager.insertarIncidencia(new Incidencia(1, "CASI LA DIÑAMOS", "Contabilidad"));
        manager.insertarIncidencia(new Incidencia(3, "Dónde me he dejado las llaves", "Mi bolsillo"));

        manager.resolverIncidencia(new Incidencia(3, null, null));

        manager.imprimirIncidencias();
    }
}
