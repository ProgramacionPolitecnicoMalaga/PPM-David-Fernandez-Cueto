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

public class LectorCSVaerolineas {

    ArrayList<Aeropuerto> aeropuertos = new ArrayList<>();
    ArrayList<Aerolinea> aerolineas = new ArrayList<>();
    String [] datos = new String[13];
    Document dom;

    public LectorCSVaerolineas() throws TransformerConfigurationException
    {
        leerAerolineas();

        createDocument();
    }

    public void run() throws IOException {
        System.out.println("Empezando... ");
        try {
            createDOMTree();

        }catch (TransformerException e ) {

        }
        printToFile();
        escribirXML();
    }


    public void leerAerolineas() {

        String fileName = "airlines.csv";
        File file = new File(fileName);
        try {
            Scanner inputStream = new Scanner(file); // USAMOS EL SCANNER PARA LEER EL CONTENIDO DEL ARCHIVO
            while (inputStream.hasNext()){
                String data = inputStream.nextLine(); // OBTENEMOS LA LÍNEA ENTERA
                datos = data.split(",");
                Aerolinea aerolinea = new Aerolinea(Integer.parseInt(datos[0]), datos[1], datos[4], datos[5], datos[6]);
                aerolineas.add(aerolinea);


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

    private void createDOMTree() throws TransformerConfigurationException {
        Element root = dom.createElement("aerolineas");
        dom.appendChild(root);

        Iterator it = aerolineas.iterator();
        while (it.hasNext()) {
            Aerolinea a = (Aerolinea) it.next();
            Element aerolineaEle = createAirlineElement(a);
            root.appendChild(aerolineaEle);
        }
    }


    private Element createAirlineElement(Aerolinea a){
        Element airlineEle = dom.createElement("aerolinea");
        airlineEle.setAttribute("id", Integer.toString(a.getId()));

        Element nombreEle = dom.createElement("nombre");
        Text nombreText = dom.createTextNode(a.getNombre());
        nombreEle.appendChild(nombreText);

        Element iataEle = dom.createElement("iata");
        Text iataText = dom.createTextNode(a.getIATA());
        iataEle.appendChild(iataText);

        Element codLlamadaEle = dom.createElement("codigoLlamada");
        Text codLlamadaText = dom.createTextNode(a.getCod());
        codLlamadaEle.appendChild(codLlamadaText);


        airlineEle.appendChild(nombreEle);
        airlineEle.appendChild(iataEle);
        airlineEle.appendChild(codLlamadaEle);

        return airlineEle;
    }

    private void printToFile() {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        try {
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
            DOMSource source = new DOMSource(dom);
            StreamResult result = new StreamResult(new File("aerolineas.xml"));
            transformer.transform(source, result);
            System.out.println("Archivo guardado");
        } catch (TransformerConfigurationException e) {
            System.out.println("error transformer exception");
        } catch (TransformerException e) {
        }


    }

    public void escribirXML() throws IOException {
        Iterator<Aerolinea> iterator = aerolineas.iterator();
        FileWriter write = new FileWriter("aerolineas.txt");
        PrintWriter print_line = new PrintWriter(write);
        print_line.println("<?xml version ='1.0' encoding='UTF-8'?>");
        print_line.print("<aerolineas>");


        while (iterator.hasNext()) {
            Aerolinea aerolinea = iterator.next();
            print_line.print("<aerolínea " + "id: " + aerolinea.getId() + ">" + "<nombre>" + aerolinea.getNombre()
                    + "</nombre>" + "<iata>" + aerolinea.getIATA() + "</iata>" + "<codigoLlamada>" + aerolinea.getCod() + "</aerolínea>");
        }
    }


}
