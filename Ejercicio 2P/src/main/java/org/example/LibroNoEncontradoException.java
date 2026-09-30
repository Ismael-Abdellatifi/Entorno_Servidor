package org.example;

public class LibroNoEncontradoException extends RuntimeException {
    public LibroNoEncontradoException(int id ){
        super("No existe una tarea con ID" + id);
    }
}
