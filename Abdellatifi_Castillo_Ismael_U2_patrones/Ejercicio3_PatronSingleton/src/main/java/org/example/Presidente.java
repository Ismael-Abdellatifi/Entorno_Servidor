package org.example;

public class Presidente {
    private static Presidente instancia;
    private final String nombre;
    private final String apellidos;
    private final int anioEleccion;

    public Presidente(String nombre, String apellidos, int anioEleccion) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.anioEleccion = anioEleccion;
    }

    public static Presidente getInstancia(String nombre, String apellidos, int anioEleccion) {
        if (instancia == null){
            instancia =  new Presidente(nombre, apellidos, anioEleccion);
        }
        return instancia;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public int getAnioEleccion() {
        return anioEleccion;
    }

    @Override
    public String toString() {
        return "Presidente " +
                "Nombre: " + nombre +
                " Apellidos: " + apellidos  +
                " Año Eleccion: " + anioEleccion;
    }
}
