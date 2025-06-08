package com.gerirdominio.config.funcionalidadesDAO;

import com.gerirdominio.config.DAO;
import com.gerirdominio.model.funcionalidades.Grade;
import com.gerirdominio.util.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GradeDAO implements DAO<Grade> {

    @Override
    public void inserir(Grade grade) throws SQLException {
        String sql = "INSERT INTO grades DEFAULT VALUES";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.executeUpdate();
            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    grade.setId(rs.getInt(1));
                }
            }
        }
    }

    @Override
    public void delete(Grade grade) throws SQLException {
        String sql = "DELETE FROM grades WHERE id = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, grade.getId());
            stmt.executeUpdate();
        }
    }

    @Override
    public Optional<Grade> buscarPorId(int id) throws SQLException {
        String sql = "SELECT id FROM grades WHERE id = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return Optional.of(new Grade(rs.getInt("id")));
                }
            }
        }
        return Optional.empty();
    }

    @Override
    public List<Grade> buscarTodos() throws SQLException {
        List<Grade> grades = new ArrayList<>();
        String sql = "SELECT id FROM grades ORDER BY id";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                grades.add(new Grade(rs.getInt("id")));
            }
        }
        return grades;
    }

    @Override
    public void atualizar(Grade grade) throws SQLException {
    }
}
