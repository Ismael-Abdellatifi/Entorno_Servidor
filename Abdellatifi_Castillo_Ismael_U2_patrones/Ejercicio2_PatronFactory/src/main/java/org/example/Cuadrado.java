package org.example;

public class Cuadrado extends Figura {
    public Cuadrado(String color) {
        super(color);
    }

    @Override
    public void dibujarFigura() {
        System.out.println("Dibujando Cuadrado de color " + color);

    }
}
