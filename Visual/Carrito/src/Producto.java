public class Producto {

    private String nombre;
    private String tipoProducto;
    private String cantidad;
    private float precio;

    public Producto(String nombre, String tipoProducto, String cantidad, float precio) {
        this.nombre = nombre;
        this.tipoProducto = tipoProducto;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipoProducto() {
        return tipoProducto;
    }

    public String getCantidad() {
        return cantidad;
    }

    public float getPrecio() {
        return precio;
    }

}
