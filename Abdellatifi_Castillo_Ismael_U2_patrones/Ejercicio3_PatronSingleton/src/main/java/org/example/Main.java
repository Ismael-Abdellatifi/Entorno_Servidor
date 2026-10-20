package org.example;

public class Main {
    public static void main(String[] args) {
        Presidente p1 = Presidente.getInstancia("Pedro", "Sanchez", 2018);
        Presidente p2 = Presidente.getInstancia("Jose Luis ", "Rodriguez Zapatero", 2004);

        System.out.println(p1);
        System.out.println(p2);

        
    }
}