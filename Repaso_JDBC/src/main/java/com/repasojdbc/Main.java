package com.repasojdbc;

import com.repasojdbc.dao.ExcusaEntregaDAO;
import com.repasojdbc.dao.ExcusaEntregaDAOImpl;
import com.repasojdbc.modelo.ExcusaEntrega;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ExcusaEntregaDAO dao = new ExcusaEntregaDAOImpl();
        try {
            System.out.println("=== 1. CONSULTA BÁSICA (mayor a menor drama) ===");
            for (ExcusaEntrega e : dao.consultaBasica()) {
                System.out.printf("%s | %s | %d días | drama %d%n",
                        e.getAlumno(), e.getExcusa(), e.getDiasRetraso(), e.getNivelDrama());
            }

            imprimir("2. LIKE Y BETWEEN (perro/gato, 2-6 días)", dao.consultaLikeBetween());
            imprimir("3. IS NULL (sin entregar y poca credibilidad o mucho drama)", dao.consultaIsNull());
            imprimir("4. CONSULTA AVANZADA", dao.consultaAvanzada());

        } catch (SQLException ex) {
            System.err.println("Error de base de datos: " + ex.getMessage());
        }
    }

    private static void imprimir(String titulo, List<ExcusaEntrega> lista) {
        System.out.println("\n=== " + titulo + " === (" + lista.size() + " resultados)");
        lista.forEach(System.out::println);
    }
}