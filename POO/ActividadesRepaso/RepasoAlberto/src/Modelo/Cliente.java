package Modelo;

import java.util.ArrayList;

public class Cliente {

    String nombre;
    String Apellidos;
    String nif;
    String cuentaBancaria;
    double saldo;
    ArrayList<Vehiculo> vehiculosDelCliente;

    public Cliente(String nombre, String apellidos, String nif, String cuentaBancaria) {
        this.nombre = nombre;
        Apellidos = apellidos;
        this.nif = nif;
        this.cuentaBancaria = cuentaBancaria;
        saldo = 6000;
        vehiculosDelCliente = new ArrayList<>();
    }

    public String getNif() {
        return nif;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public ArrayList<Vehiculo> getVehiculosDelCliente() {
        return vehiculosDelCliente;
    }
}
