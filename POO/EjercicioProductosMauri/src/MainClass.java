public class MainClass {

    public static void main(String[] args) {
        LoteDeProductos lote = new LoteDeProductos();
        lote.addProducto(new Producto("Producto 1" , 5.1, 4.5));
        lote.addProducto(new Producto("Producto 2", 6.2, 5));
        lote.addProducto(new Producto("Producto 3", 7.6, 2));
        lote.addProducto(new Producto("Producto 4", 2,5));

        lote.setSelectorDeMejorProducto(new CriterioMejorPrecio());

        System.out.println(lote.getSellersChoice());

        lote.getProductoEnPosicion(120);
        lote.addProducto(null);

    }
}
