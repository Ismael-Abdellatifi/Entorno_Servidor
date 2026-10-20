package org.example.maquinaria;

import org.example.personal.Maquinistas;

import java.util.ArrayList;
import java.util.List;

public class Trenes  implements InyectablesLocomotora, InyectableMaquinistas{
    public static final int max_vagones = 5;
    private Locomotoras locomotoras;
    private Maquinistas maquinistas;
    private List<Vagones> vagones = new ArrayList<>();

    public Trenes(Locomotoras locomotoras, Maquinistas maquinistas, List<Vagones> vagones) {
        this.locomotoras = locomotoras;
        this.maquinistas = maquinistas;
        this.vagones = vagones;
    }

    @Override
    public void inyectarMaquinistas(Maquinistas maquinistas) {

    }

    @Override
    public void inyectarLocomotora(Locomotoras locomotoras) {

    }
    public boolean anadirVagon(double capacidadMaxima,double capacidadActual, String tipoMercancia) {
        if (vagones.size() >= max_vagones) return false;
        vagones.add(new Vagones(capacidadMaxima, capacidadActual, tipoMercancia));
        return true;
    }

    public boolean cargarVagon(int indice, double kilos) {
        if (indice < 0 || indice >= vagones.size()) return false;
        return vagones.get(indice).cargar(kilos);
    }
}
