package com.politecnicomalaga.modelo;

public class Cuadradro extends Figura {
    private double lado;

    public Cuadradro(String color) {
        super(color);
    }

    public double getLado() {
        return lado;
    }

    public void setLado(double lado) {
        this.lado = lado;
    }
}
