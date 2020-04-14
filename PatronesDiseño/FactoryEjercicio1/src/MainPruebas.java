import Cliente.PeticionImpresora;
import DOM.GestorXML;
import Factory_Method.Impresora;
import Factory_Method.ImpresoraHTML;
import Factory_Method.ImpresoraTexto;
import Modelo.ListaNacionalidades;

public class MainPruebas {
    private static ListaNacionalidades listaNacionalidades;
    private static PeticionImpresora peticionImpresora;
    private static Impresora impresora;

    public static void main(String[] args) {
        inicializar();
        impresora.imprimir(listaNacionalidades.getNacionalidades());

    }



    public static void inicializar () {
        GestorXML gestorXML = new GestorXML();
        listaNacionalidades = gestorXML.cargarNacionalidades();
        peticionImpresora = new PeticionImpresora();

        if (peticionImpresora.getTipo().equalsIgnoreCase("html")) {
            impresora = new ImpresoraHTML();
        }
        else if (peticionImpresora.getTipo().equalsIgnoreCase("texto")) {
            impresora = new ImpresoraTexto();
        }
        else
            throw new IllegalArgumentException("No existe ese tipo de impresora");
    }
}
