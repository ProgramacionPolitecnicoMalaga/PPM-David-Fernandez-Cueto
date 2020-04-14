package Factory_Method;

import Modelo.ListaNacionalidades;
import Modelo.Nacionalidad;

import java.util.ArrayList;

public class ImpresoraHTML implements Impresora {

    @Override
    public void imprimir(ArrayList<Nacionalidad> nacionalidades) {
        String html = "<table> \n <tr> \n <th>Nacionalidad</th><th>Año</th><th>Total</th> \n </tr>";

        for (Nacionalidad nacionalidad : nacionalidades) {
            html += "<tr> \n <td>" + nacionalidad.getNacionalidad() + "</td><td>" + nacionalidad.getAnio() + "</td><td>" + nacionalidad.getEmpadronados() + "</td> \n </tr> \n";
        }
        html += "</table>";
        System.out.println(html);
    }
}
