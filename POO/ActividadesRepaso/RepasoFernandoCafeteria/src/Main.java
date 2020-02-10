import java.util.ArrayList;

public class Main {

    private static Cafeteria cafeteria = new Cafeteria();

    public static void main(String[] args) {


        init();

        //AÑADIR UN PRODUCTO A LA MESA
        cafeteria.addProductoAmesa(1, "Colacao");
        cafeteria.addProductoAmesa(2, "Mixto");
        cafeteria.addProductoAmesa(2, "Pinta");
        cafeteria.addProductoAmesa(2, "Pinta");


        //CONSULTAR LAS MESAS ABIERTAS
        ArrayList<Mesa> mesasAbiertas = cafeteria.getMesasAbiertas();
        System.out.println(mesasAbiertas);

        //CONSULTAR MESAS CERRADAS
        ArrayList<Mesa> mesasCerradas = cafeteria.getMesasCerradas();
        System.out.println(mesasCerradas);

        //OBTENER CUENTA DE UNA MESA CONCRETA
        System.out.println(cafeteria.getCuentaMesa(2));

        //CONSULTAR RECUENTO DE CAJA ACTUAL
        /*double recuentoCaja = cafeteria.getCajaTotal();
        System.out.println(recuentoCaja); */

        //System.out.println(cafeteria.getCaja());
        cafeteria.cobrarMesa(2);
        System.out.println(cafeteria.getCaja());


        //CANTIDAD TOTAL A PESAR DE NO HABER SIDO COBRADO.
        System.out.println(cafeteria.getCantidadTotal());

        /*

        //AÑADIR PRODUCTOS A LA LISTA DE PRODUCTOS (CREAR NUEVO PRODUCTO)
        cafeteria.addProducto(String nombreProducto, double precio);



         //CERRAR MESA
        cafeteria.cerrarMesa(int numeroMesa);
        */


    }

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
}
