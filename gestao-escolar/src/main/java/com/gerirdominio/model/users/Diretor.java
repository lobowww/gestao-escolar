package com.gerirdominio.model.users;

import java.util.List;

import com.gerirdominio.model.funcionalidades.Turma;

public class Diretor extends Usuario {
    private List<Coordenador> coordenadores;
    private List<Professor> professores;
    private List<Aluno> alunos;
    private List<Turma> turmas;
    
    public Diretor(int id, String nome, String cpf, String telefone, String email, String login, String senha,
            List<Coordenador> coordenadores, List<Professor> professores, List<Aluno> alunos, List<Turma> turmas) {
        super(id, nome, cpf, telefone, email, login, senha);
        this.coordenadores = coordenadores;
        this.professores = professores;
        this.alunos = alunos;
        this.turmas = turmas;
    }

    //Métodos a criar: cadastrarUsuario, alterarUsuario, removerUsuario, consultarPagamentos, emitirBoleto, visualizarDadosUsuarios, alterarAlunoDeTurma

    public List<Coordenador> getCoordenadores() {
        return coordenadores;
    }

    public void setCoordenadores(List<Coordenador> coordenadores) {
        this.coordenadores = coordenadores;
    }

    public List<Professor> getProfessores() {
        return professores;
    }

    public void setProfessores(List<Professor> professores) {
        this.professores = professores;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }
    
    public List<Turma> getTurmas() {
        return turmas;
    }

    public void setTurmas(List<Turma> turmas) {
        this.turmas = turmas;
    }
}