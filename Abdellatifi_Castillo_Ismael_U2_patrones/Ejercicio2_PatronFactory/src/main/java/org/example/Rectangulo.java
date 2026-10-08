package org.example;

public class Rectangulo extends Figura{
    public Rectangulo(String color) {
        super(color);

    }

    @Override
    public void dibujarFigura() {
        System.out.println("Dibujando Rectangulo de color " + color);

    }
}
