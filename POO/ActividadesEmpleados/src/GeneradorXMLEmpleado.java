import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class GeneradorXMLEmpleado {

    Empleado empleado = new Empleado();
    Document dom;

    public GeneradorXMLEmpleado() {}

    public void GenerarXML (LinkedList<Empleado> listaEmpleados, String DNI) throws IOException {
        ListIterator<Empleado> iterador = listaEmpleados.listIterator();

        while (iterador.hasNext()) {
            empleado = iterador.next();
            if (empleado.getDNI().equalsIgnoreCase(DNI)) {
                DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
                try {
                    DocumentBuilder db = dbf.newDocumentBuilder();
                    dom = db.newDocument();
                } catch (ParserConfigurationException e) {
                    e.printStackTrace();
                }

                Element root = dom.createElement("empleado");
                dom.appendChild(root);
                Element nombreEle = dom.createElement("nombre");
                Text nombreText = dom.createTextNode(empleado.getNombreCompleto());
                nombreEle.appendChild(nombreText);

                Element actividadesEle = dom.createElement("actividades");
                Text actividadesText = dom.createTextNode(empleado.getActividadesInscritas());
                actividadesEle.appendChild(actividadesText);


                root.appendChild(nombreEle);
                root.appendChild(actividadesEle);

                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                try {
                    Transformer transformer = transformerFactory.newTransformer();
                    transformer.setOutputProperty(OutputKeys.INDENT, "yes");
                    transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
                    DOMSource source = new DOMSource(dom);
                    StreamResult result = new StreamResult(new File(empleado.getDNI()));
                    transformer.transform(source, result);
                } catch (TransformerConfigurationException e) {
                    e.printStackTrace();
                } catch (TransformerException e) {
                    e.printStackTrace();
                }


               /* FileWriter write = new FileWriter(DNI+".xml");
                PrintWriter print_line = new PrintWriter(write);
                print_line.println("<?xml version ='1.0' encoding='UTF-8'?>");
                print_line.print("<empleado nombre='" + empleado.getNombreCompleto() + "'>");
                */

            }
        }

    }

    private void printToFile() {

    }
}
