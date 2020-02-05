package Logica;

import Modelo.Cliente;
import Modelo.Vehiculo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Currency;
import java.util.Iterator;

public class GestorOperaciones {

    public ArrayList<Cliente> listaClientes;
    public ArrayList<Vehiculo> listaVehiculos;

    public GestorOperaciones () {
        listaClientes = new ArrayList<>();
        listaVehiculos = new ArrayList<>();
    }

    public void addCliente (String nombre, String apellidos, String NIF, String cuentaBancaria) {
        listaClientes.add(new Cliente(nombre, apellidos, NIF, cuentaBancaria));
    }

    public void addVehiculo (String modelo, String marca, String color, LocalDate anioFab, String combustion, String estado, double pvp) {
        listaVehiculos.add(new Vehiculo(modelo, marca, color, anioFab, combustion, estado, pvp));
    }

    public void venderVehiculo (String  modeloVehiculo, String nifCliente) {
        Vehiculo vehiculoBuscado = null;
        Cliente clienteBuscado = null;
        Iterator<Cliente> iteratorCliente = listaClientes.iterator();
        Iterator<Vehiculo> iteratorVehiculo = listaVehiculos.iterator();

        while (iteratorCliente.hasNext()) {
            Cliente cliente = iteratorCliente.next();
            if (cliente.getNif().equals(nifCliente)) {
                clienteBuscado = cliente;
            }
        }

        while (iteratorVehiculo.hasNext()) {
            Vehiculo vehiculo = iteratorVehiculo.next();
            if (vehiculo.getModelo().equals(modeloVehiculo)) {
                vehiculoBuscado = vehiculo;
            }
        }

        clienteBuscado.getVehiculosDelCliente().add(vehiculoBuscado);
        double precioDelVehiculo = vehiculoBuscado.getPvp();
        clienteBuscado.setSaldo(clienteBuscado.getSaldo()-precioDelVehiculo);

    }

    public void comprarVehiculo (String modeloVehiculo, String nifCliente) {
        Vehiculo vehiculoBuscado = null;
        Cliente clienteBuscado = null;
        Iterator<Cliente> iteratorCliente = listaClientes.iterator();
        Iterator<Vehiculo> iteratorVehiculo = listaVehiculos.iterator();

        while (iteratorCliente.hasNext()) {
            Cliente cliente = iteratorCliente.next();
            if (cliente.getNif().equals(nifCliente)) {
                clienteBuscado = cliente;
            }
        }

        while (iteratorVehiculo.hasNext()) {
            Vehiculo vehiculo = iteratorVehiculo.next();
            if (vehiculo.getModelo().equals(modeloVehiculo)) {
                vehiculoBuscado = vehiculo;
            }
        }

        clienteBuscado.getVehiculosDelCliente().remove(vehiculoBuscado);
        double precioDelVehiculo = vehiculoBuscado.getPvp();
        clienteBuscado.setSaldo(clienteBuscado.getSaldo()+precioDelVehiculo);
    }

    public double mostrarSaldoCliente (String DNI) {
        Iterator<Cliente> iteratorCliente = listaClientes.iterator();
        Cliente clienteBuscado = null;

        while (iteratorCliente.hasNext()) {
            Cliente cliente = iteratorCliente.next();
            if (cliente.getNif().equals(DNI)) {
                clienteBuscado = cliente;
            }
        }
        return clienteBuscado.getSaldo();
    }
}
