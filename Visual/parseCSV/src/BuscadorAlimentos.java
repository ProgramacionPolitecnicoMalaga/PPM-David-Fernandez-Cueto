import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BuscadorAlimentos {
    private JTextField txtBuscador;
    private JButton butBuscar;
    private JTextArea txtResultados;
    private JPanel panelMain;


    private static String [] alimento = new String[100];
    private static Producto [] productos = new Producto[100];

    public static void leerCSV() {

        String fileName = "productos.csv";
        File file = new File(fileName);
        int indice = 0;
        try {
            Scanner inputStream = new Scanner(file); // USAMOS EL SCANNER PARA LEER EL CONTENIDO DEL ARCHIVO
            while (inputStream.hasNext()){
                String data = inputStream.nextLine(); // OBTENEMOS LA LÍNEA ENTERA
                alimento = data.split(";");  // ALMACENAMOS EN UN ARRAY CADA ELEMENTO SEPARADO POR ";"
                //CREAMOS UN OBJETO DE LA CLASE PRODUCTO PARA CADA UNO DE ELLOS
                Producto producto = new Producto(alimento[1], alimento[2], alimento[3], alimento[4]);
                productos [indice] = producto;
                System.out.println(producto);
                indice++;


            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public BuscadorAlimentos() {

        butBuscar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                txtResultados.setEditable(false); //Impedimos modificiar el textArea tras mostrar resultados.
                String cadenaABuscar = txtBuscador.getText();
                String resultados = "";
                for (int i = 0; i < productos.length; i++) {
                    String [] palabrasSeparadas = productos[i].getNombre().split(" "); // CON ESTO, MI INTENCIÓN ERA BUSCAR REALMENTE LA PALABRA, Y NO LAS LETRAS EN SÍ.
                    for (int f = 0; f < palabrasSeparadas.length; f++) {
                        if (cadenaABuscar.equalsIgnoreCase(palabrasSeparadas[f])){
                            resultados = resultados + productos[i].getNombre() + "\n";

                        }

                    }
                    txtResultados.setText(resultados);
                }
            }
        });
    }

    public static void main (String[]args){
        JFrame frame = new JFrame("BuscadorAlimentos");
        frame.setContentPane(new BuscadorAlimentos().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        leerCSV(); //NOS ASEGURAMOS DE QUE SE EJECUTE EL MÉTODO PARA LEER EL CSV AL INICIAR EL PROGRAMA.



    }
}
