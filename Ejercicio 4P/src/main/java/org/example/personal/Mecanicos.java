package org.example.personal;

import org.example.maquinaria.InyectableMecanico;

public class Mecanicos implements InyectableMecanico {
    private String nombreCompleto;
    private int telefono;
    private Especialidad especialidad;

    public Mecanicos(String nombreCompleto, int telefono, Especialidad especialidad) {
        this.nombreCompleto = nombreCompleto;
        this.telefono = telefono;
        this.especialidad = especialidad;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    @Override
    public String toString() {
        return "Mecanicos{" +
                "nombreCompleto='" + nombreCompleto + '\'' +
                ", telefono=" + telefono +
                ", especialidad=" + especialidad +
                '}';
    }
}

