package com.gerirdominio.service;

import com.gerirdominio.config.usersDAO.UsuarioDAO;
import com.gerirdominio.model.users.Aluno;
import com.gerirdominio.model.users.Usuario;
import com.gerirdominio.model.funcionalidades.Turma;
import java.sql.SQLException;
import java.util.Optional;

/**
 * Camada de Serviço para as funcionalidades do Diretor.
 * Contém a lógica de negócio e orquestra as chamadas aos DAOs.
 */
public class DiretorService {

    private final UsuarioDAO usuarioDAO;

    public DiretorService() {
        this.usuarioDAO = new UsuarioDAO();
    }

    /**
     * Lógica de negócio para cadastrar um novo aluno.
     * Valida os dados, cria o objeto e chama o DAO para persistir.
     */
    public Aluno cadastrarNovoAluno(String nome, String cpf, String telefone, String email, String login, String senha, String matricula, Turma turma) {
        
        // --- Exemplo de Lógica de Negócio ---
        // 1. Validar se já existe um utilizador com este CPF ou email
        try {
            if (usuarioDAO.buscarPorCpf(cpf).isPresent()) {
                throw new IllegalArgumentException("Já existe um utilizador com este CPF.");
            }
            // 2. Lógica de segurança: Aplicar HASH à senha
            // String senhaComHash = BCrypt.hashpw(senha, BCrypt.gensalt()); // Exemplo com a biblioteca BCrypt
            // Por agora, vamos usar a senha em texto, mas aqui seria o local para o hash.
            String senhaComHash = senha;


            // 3. Criar o objeto Aluno
            Aluno novoAluno = new Aluno(
                0, // ID é gerado pelo banco
                nome, cpf, telefone, email, login, senhaComHash,
                matricula, turma, null // Histórico de pagamento começa vazio
            );

            // 4. Chamar o DAO para inserir o aluno
            usuarioDAO.inserir(novoAluno);
            System.out.println("Aluno cadastrado com sucesso! ID gerado: " + novoAluno.getId());
            return novoAluno;

        } catch (SQLException e) {
            System.err.println("Erro no banco de dados ao cadastrar aluno: " + e.getMessage());
            e.printStackTrace(); // Para depuração
            return null; // Retorna null em caso de falha no DB
        } catch (IllegalArgumentException e) {
            // Captura as nossas validações de negócio e as do construtor
            System.err.println("Erro de validação: " + e.getMessage());
            return null; // Retorna null em caso de falha de validação
        }
    }
    
    // Outros métodos de serviço para o Diretor iriam aqui...
    // public void removerUsuario(int usuarioId) { ... }
    // public List<Usuario> listarTodosUsuarios() { ... }
}