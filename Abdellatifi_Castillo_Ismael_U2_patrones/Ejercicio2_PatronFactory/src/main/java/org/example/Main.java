package org.example;

import org.example.Figura;
import org.example.FiguraFactory;

public class Main {
    public static void main(String[] args) {
        Figura triangulo  = FiguraFactory.crearFigura("Triangulo", "rojo");
        Figura rectangulo = FiguraFactory.crearFigura("Rectangulo", "azul");
        Figura circulo    = FiguraFactory.crearFigura("Circulo", "verde");
        Figura cuadrado   = FiguraFactory.crearFigura("Cuadrado", "amarillo");

        triangulo.dibujarFigura();
        rectangulo.dibujarFigura();
        circulo.dibujarFigura();
        cuadrado.dibujarFigura();
    }
}