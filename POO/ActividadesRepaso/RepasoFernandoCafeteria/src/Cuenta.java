public class Cuenta {

    Mesa mesa;
    double importeTotal;

    public Cuenta (Mesa mesa) {
        this.mesa = mesa;
    }

    public double getImporteTotal() {
        return importeTotal;
    }

    public void setImporteTotal(double importeTotal) {
        this.importeTotal = importeTotal;
    }



    @Override
    public String toString() {
        return "Cuenta{" +
                "mesa=" + mesa +
                ", importeTotal=" + importeTotal +
                '}';
    }


}
