public class LoteDeProductos {
    private Producto [] lote;
    private final static int MAX_PRODUCTOS = 100;
    private int totalProductos;
    private SelectorDeMejorProducto selectorDeMejorProducto;

    public LoteDeProductos() {
        totalProductos = 0;
        lote = new Producto[MAX_PRODUCTOS];
        selectorDeMejorProducto = new CriterioMejorPrecio();
    }

    public void addProducto (Producto producto) throws NullProductException {
        if (producto == null) {
            throw new NullProductException("Se ha introducido un producto nulo");
        }

            if (totalProductos < MAX_PRODUCTOS) {
                lote[totalProductos] = producto;
                totalProductos++;
            }
    }

    public Producto getProductoEnPosicion(int i) throws ProductPositionException {
        if ((i >= 0) && (i <= totalProductos)) {
            return lote[i];
        }
        else new ProductPositionException("Esta posición no existe ", lote.length);
        return null;
    }

    public int getTotalProductos() {
        return totalProductos;
    }

    public SelectorDeMejorProducto getSelectorDeMejorProducto() {
        return selectorDeMejorProducto;
    }

    public void setSelectorDeMejorProducto(SelectorDeMejorProducto selectorDeMejorProducto) {
        this.selectorDeMejorProducto = selectorDeMejorProducto;
    }

    public Producto getSellersChoice() {
        if (selectorDeMejorProducto != null)
        return selectorDeMejorProducto.elegirMejorProducto(this);
        else
            return null;
    }

}
