import java.util.ArrayList;

public class FigurasGeometricas {

    ArrayList<Figura> listaFiguras;

    public FigurasGeometricas () {
        listaFiguras = new ArrayList<>();
    }

    public void addFigura(Figura figura) {
        listaFiguras.add(figura);
    }

    public void mostrarFiguras() {
        System.out.println(listaFiguras);
    }
}
