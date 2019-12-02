import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.ListIterator;

import static java.io.File.*;

public class XMLProyectos {

    LinkedList<Proyecto> listaProyectos = new LinkedList<>();
    Document dom;


    public void leerXML(String archivo) {

        try {
            String dir = System.getProperty("user.dir");
            File archEnt = new File(dir + separator + archivo);
            DocumentBuilderFactory factoria = DocumentBuilderFactory.newDefaultInstance();
            DocumentBuilder constructor = factoria.newDocumentBuilder();
            Document doc = constructor.parse(archEnt);
            doc.getDocumentElement().normalize();
            NodeList nodos = doc.getElementsByTagName("proyecto");
            for (int i = 0; i < nodos.getLength(); i++) {
                Node nodo = nodos.item(i);
                listaProyectos.add(new Proyecto(nodo.getAttributes().getNamedItem("nombre").getNodeValue().trim(),
                        nodo.getAttributes().getNamedItem("departamento").getNodeValue(),
                        Double.parseDouble(nodo.getAttributes().getNamedItem("fprod").getNodeValue()),
                        nodo.getTextContent(), Long.parseLong(nodo.getAttributes().getNamedItem("duración").getNodeValue())));
            }
        } catch (ParserConfigurationException e) {
        } catch (SAXException e) {
        } catch (IOException e) {
        }
    }

    public void generarXMLProyectoActividad (String nombre) {
        ListIterator<Proyecto> iterador = listaProyectos.listIterator();
        while (iterador.hasNext()) {
            Proyecto proyecto = iterador.next();
            if (proyecto.getNombre().equalsIgnoreCase(nombre)) {
                DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
                try {
                    DocumentBuilder db = dbf.newDocumentBuilder();
                    dom = db.newDocument();
                } catch (ParserConfigurationException e) {
                    e.printStackTrace();
                }

                Element root = dom.createElement("proyecto");
                dom.appendChild(root);
                root.setAttribute("nombre", proyecto.getNombre());

                ListIterator<String> listIterator = proyecto.listaActividades.listIterator();
                while (listIterator.hasNext()) {
                    Element actividadEle = dom.createElement("Actividad");
                    Text actividadText = dom.createTextNode(listIterator.next());
                    actividadEle.appendChild(actividadText);
                    root.appendChild(actividadEle);
                }
                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                try {
                    Transformer transformer = transformerFactory.newTransformer();
                    transformer.setOutputProperty(OutputKeys.INDENT, "yes");
                    transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
                    DOMSource source = new DOMSource(dom);
                    StreamResult result = new StreamResult(new File(proyecto.getNombre()));
                    transformer.transform(source, result);
                } catch (TransformerConfigurationException e) {
                    e.printStackTrace();
                } catch (TransformerException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    @Override
    public String toString() {
        return "XMLProyectos{" +
                "listaProyectos=" + listaProyectos +
                '}';
    }
}
