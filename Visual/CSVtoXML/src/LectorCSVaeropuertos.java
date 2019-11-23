import org.jsefa.xml.XmlIOFactory;
import org.jsefa.xml.XmlSerializer;
import org.jsefa.xml.namespace.QName;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class LectorCSVaeropuertos {

    ArrayList<Aeropuerto> aeropuertos = new ArrayList<>();
    ArrayList<Aerolinea> aerolineas = new ArrayList<>();
    String [] datos = new String[13];
    Document dom;

    public LectorCSVaeropuertos() throws IOException {
        leerAeropuertos();

        createDocument();
        escribirXML();
    }

    public void run() {
        System.out.println("Empezando... ");
        createDOMTree();
        printToFile();
    }

    public void leerAeropuertos() {

        String fileName = "airports.csv";
        File file = new File(fileName);
        try {
            Scanner inputStream = new Scanner(file); // USAMOS EL SCANNER PARA LEER EL CONTENIDO DEL ARCHIVO
            while (inputStream.hasNext()){
                String data = inputStream.nextLine(); // OBTENEMOS LA LÍNEA ENTERA
                 datos = data.split(",");  // ALMACENAMOS EN UN ARRAY CADA ELEMENTO SEPARADO POR ";"
                Aeropuerto aeropuerto = new Aeropuerto(datos[1], datos[2], datos[3], datos[4], Double.parseDouble(datos[6]), Double.parseDouble(datos[7]));
                aeropuertos.add(aeropuerto);
                //System.out.println(aeropuerto);


            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }





    private void createDocument() {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();

            dom = db.newDocument();
        }catch (ParserConfigurationException e) {
            System.out.println("Error al instanciar DocumentBuilder");
            System.exit(1);
        }
    }

    private void createDOMTree() {
        Element root = dom.createElement("aeropuertos");
        dom.appendChild(root);

        Iterator it = aeropuertos.iterator();
        while (it.hasNext()) {
            Aeropuerto a = (Aeropuerto)it.next();
            Element aeropuertoEle = createAirportElement(a);
            root.appendChild(aeropuertoEle);
        }
    }

    private Element createAirportElement(Aeropuerto a){
        Element airportEle = dom.createElement("aeropuerto");
        airportEle.setAttribute("pais", a.getPais());

        Element nombreEle = dom.createElement("nombre");
        Text nombreText = dom.createTextNode(a.getNombre());
        nombreEle.appendChild(nombreText);

        Element iataEle = dom.createElement("iata");
        Text iataText = dom.createTextNode(a.getIata());
        iataEle.appendChild(iataText);

        Element localizacionEle = dom.createElement("localizacion");
        Element ciudadEle = dom.createElement("ciudad");
        Text ciudadText = dom.createTextNode(a.getCiudad());
        ciudadEle.appendChild(ciudadText);
        ciudadEle.appendChild(localizacionEle);

        airportEle.appendChild(nombreEle);
        airportEle.appendChild(iataEle);
        airportEle.appendChild(localizacionEle);

    return airportEle;
    }

    private void printToFile() {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        try {
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
            DOMSource source = new DOMSource(dom);
            StreamResult result = new StreamResult(new File("aeropuertos.xml"));
            transformer.transform(source, result);
            System.out.println("Archivo guardado");
        } catch (TransformerConfigurationException e) {
            System.out.println("error transformer exception");
        } catch (TransformerException e) {
        }
    }

    public void escribirXML() throws IOException {
        Iterator<Aeropuerto> iterator = aeropuertos.iterator();
        FileWriter write = new FileWriter("aeropuertos.txt");
        PrintWriter print_line = new PrintWriter(write);
        print_line.println("<?xml version ='1.0' encoding='UTF-8'?>");
        print_line.print("<aeropuertos>");


        while (iterator.hasNext()) {
            Aeropuerto aeropuerto = iterator.next();
            print_line.print("<aeropuerto " + "país: " + aeropuerto.getPais() + ">" + "<nombre>" + aeropuerto.getNombre()
            + "</nombre>" + "<iata>" + aeropuerto.getIata() + "</iata>" + "<localización><ciudad>" + aeropuerto.getCiudad()
            + "</ciudad><latitud>" + aeropuerto.getLat() + "</latitud><longitud>" + aeropuerto.getLon() +
                    "</longitud></localización></aeropuerto>");
        }
        print_line.print("</aeropuertos>");
    }


}

