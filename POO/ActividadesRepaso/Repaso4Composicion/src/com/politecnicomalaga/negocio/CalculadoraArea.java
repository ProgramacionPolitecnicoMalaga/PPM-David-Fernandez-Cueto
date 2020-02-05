package com.politecnicomalaga.negocio;

import com.politecnicomalaga.modelo.Circulo;
import com.politecnicomalaga.modelo.Cuadradro;
import com.politecnicomalaga.modelo.Figura;
import com.politecnicomalaga.modelo.Triangulo;

import java.util.NoSuchElementException;

public class CalculadoraArea {

    public double calcular (Figura figura) {
        if (figura instanceof Circulo) {
            Circulo circulo = (Circulo) figura;
            return Math.pow(circulo.getRadio(), 2)*Math.PI;
        }
        else if (figura instanceof Triangulo) {
            Triangulo triangulo = (Triangulo) figura;
            return (triangulo.getBase()*triangulo.getAltura())/2;
        }
        else if (figura instanceof Cuadradro) {
            Cuadradro cuadrado = (Cuadradro) figura;
            return Math.pow(cuadrado.getLado(), 2);
        }
    else return 0;
    }
}
