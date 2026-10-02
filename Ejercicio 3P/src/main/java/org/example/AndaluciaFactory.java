package org.example;

import java.util.Locale;

public class AndaluciaFactory extends ElementoAndaluzFactory {
    @Override
    public ElementoAndaluz createElementoAndaluz(String tipo) {
        if (tipo == null) {
            throw new IllegalArgumentException("El tipo no puede ser null");
        }
        switch (tipo.trim().toLowerCase()) {
            case "flamenco":
                return new Flamenco();
            case "gazpacho":
                return new Gazpacho();
            case "feria":
            return new FeriaDeAbril();
            default:
                System.out.println("No se encontro ningun elemento");
                return null;

        }
    }
}
