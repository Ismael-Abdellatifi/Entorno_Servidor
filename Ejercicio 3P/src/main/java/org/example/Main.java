package org.example;

import org.example.AndaluciaFactory;
import org.example.ElementoAndaluz;
import org.example.ElementoAndaluzFactory;

public class Main {
    public static void main(String[] args) {
        ElementoAndaluzFactory factory = new AndaluciaFactory();

        ElementoAndaluz flamenco = factory.createElementoAndaluz("flamenco");
        ElementoAndaluz gazpacho = factory.createElementoAndaluz("gazpacho");
        ElementoAndaluz feria = factory.createElementoAndaluz("feria");

        flamenco.describir();
        gazpacho.describir();
        feria.describir();


        try {
            factory.createElementoAndaluz("paella");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}