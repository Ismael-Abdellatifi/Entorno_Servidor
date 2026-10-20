package com.repasojdbc.dao;

import com.repasojdbc.modelo.ExcusaEntrega;
import java.sql.SQLException;
import java.util.List;

public interface ExcusaEntregaDAO {
    List<ExcusaEntrega> consultaBasica() throws SQLException;
    List<ExcusaEntrega> consultaLikeBetween() throws SQLException;
    List<ExcusaEntrega> consultaIsNull() throws SQLException;
    List<ExcusaEntrega> consultaAvanzada() throws SQLException;
}