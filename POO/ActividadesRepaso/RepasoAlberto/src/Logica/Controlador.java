package Logica;

import Vista.Vista;

import java.time.LocalDate;

public class Controlador {

    private Vista vista;

    public void inicializarVista() {
        GestorOperaciones gestorOperaciones = new GestorOperaciones();
        vista = new Vista();
        int opcion;
        opcion = vista.mostarMenu();
        while (opcion != Vista.TERMINAR) {
            switch (opcion) {
                case Vista.INTRODUCIR_VEHICULO:
                    String modeloVehiculo = vista.pedirModeloVehiculo();
                    String marca = vista.pedirMarcaVehiculi();
                    String color = vista.pedirColorVehiculo();
                    LocalDate fechaFab = vista.pedirAnioFabricacion();
                    String combustion = vista.pedirCombustion();
                    String estado = vista.pedirEstadoVehiculo();
                    double pvp = vista.pedirPrecioVehiculo();
                    gestorOperaciones.addVehiculo(modeloVehiculo, marca, color, fechaFab, combustion, estado, pvp);
                    break;

                    case Vista.INTRODUCIR_CLIENTE:
                        String nombre = vista.pedirNombreCliente();
                        String apellidos = vista.pedirApellidosCliente();
                        String nif = vista.pedirDNI();
                        String cuentaBancaria = vista.pedirCuentaBancaria();
                        gestorOperaciones.addCliente(nombre, apellidos, nif, cuentaBancaria);
                        break;

                        case Vista.REALIZAR_COMPRA:
                            String modelo = vista.pedirModeloVehiculo();
                            String dni = vista.pedirDNI();
                            gestorOperaciones.comprarVehiculo(modelo, dni);
                            break;

                            case Vista.REALIZAR_VENTA:
                                String model = vista.pedirModeloVehiculo();
                                String nifVendedor = vista.pedirDNI();
                                gestorOperaciones.venderVehiculo(model, nifVendedor);
                                break;

                case Vista.SALDO_TOTAL:
                    String nifCliente = vista.pedirDNI();
                    System.out.println(gestorOperaciones.mostrarSaldoCliente(nifCliente));


            }
            opcion = vista.mostarMenu();
        }
    }
}
