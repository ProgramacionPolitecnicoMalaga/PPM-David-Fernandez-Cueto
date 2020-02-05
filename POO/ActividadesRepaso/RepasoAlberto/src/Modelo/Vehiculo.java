package Modelo;

import java.time.LocalDate;

public class Vehiculo {

    String modelo;
    String marca;
    String color;
    LocalDate anioFab;
    String combustion;
    String estado;
    double pvp;
    boolean vendido;

    public Vehiculo(String modelo, String marca, String color, LocalDate anioFab, String combustion, String estado, double pvp) {
        this.modelo = modelo;
        this.marca = marca;
        this.color = color;
        this.anioFab = anioFab;
        this.combustion = combustion;
        this.estado = estado;
        this.pvp = pvp;
        vendido = false;
    }

    public String getModelo() {
        return modelo;
    }

    public LocalDate getAnioFab() {
        return anioFab;
    }

    public double getPvp() {
        return pvp;
    }

    public boolean isVendido() {
        return vendido;
    }
}
