package Factory_Method;

import Modelo.ListaNacionalidades;
import Modelo.Nacionalidad;

import java.util.ArrayList;

public class ImpresoraTexto implements Impresora {

    @Override
    public void imprimir(ArrayList<Nacionalidad> nacionalidades) {

        String texto = "Listado de empadronamientos:\n";

        for (Nacionalidad nacionalidad : nacionalidades) {
            texto += "El total de empadronados en " + nacionalidad.getAnio() + " procedentes de " + nacionalidad.getNacionalidad() + " fue de " + nacionalidad.getEmpadronados() + " personas. \n";
        }
        System.out.println(texto);
    }
}
