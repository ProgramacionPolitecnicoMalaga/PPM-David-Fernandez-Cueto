import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CarritoCompra {
    private JPanel panelMain;
    private JComboBox boxProductos;
    private JTextField txtUnidades;
    private JButton butAdd;
    private JTextArea txtaProductos;
    private JTextField txtTotalPrecio;

    public static String[] alimento = new String[100];
    public static Producto[] productos = new Producto[77];

    private double precioTotalCarrito = 0;
    private int indice = 0;


    public void leerCSV() {

        String fileName = "productos.csv";
        File file = new File(fileName);
        try {
            Scanner inputStream = new Scanner(file); // USAMOS EL SCANNER PARA LEER EL CONTENIDO DEL ARCHIVO
            while (inputStream.hasNext()){
                String data = inputStream.nextLine(); // OBTENEMOS LA LÍNEA ENTERA
                alimento = data.split(";");  // ALMACENAMOS EN UN ARRAY CADA ELEMENTO SEPARADO POR ";"
                //CREAMOS UN OBJETO DE LA CLASE PRODUCTO PARA CADA UNO DE ELLOS
                Producto producto = new Producto(alimento[1], alimento[2], alimento[3], Float.parseFloat(alimento[4]));
                productos [indice] = producto;
                //boxProductos.addItem(alimento[1]);
                indice++;


            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public String valorBoxCarrito() {
        String valor = (String)boxProductos.getSelectedItem();
        return valor;
    }

    public double preciosPorProductos(Producto producto) {
        Float precio = producto.getPrecio() * Float.parseFloat(txtUnidades.getText());
        return precio;
    }

    public void comprobarProducto() {
        for (int i = 0; i < productos.length; i++) {

            if (valorBoxCarrito().equals(productos[i].getNombre())) {
                txtaProductos.setText(txtaProductos.getText() + "\n" + "Ud: " + txtUnidades.getText() +
                        "                 " + "Prod: " + productos[i].getNombre() +
                        "                    "+ "PrecioUnidad: " + String.valueOf(productos[i].getPrecio()) +
                        "                " + "Total: " + preciosPorProductos(productos[i]));

               precioTotalCarrito = precioTotalCarrito + preciosPorProductos(productos[i]);
               txtTotalPrecio.setText(String.valueOf(precioTotalCarrito));
            }
        }
    }



    public CarritoCompra() {
        butAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                comprobarProducto();



            }
        });
    }

    public static void main (String[]args){
        JFrame frame = new JFrame("BuscadorAlimentos");
        frame.setContentPane(new CarritoCompra().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        CarritoCompra carrito = new CarritoCompra();
        carrito.leerCSV();


    }
}
