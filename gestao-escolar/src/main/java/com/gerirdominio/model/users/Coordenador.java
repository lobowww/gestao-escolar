package com.gerirdominio.model.users;
import java.util.List;

import com.gerirdominio.model.funcionalidades.Turma;

public class Coordenador extends Usuario {
    private List<Turma> turmas;

    public Coordenador(int id, String nome, String cpf, String telefone, String email, String login, String senha,
            List<Turma> turmas) {
        super(id, nome, cpf, telefone, email, login, senha);
        this.turmas = turmas;
    }
    //Métodos a criar: criarTurma, editarTurma, removerTurma, criarGrade, editarGrade, alocarProfessor, alterarAlunoDeTurma

    public List<Turma> getTurmas() {
        return turmas;
    }

    public void setTurmas(List<Turma> turmas) {
        this.turmas = turmas;
    }
}
