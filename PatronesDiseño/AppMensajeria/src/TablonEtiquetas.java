import java.util.ArrayList;

public class TablonEtiquetas {

    ArrayList<String> etiquetasPublicadas;

    public TablonEtiquetas() {
        etiquetasPublicadas = new ArrayList<>();
    }


    public ArrayList<String> getEtiquetasPublicadas() {
        return etiquetasPublicadas;
    }

    public void addEtiquetaAlTablon (String mensaje) {
        etiquetasPublicadas.add(mensaje);
    }
}
