public class CriterioMejorPrecio implements SelectorDeMejorProducto {
    @Override
    public Producto elegirMejorProducto(LoteDeProductos lote) {

        Producto masBarato = null;
        double precio = Double.MAX_VALUE;
        for (int i = 0; i<lote.getTotalProductos(); i++){
            if (lote.getProductoEnPosicion(i).getPrecio() < precio) {
                masBarato = lote.getProductoEnPosicion(i);
                precio = masBarato.getPrecio();
            }
        }
        return masBarato;
    }
}
