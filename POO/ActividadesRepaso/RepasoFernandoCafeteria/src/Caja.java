import java.util.ArrayList;
import java.util.TreeMap;

public class Caja {

    ArrayList<Cuenta> cuentas;
    double cajaTotal;

    public Caja() {
        cuentas = new ArrayList<>();
        cajaTotal = 0;
    }

    public double getImporteCaja() {
        return cajaTotal;
    }

    public void setCajaTotal (Mesa mesa) {
        cajaTotal = cajaTotal + mesa.getCuenta().getImporteTotal();
    }

    public void resetCaja() {
        cajaTotal = 0;
    }

    public void addCuentas(Mesa mesa) {
        cuentas.add(mesa.getCuenta());
    }
}
