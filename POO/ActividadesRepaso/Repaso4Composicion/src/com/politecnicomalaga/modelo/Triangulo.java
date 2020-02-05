package com.politecnicomalaga.modelo;

public class Triangulo extends  Figura {
    private double base, altura;

    public Triangulo(String color) {
        super(color);
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }
}
