package org.example;

public abstract class Figura {
    protected String color;

    public Figura(String color) {
        this.color = color;
    }
    public abstract void dibujarFigura();
}
