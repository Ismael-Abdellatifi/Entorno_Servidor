package org.example.personal;

import org.example.maquinaria.InyectableMaquinistas;

public class Maquinistas implements InyectableMaquinistas {
    private String nombreCompleto;
    private String dni;
    private double sueldoMensual;
    private String rango;

    public Maquinistas(String nombreCompleto, String dni, double sueldoMensual, String rango) {
        this.nombreCompleto = nombreCompleto;
        this.dni = dni;
        this.sueldoMensual = sueldoMensual;
        this.rango = rango;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public double getSueldoMensual() {
        return sueldoMensual;
    }

    public void setSueldoMensual(double sueldoMensual) {
        this.sueldoMensual = sueldoMensual;
    }

    public String getRango() {
        return rango;
    }

    public void setRango(String rango) {
        this.rango = rango;
    }

    @Override
    public String toString() {
        return "Maquinistas{" +
                "nombreCompleto='" + nombreCompleto + '\'' +
                ", dni='" + dni + '\'' +
                ", sueldoMensual=" + sueldoMensual +
                ", rango='" + rango + '\'' +
                '}';
    }

    @Override
    public void inyectarMaquinistas(Maquinistas maquinistas) {

    }
}
