package com.gerirdominio.config.funcionalidadesDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.gerirdominio.config.DAO;
import com.gerirdominio.model.funcionalidades.Disciplina;
import com.gerirdominio.util.ConnectionFactory;

public class DisciplinaDAO implements DAO<Disciplina> {

    @Override
    public void inserir(Disciplina disciplina) throws SQLException {
        String sql = "INSERT INTO disciplinas (nome) VALUES (?)";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            
            stmt.setString(1, disciplina.getNome());
            stmt.executeUpdate();
            
            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    disciplina.setId(rs.getInt(1));
                }
            }
        }
    }

    @Override
    public void atualizar(Disciplina disciplina) throws SQLException {
        String sql = "UPDATE disciplinas SET nome = ? WHERE id = ?";
        try (Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, disciplina.getNome());
            stmt.setInt(2, disciplina.getId());
            stmt.executeUpdate();
        }
        throw new UnsupportedOperationException("É necessário um ID na classe Disciplina para atualizar.");
    }

    @Override
    public void delete(Disciplina disciplina) throws SQLException {
        String sql = "DELETE FROM disciplinas WHERE id = ?";
        try (Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, disciplina.getId()); // Supondo que getId() existe
            stmt.executeUpdate();
        }
        throw new UnsupportedOperationException("É necessário um ID na classe Disciplina para deletar.");
    }

    @Override
    public Optional<Disciplina> buscarPorId(int id) throws SQLException {
        String sql = "SELECT * FROM disciplinas WHERE id = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return Optional.of(mapear(rs));
                }
            }
        }
        return Optional.empty();
    }

    @Override
    public List<Disciplina> buscarTodos() throws SQLException {
        List<Disciplina> disciplinas = new ArrayList<>();
        String sql = "SELECT * FROM disciplinas ORDER BY nome";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                disciplinas.add(mapear(rs));
            }
        }
        return disciplinas;
    }
    
    // Método auxiliar para converter um resultado do banco em um objeto Java
    private Disciplina mapear(ResultSet rs) throws SQLException {
        String nome = rs.getString("nome");
        int id = rs.getInt(1);
        // A lista de grades é carregada sob demanda, não aqui.
        return new Disciplina(id, nome, null);
    }
}