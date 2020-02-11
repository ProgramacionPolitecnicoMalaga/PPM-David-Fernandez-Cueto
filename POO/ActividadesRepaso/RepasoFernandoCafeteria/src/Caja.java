import java.util.ArrayList;
import java.util.Iterator;

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

    public double setCajaTotal () {
        Iterator<Cuenta> iterator = cuentas.iterator();
        while (iterator.hasNext()){
            Cuenta cuenta = iterator.next();
            cajaTotal = cajaTotal + cuenta.getImporteCuenta();
        }
   return cajaTotal; }

    public void resetCaja() {
        cajaTotal = 0;
    }

    public void addCuenta(Cuenta cuenta) {
        cuentas.add(cuenta);
    }

    public void addCuentas(Mesa mesa) {
        cuentas.add(mesa.getCuenta());
    }
}
