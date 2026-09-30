package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

           LibroDAO libros = new LibroDAOImpl();
           libros.agregar(new Libro(1 ," Cien años de soledad ", " por Gabriel Garcia Marquez ", 1969));
           libros.agregar(new Libro(2 ," Don Quijote de la Mancha ", " por Miguel de Cervantes ", 1605));
            System.out.println("Libros guardados: ");
            for (Libro libro : libros.obtenerTodos()){
                System.out.println("- " + libro);
            }
            try {
                libros.obtenerPorId(99);
            }catch (LibroNoEncontradoException exception){
                System.out.println("Busqueda: " + exception.getMessage());
            }

    }
}