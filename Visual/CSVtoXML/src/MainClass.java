import javax.xml.transform.TransformerConfigurationException;
import java.io.IOException;

public class MainClass {

    public static void main(String[] args) throws IOException, TransformerConfigurationException {

        LectorCSVaeropuertos lectorAeropuertos = new LectorCSVaeropuertos();
        LectorCSVaerolineas lectorAerolineas = new LectorCSVaerolineas();

        lectorAeropuertos.run();
        lectorAerolineas.run();


        }
    }

