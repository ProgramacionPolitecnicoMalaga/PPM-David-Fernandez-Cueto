import java.util.ArrayList;
import java.util.Iterator;

public class Mesa {

    int numeroMesa;
    private boolean cerrada;
    ArrayList<Producto> productos;
    Cuenta cuenta;

    public Mesa (int numeroMesa) {
        this.numeroMesa = numeroMesa;
        productos = new ArrayList<>();
        cuenta = new Cuenta(this);
        cerrada = true;
    }

    public void addProducto (Producto producto) {
        productos.add(producto);
        cuenta.setImporteTotal(cuenta.getImporteTotal() + producto.getPrecio());
        cerrada = false;
    }




    public Cuenta cobrarMesa () {
        Iterator<Producto> iterator = productos.iterator();
        cuenta.setImporteTotal(0);
        Producto producto;

        while (iterator.hasNext()) {
            producto = iterator.next();
            cuenta.setImporteTotal(cuenta.getImporteTotal() + producto.getPrecio());
            //productos.remove(producto);
        }
        productos.removeAll(productos);
        cerrada = true;

    return cuenta; }

    public int getNumeroMesa() {
        return numeroMesa;
    }

    public boolean isCerrada() {
        return cerrada;
    }

    public ArrayList<Producto> getProductos() {

        return productos;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    @Override
    public String toString() {
        return "Mesa{" +
                "numeroMesa=" + numeroMesa +
                '}';
    }
}
