package com.politecnicomalaga.presentacion;

import com.politecnicomalaga.modelo.Circulo;
import com.politecnicomalaga.modelo.Cuadradro;
import com.politecnicomalaga.modelo.Figura;
import com.politecnicomalaga.modelo.Triangulo;
import com.politecnicomalaga.negocio.CalculadoraArea;

public class Figuras {

    static Figura[] figuras;

    public static void main(String[] args) {
        figuras = new Figura[3];

        Figura circulo = new Circulo("rojo");
        ((Circulo) circulo).setRadio(5);

        Figura triangulo = new Triangulo("amarillo");
        ((Triangulo) triangulo).setBase(5);
        ((Triangulo) triangulo).setAltura(10);

        Figura cuadrado = new Cuadradro("verde");
        ((Cuadradro) cuadrado).setLado(4);

        figuras[0] = circulo;
        figuras[1] = triangulo;
        figuras[2] = cuadrado;


        CalculadoraArea calculadora = new CalculadoraArea();
        for (int i = 0; i < figuras.length; i++) {
            System.out.println(calculadora.calcular(figuras[i]));
        }

    }
}
