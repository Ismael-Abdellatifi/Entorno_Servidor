package org.example.personal;

public class Jefe_Estacion {
    private String nombreCompleto;
    private String dni;

    public Jefe_Estacion(String nombreCompleto, String dni) {
        this.nombreCompleto = nombreCompleto;
        this.dni = dni;
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

    @Override
    public String toString() {
        return "Jefe_Estacion{" +
                "nombreCompleto='" + nombreCompleto + '\'' +
                ", dni='" + dni + '\'' +
                '}';
    }
}
