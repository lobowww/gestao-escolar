package com.gerirdominio.config;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface DAO<T> {

    public void inserir(T entity) throws SQLException;

    public void atualizar(T entity) throws SQLException;
    
    public void delete(T entity) throws SQLException;

    public Optional<T> buscarPorId(int id) throws SQLException;

    public List<T> buscarTodos() throws SQLException;
}
