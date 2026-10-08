package org.example;

public class Casa {
    private final double area;
    private final Tejado tejado;
    private final Pared pared1;
    private final Pared pared2;
    private final Pared pared3;
    private final Pared pared4;

    public Casa(double area, Tejado tejado, Pared pared1, Pared pared2, Pared pared3, Pared pared4) {
        this.area = area;
        this.tejado = tejado;
        this.pared1 = pared1;
        this.pared2 = pared2;
        this.pared3 = pared3;
        this.pared4 = pared4;
    }
    public void mostrar(){
        System.out.println("Casa de "+ area + " m2");
        tejado.darSoporte();
        System.out.println("Paredes con alturas: " + pared1.getAltura() + ", " + pared2.getAltura() + ", " + pared3.getAltura() + ", " + pared4.getAltura());
    }
}
