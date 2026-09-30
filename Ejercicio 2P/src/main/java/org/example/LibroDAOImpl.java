package org.example;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class LibroDAOImpl implements LibroDAO {

    private final HashMap<Integer, Libro> libros = new LinkedHashMap<>();

    @Override
    public List<Libro> obtenerTodos() {
        return List.copyOf(libros.values());
    }

    @Override
    public Libro obtenerPorId(int id) {
        Libro libro = libros.get(id);
        if (libro == null){
            throw new LibroNoEncontradoException(id);
        }
        return libro;
    }

    @Override
    public void agregar(Libro libro) {
        if (libros.containsKey(libro.getId())){
            throw new IllegalArgumentException(" Ya existe u libro con esta ID " + libro.getId());
        }
        libros.put(libro.getId(), libro);
    }

    @Override
    public void actualizar(Libro libro) {
        obtenerPorId(libro.getId());
        libros.put(libro.getId(), libro);

    }

    @Override
    public void eliminar(int id) {
        obtenerPorId(id);
        libros.remove(id);

    }
}
