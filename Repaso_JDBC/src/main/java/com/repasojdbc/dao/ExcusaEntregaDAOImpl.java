package com.repasojdbc.dao;

import com.repasojdbc.conexion.ConexionBD;
import com.repasojdbc.modelo.ExcusaEntrega;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ExcusaEntregaDAOImpl implements ExcusaEntregaDAO {

    // 1. SELECT + ORDER BY
    private static final String SQL_BASICA =
            "SELECT * FROM excusa_entrega ORDER BY nivel_drama DESC";

    // 2. LIKE + BETWEEN + AND/OR con paréntesis
    private static final String SQL_LIKE_BETWEEN =
            "SELECT * FROM excusa_entrega " +
                    "WHERE (excusa LIKE '%perro%' OR excusa LIKE '%gato%') " +
                    "AND dias_retraso BETWEEN 2 AND 6 " +
                    "ORDER BY dias_retraso DESC";

    // 3. IS NULL (nunca "= NULL")
    private static final String SQL_IS_NULL =
            "SELECT * FROM excusa_entrega " +
                    "WHERE fecha_entrega IS NULL " +
                    "AND (credibilidad < 4 OR nivel_drama >= 9)";

    // 4. Avanzada: cada bloque AND va entre paréntesis y se unen con OR
    private static final String SQL_AVANZADA =
            "SELECT * FROM excusa_entrega " +
                    "WHERE (nivel_drama >= 8 AND credibilidad <= 3) " +
                    "OR (dias_retraso BETWEEN 2 AND 5 AND excusa LIKE '%perro%') " +
                    "ORDER BY nivel_drama DESC, dias_retraso DESC";

    @Override
    public List<ExcusaEntrega> consultaBasica() throws SQLException {
        return ejecutar(SQL_BASICA);
    }

    @Override
    public List<ExcusaEntrega> consultaLikeBetween() throws SQLException {
        return ejecutar(SQL_LIKE_BETWEEN);
    }

    @Override
    public List<ExcusaEntrega> consultaIsNull() throws SQLException {
        return ejecutar(SQL_IS_NULL);
    }

    @Override
    public List<ExcusaEntrega> consultaAvanzada() throws SQLException {
        return ejecutar(SQL_AVANZADA);
    }

    // Ejecuta una consulta y convierte cada fila en un objeto ExcusaEntrega
    private List<ExcusaEntrega> ejecutar(String sql) throws SQLException {
        List<ExcusaEntrega> lista = new ArrayList<>();
        try (Connection con = ConexionBD.getConexion();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                lista.add(mapear(rs));
            }
        }
        return lista;
    }

    // Convierte la fila actual del ResultSet en un objeto del modelo
    private ExcusaEntrega mapear(ResultSet rs) throws SQLException {
        Date fecha = rs.getDate("fecha_entrega");
        LocalDate fechaEntrega = (fecha == null) ? null : fecha.toLocalDate();
        return new ExcusaEntrega(
                rs.getInt("id"),
                rs.getString("alumno"),
                rs.getString("curso"),
                rs.getString("excusa"),
                rs.getInt("dias_retraso"),
                rs.getInt("credibilidad"),
                fechaEntrega,
                rs.getBoolean("aprobada_por_profesor"),
                rs.getInt("nivel_drama"));
    }
}