public class ProductPositionException extends ArrayIndexOutOfBoundsException {
    int ultimaPosicion;

    public ProductPositionException(String message, int ultimaPosicion) {
        super(message);
        System.out.println(message + ". La longitud del array es de " + ultimaPosicion);
    }
}
