package org.example.maquinaria;

import org.example.personal.Mecanicos;

public class Locomotoras implements InyectableMecanico {
    private String matricula;
    private int potencia;
    private int anioFabricacion;
    private Mecanicos mecanicos;

    public Locomotoras(String matricula, int potencia, int anioFabricacion) {
        this.matricula = matricula;
        this.potencia = potencia;
        this.anioFabricacion = anioFabricacion;
    }

    @Override
    public void inyectarMecanico(Mecanicos mecanicos) {
        this.mecanicos = mecanicos;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    public int getAnioFabricacion() {
        return anioFabricacion;
    }

    public void setAnioFabricacion(int anioFabricacion) {
        this.anioFabricacion = anioFabricacion;
    }

    public Mecanicos getMecanicos() {
        return mecanicos;
    }

    public void setMecanicos(Mecanicos mecanicos) {
        this.mecanicos = mecanicos;
    }

    @Override
    public String toString() {
        return "Locomotoras{" +
                "matricula='" + matricula + '\'' +
                ", potencia=" + potencia +
                ", anioFabricacion=" + anioFabricacion +
                ", mecanicos=" + mecanicos +
                '}';
    }
}
