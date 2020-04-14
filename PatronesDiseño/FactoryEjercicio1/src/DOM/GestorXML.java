package DOM;

import Modelo.ListaNacionalidades;
import Modelo.Nacionalidad;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.io.IOException;

public class GestorXML {

    String dir = System.getProperty("user.dir");

    public NodeList getNodes () {
        NodeList nacionalidades = null;
        try {
            File inputFile = new File(dir + File.separator + "poblacion-por-nacionalidades_2016-2018.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
		/*
		    DocumentBuilder.parse(file) puede generar:
		        IOException  - Error de lectura del archivo
                SAXException - Error de parseo
                IllegalArgumentException  - Cuando el archivo "file" es null
		*/
            doc.getDocumentElement().normalize();
            XPath xPath = XPathFactory.newInstance().newXPath();
             nacionalidades = (NodeList) xPath.compile("/root/row").evaluate(doc, XPathConstants.NODESET);


        } catch (IOException | ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }
     return nacionalidades; }

     public ListaNacionalidades cargarNacionalidades() {
         ListaNacionalidades nacionalidades = new ListaNacionalidades();
        NodeList listaNacionalidades = getNodes();
        if (listaNacionalidades != null) {
            for (int f = 0; f < listaNacionalidades.getLength(); f++) {
                Node nacionalidad = listaNacionalidades.item(f);
                NamedNodeMap atributos = nacionalidad.getAttributes();
                String nombreNacionalidad = atributos.getNamedItem("Nacionalidad").getTextContent();
                int anio = Integer.parseInt(atributos.getNamedItem("Año").getTextContent());
                int empadronados = Integer.parseInt(atributos.getNamedItem("Número_de_empadronados").getTextContent());
                nacionalidades.addNacionalidad(new Nacionalidad(nombreNacionalidad, anio, empadronados));
            }
        }
     return nacionalidades; }
}
