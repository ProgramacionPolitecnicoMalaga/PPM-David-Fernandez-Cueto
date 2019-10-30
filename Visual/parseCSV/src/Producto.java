public class Producto {

    private String nombre;
    private String tipoProducto;
    private String cantidad;
    private String precio;

    public Producto(String nombre, String tipoProducto, String cantidad, String precio) {
        this.nombre = nombre;
        this.tipoProducto = tipoProducto;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }
}
