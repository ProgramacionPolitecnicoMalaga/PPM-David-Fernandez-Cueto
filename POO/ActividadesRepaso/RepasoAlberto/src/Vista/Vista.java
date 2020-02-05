package Vista;

import Modelo.Vehiculo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Scanner;

public class Vista {

    public final static int INTRODUCIR_VEHICULO = 1;
    public final static int INTRODUCIR_CLIENTE = 2;
    public final static int REALIZAR_VENTA = 3;
    public final static int REALIZAR_COMPRA = 4;
    public final static int SALDO_TOTAL = 5;
    public final static int TERMINAR = 0;

    private Scanner teclado;

    public Vista() {
        teclado = new Scanner(System.in).useDelimiter("\n");
    }

    public int mostarMenu() {
        System.out.println("Opciones:\n" +
                "1. Introducir un nuevo vehículo \n" +
                "2. Introducir un nuevo cliente \n" +
                "3. Realizar venta a un cliente \n" +
                "4. Realizar compra a un cliente.\n" +
                "5. Obtener saldo total de un cliente. \n" +
                "0. Salir.\n" +
                "Opción: ");
        return teclado.nextInt();
    }

    public String pedirModeloVehiculo() {
        System.out.println("Modelo del vehículo:");
        return teclado.next();
    }

    public String pedirMarcaVehiculi() {
        System.out.println("Marca del vehículo:");
        return teclado.next();
    }

    public String pedirColorVehiculo() {
        System.out.println("Color del vehículo:");
        return teclado.next();
    }

    public LocalDate pedirAnioFabricacion() {
        System.out.println("Año de fabricación (dd/mm/yyyy):");
        String txtFecha = teclado.next();
        DateTimeFormatter format = DateTimeFormatter.ISO_LOCAL_DATE;
        LocalDate fecha = LocalDate.parse(txtFecha, format);
        return fecha;

    }

    public String pedirCombustion() {
        System.out.println("Tipo de combustión del vehículo:");
        return teclado.next();
    }

    public String pedirEstadoVehiculo() {
        System.out.println("Estado del vehículo:");
        return teclado.next();
    }

    public double pedirPrecioVehiculo() {
        System.out.println("Precio del vehículo:");
        return teclado.nextDouble();
    }


    public String pedirNombreCliente() {
        System.out.println("Nombre:");
        return teclado.next();
    }

    public String pedirApellidosCliente() {
        System.out.println("Apellidos:");
        return teclado.next();
    }

    public String pedirDNI() {
        System.out.println("DNI del cliente:");
        return teclado.next();
    }

    public String pedirCuentaBancaria() {
        System.out.println("Número de cuenta:");
        return teclado.next();
    }
}
