package com.gerirdominio.config.usersDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.Optional;

import com.gerirdominio.model.funcionalidades.Turma;
import com.gerirdominio.model.users.Aluno;
import com.gerirdominio.model.users.Coordenador;
import com.gerirdominio.model.users.Diretor;
import com.gerirdominio.model.users.Professor;
import com.gerirdominio.model.users.Usuario;
import com.gerirdominio.util.ConnectionFactory;

public class UsuarioDAO {

    /**
     * Insere um novo usuário (Aluno, Professor, etc.) no banco de dados.
     * Utiliza uma transação para garantir a integridade dos dados entre a tabela
     * 'usuarios' e a tabela específica do perfil.
     */
    public void inserir(Usuario usuario) throws SQLException {
        String sqlUsuario = "INSERT INTO usuarios (nome, cpf, telefone, email, login, senha, tipo_usuario) VALUES (?, ?, ?, ?, ?, ?, ?)";
        Connection conn = null;
        try {
            conn = ConnectionFactory.getConnection();
            conn.setAutoCommit(false); // Inicia a transação

            // 1. Inserir na tabela 'usuarios'
            try (PreparedStatement stmt = conn.prepareStatement(sqlUsuario, Statement.RETURN_GENERATED_KEYS)) {
                stmt.setString(1, usuario.getNome());
                stmt.setString(2, usuario.getCpf());
                stmt.setString(3, usuario.getTelefone());
                stmt.setString(4, usuario.getEmail());
                stmt.setString(5, usuario.getLogin());
                stmt.setString(6, usuario.getSenha());
                stmt.setString(7, getTipoUsuarioString(usuario));
                stmt.executeUpdate();

                try (ResultSet rs = stmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        usuario.setId(rs.getInt(1));
                    }
                }
            }

            // 2. Inserir na tabela específica do perfil
            if (usuario instanceof Aluno) {
                inserirDadosAluno((Aluno) usuario, conn);
            } else if (usuario instanceof Professor) {
                inserirDadosProfessor((Professor) usuario, conn);
            } else if (usuario instanceof Coordenador) {
                inserirDadosCoordenador((Coordenador) usuario, conn);
            } // Diretor não tem tabela específica

            conn.commit(); // Se tudo correu bem, confirma a transação
        } catch (SQLException e) {
            if (conn != null) conn.rollback(); // Em caso de erro, desfaz tudo
            throw e;
        } finally {
            if (conn != null) conn.close();
        }
    }

    private void inserirDadosAluno(Aluno aluno, Connection conn) throws SQLException {
        String sql = "INSERT INTO alunos (usuario_id, matricula, turma_id) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, aluno.getId());
            stmt.setString(2, aluno.getMatricula());
            if (aluno.getTurma() != null) {
                stmt.setInt(3, aluno.getTurma().getId());
            } else {
                stmt.setNull(3, Types.INTEGER);
            }
            stmt.executeUpdate();
        }
    }

    private void inserirDadosProfessor(Professor professor, Connection conn) throws SQLException {
        String sql = "INSERT INTO professores (usuario_id, especialidade_principal) VALUES (?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, professor.getId());
            stmt.setString(2, professor.getDisciplina());
            stmt.executeUpdate();
        }
    }

    private void inserirDadosCoordenador(Coordenador coordenador, Connection conn) throws SQLException {
        String sql = "INSERT INTO coordenadores (usuario_id) VALUES (?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, coordenador.getId());
            stmt.executeUpdate();
        }
    }

    /**
     * Busca um usuário pelo ID, retornando o objeto do tipo correto (Aluno, Professor, etc.).
     */
    public Optional<Usuario> buscarPorId(int id) throws SQLException {
        String sql = "SELECT u.*, a.matricula, a.turma_id, p.especialidade_principal " +
                     "FROM usuarios u " +
                     "LEFT JOIN alunos a ON u.id = a.usuario_id " +
                     "LEFT JOIN professores p ON u.id = p.usuario_id " +
                     "WHERE u.id = ?";
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

    private Usuario mapear(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        String nome = rs.getString("nome");
        String cpf = rs.getString("cpf");
        String telefone = rs.getString("telefone");
        String email = rs.getString("email");
        String login = rs.getString("login");
        String senha = rs.getString("senha");
        String tipo = rs.getString("tipo_usuario");

        switch (tipo) {
            case "ALUNO":
                String matricula = rs.getString("matricula");
                int turmaId = rs.getInt("turma_id");
                Turma turma = null;
                if (!rs.wasNull()) {
                    // Para carregar o objeto Turma, você usaria o TurmaDAO
                    // TurmaDAO turmaDAO = new TurmaDAO();
                    // turma = turmaDAO.buscarPorId(turmaId).orElse(null);
                }
                // As listas (histórico de pagamento) são carregadas sob demanda.
                return new Aluno(id, nome, cpf, telefone, email, login, senha, matricula, turma, null);
            case "PROFESSOR":
                String especialidade = rs.getString("especialidade_principal");
                // As listas (turmas, grades) são carregadas sob demanda.
                return new Professor(id, nome, cpf, telefone, email, login, senha, especialidade, null, null);
            case "COORDENADOR":
                // A lista de turmas é carregada sob demanda.
                return new Coordenador(id, nome, cpf, telefone, email, login, senha, null);
            case "DIRETOR":
                // Todas as listas são carregadas sob demanda.
                return new Diretor(id, nome, cpf, telefone, email, login, senha, null, null, null, null);
            default:
                throw new SQLException("Tipo de usuário desconhecido no banco: " + tipo);
        }
    }

    private String getTipoUsuarioString(Usuario usuario) {
        if (usuario instanceof Aluno) return "ALUNO";
        if (usuario instanceof Professor) return "PROFESSOR";
        if (usuario instanceof Coordenador) return "COORDENADOR";
        if (usuario instanceof Diretor) return "DIRETOR";
        throw new IllegalArgumentException("Tipo de usuário não suportado");
    }

    public Optional<Usuario> buscarPorCpf(String cpf) throws SQLException {
        String sql = "SELECT id FROM usuarios WHERE cpf = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cpf);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    // Se encontrou um CPF, usa o buscarPorId para carregar o objeto completo
                    return buscarPorId(rs.getInt("id"));
                }
            }
        }
        return Optional.empty();
    }
}
