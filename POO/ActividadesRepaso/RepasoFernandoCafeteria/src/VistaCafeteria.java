import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VistaCafeteria {
    private JTextArea txtProductos;
    private JButton butMesa11;
    private JButton butMesa9;
    private JButton butMesa7;
    private JButton butMesa3;
    private JButton butMesa1;
    private JButton butMesa2;
    private JButton butMesa4;
    private JButton butMesa6;
    private JButton butMesa8;
    private JButton butMesa10;
    private JButton butMesa12;
    private JButton butMesa5;
    private JPanel panelMain;
    private JButton butCobrar;
    private JComboBox comboProductos;
    private JButton butAnotar;
    private JTextField txtImporte;
    private JButton cerrarCajaButton;
    private JTextField txtCaja;

    private static Cafeteria cafeteria = new Cafeteria();

    private static void init() {
        for (int f = 0; f < 17; f++) {
            cafeteria.addMesa(f);
        }
        String[] nombresProducto = {"Caña", "Pinta", "Carajillo", "Mixto", "Catalana", "Colacao"};
        double[] preciosProducto = {1, 3, 1.20, 1.50, 1.20, 1.20};

        for (int i = 0; i < nombresProducto.length; i++) {
            cafeteria.addProducto(nombresProducto[i], preciosProducto[i]);
        }
    }

    public void fillProductos() {
        String[] nombresProducto = {"Caña", "Pinta", "Carajillo", "Mixto", "Catalana", "Colacao"};
        for (int i = 0; i < nombresProducto.length; i++) {
            comboProductos.addItem(nombresProducto[i]);
        }
    }


    Mesa mesa;
    //ArrayList<Producto> productos;

    public void imprimirTxtProductos(int numeromesa) {
        mesa = cafeteria.getMesa(numeromesa);
        //productos = mesa.getProductos();
        txtProductos.setText("");
        txtImporte.setText("");
        String productos = cafeteria.mostrarProductosMesa(numeromesa);
        txtProductos.append(productos);
        txtImporte.setText(Double.toString(cafeteria.getCuentaMesa(numeromesa).getImporteCuenta()));
    }


    public VistaCafeteria() {


        butMesa1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                comboProductos.removeAllItems();
               imprimirTxtProductos(1);
               fillProductos();

            }
        });
        butMesa2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                comboProductos.removeAllItems();
                imprimirTxtProductos(2);
                fillProductos();

            }
        });
        butMesa3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                comboProductos.removeAllItems();
                imprimirTxtProductos(3);
                fillProductos();

            }
        });
        butMesa4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                comboProductos.removeAllItems();
                imprimirTxtProductos(4);
                fillProductos();

            }
        });

        butCobrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                double importe = mesa.getCuenta().getImporteCuenta();
                cafeteria.cobrarMesa(mesa.getNumeroMesa());
                txtProductos.setText("Importe cobrado de mesa " + mesa.getNumeroMesa() + "\n" + "Total: " + importe);
            }
        });

        butAnotar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String productoSeleccionado = comboProductos.getSelectedItem().toString();
                Producto producto = cafeteria.getProductoDeCarta(productoSeleccionado);
                mesa.addProducto(producto);
                imprimirTxtProductos(mesa.getNumeroMesa());
            }
        });
        cerrarCajaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                double cajaTotal = cafeteria.cerrarCaja();
                txtCaja.setText("Caja total: "+ String.valueOf(cajaTotal));
            }
        });
    }

    public static void main (String[]args) {
        JFrame frame = new JFrame("VistaCafeteria");
        frame.setContentPane(new VistaCafeteria().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        init();
        cafeteria.addProductoAmesa(1, "Colacao");
        cafeteria.addProductoAmesa(2, "Mixto");
        cafeteria.addProductoAmesa(2, "Pinta");
        cafeteria.addProductoAmesa(2, "Pinta");
        //System.out.println(cafeteria.getCaja());
    }
}
