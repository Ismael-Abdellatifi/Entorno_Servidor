package org.example.maquinaria;

public class Vagones {
    private double maximaCarga;
    private double capacidadActual;
    private String tipoMercancia;

    public Vagones(double maximaCarga, double capacidadActual, String tipoMercancia) {
        this.maximaCarga = maximaCarga;
        this.capacidadActual = 0;
        this.tipoMercancia = tipoMercancia;
    }
    boolean cargar(double kilos) {
        if (kilos < 0 || capacidadActual + kilos > maximaCarga)
            return false;
        capacidadActual += kilos;
        return true;
    }

    public double getMaximaCarga() {
        return maximaCarga;
    }

    public void setMaximaCarga(double maximaCarga) {
        this.maximaCarga = maximaCarga;
    }

    public double getCapacidadActual() {
        return capacidadActual;
    }

    public void setCapacidadActual(double capacidadActual) {
        this.capacidadActual = capacidadActual;
    }

    public String getTipoMercancia() {
        return tipoMercancia;
    }

    public void setTipoMercancia(String tipoMercancia) {
        this.tipoMercancia = tipoMercancia;
    }

    @Override
    public String toString() {
        return "Vagones{" +
                "maximaCarga=" + maximaCarga +
                ", capacidadActual=" + capacidadActual +
                ", tipoMercancia='" + tipoMercancia + '\'' +
                '}';
    }
}
