package org.example;


public class Configurador {
    public static final Configurador INSTANCIA = new Configurador();

    private String configurador;

    public Configurador() {
    }

    public String getConfigurador() {
        return configurador;
    }

    public void setConfigurador(String configurador) {
        this.configurador = configurador;
    }
    public static Configurador obtenerInstancia(){
        return INSTANCIA;
    }
}
