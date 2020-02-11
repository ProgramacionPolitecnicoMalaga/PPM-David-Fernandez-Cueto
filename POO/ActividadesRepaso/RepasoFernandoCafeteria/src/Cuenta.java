public class Cuenta {

    Mesa mesa;
    double importeCuenta;

    public Cuenta (Mesa mesa) {
        this.mesa = mesa;
    }

    public double getImporteCuenta() {
        return importeCuenta;
    }

    public void setImporteCuenta(double importeCuenta) {
        this.importeCuenta = importeCuenta;
    }



    @Override
    public String toString() {
        return "Cuenta{" +
                "mesa=" + mesa +
                ", importeTotal=" + importeCuenta +
                '}';
    }


}
