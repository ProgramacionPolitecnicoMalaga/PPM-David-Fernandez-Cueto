import java.util.ArrayList;
import java.util.Calendar;
import java.util.Map;
import java.util.TreeMap;

public class Cafeteria {

    TreeMap<Integer, Mesa> mesas;
    TreeMap<String, Producto> carta;
    Caja caja;

    public Cafeteria() {
        mesas = new TreeMap<>();
        carta = new TreeMap<>();
        caja = new Caja();
    }

    public Producto getProductoDeCarta (String nombreProducto) {
        Producto producto = carta.get(nombreProducto);
        return producto;
    }

    public void addMesa(int numeroMesa) {
        mesas.put(numeroMesa, new Mesa(numeroMesa));
    }

    public void addProducto(String nombreProducto, double precio) {
        Producto producto = new Producto(nombreProducto, precio);
        carta.put(nombreProducto, producto);
    }

    public void addProductoAmesa(int numeromesa, String nombreProducto) {
        Mesa mesa = mesas.get(numeromesa);
        Producto producto = carta.get(nombreProducto);
        if (mesa != null && producto != null) {
            mesa.addProducto(producto);
        }
    }

    public ArrayList<Mesa> getMesasAbiertas() {
        ArrayList<Mesa> mesasAbiertas = new ArrayList<>();
        for (Map.Entry<Integer, Mesa> entry : mesas.entrySet()) {
            if (!entry.getValue().isCerrada()) {
                mesasAbiertas.add(entry.getValue());
            }
        }
        return mesasAbiertas;
    }

    public ArrayList<Mesa> getMesasCerradas() {
        ArrayList<Mesa> mesasCerradas = new ArrayList<>();
        for (Map.Entry<Integer, Mesa> entry : mesas.entrySet()) {
            if (entry.getValue().isCerrada()) {
                mesasCerradas.add(entry.getValue());
            }
        }
        return mesasCerradas;
    }

    public Cuenta getCuentaMesa(int numeroMesa) {
        Mesa mesa = mesas.get(numeroMesa);
        Cuenta cuenta = mesa.getCuenta();
        return cuenta;
    }

    public Cuenta cobrarMesa(int numeroMesa) {
        Mesa mesa = mesas.get(numeroMesa);
        Cuenta cuentaMesa = mesa.cobrarMesa();
        caja.addCuenta(cuentaMesa);
        return cuentaMesa;
    }

    public double getCaja() {
        return caja.getImporteCaja();
    }

    public double cerrarCaja() {
        double cajaTotal = caja.setCajaTotal();
        caja.resetCaja();
    return cajaTotal; }



    public TreeMap<Integer, Mesa> getMesas() {
        return mesas;
    }

   /* public double getCantidadTotal() {
        Caja caja = new Caja();
        for (Map.Entry<Integer, Mesa> entry : mesas.entrySet()) {
            caja.setCajaTotal(entry.getValue());
        }
    return caja.getImporteCaja(); } */

    public String mostrarProductosMesa(int numeroMesa) {
        Mesa mesa = mesas.get(numeroMesa);
        return mesa.mostrarProductos();
    }

    public Mesa getMesa (int numeroMesa) {
        Mesa mesa = mesas.get(numeroMesa);
        return mesa;
    }


}
