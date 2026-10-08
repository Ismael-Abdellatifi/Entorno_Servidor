package org.example;

import org.example.Casa;
import org.example.Pared;
import org.example.Tejado;
import org.example.TejadoTejas;

public class Main {
    public static void main(String[] args) {
        // Casa 1: tejado de tejas y paredes con la altura por defecto (2.5)
        Casa casa1 = new Casa(80.0, new TejadoTejas(),
                new Pared(), new Pared(), new Pared(), new Pared());

        // Casa 2: tejado genérico y paredes con alturas distintas
        Casa casa2 = new Casa(120.5, new Tejado(),
                new Pared(3.0), new Pared(3.0), new Pared(2.8), new Pared(2.8));

        casa1.mostrar();
        System.out.println(".......");
        casa2.mostrar();
    }
}