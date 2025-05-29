package com.gerirdominio.model.funcionalidades;

import java.util.List;

public class Turma {
    private int id;
    private String nome;//8° Ano C
    private String turno;//Matutino
    private int ano;//2025
    private List<Aluno> alunos;
    private Grade grade;
    
    public Turma(int id, String nome, String turno, int ano, List<Aluno> alunos, Grade grade) {
        this.id = id;
        this.nome = nome;
        this.turno = turno;
        this.ano = ano;
        this.alunos = alunos;
        this.grade = grade;
    }

    //Métodos a criar: adicionarAluno, removerAluno

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }
    
    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    @Override
    public String toString() {
        return "Turma: " + nome + "contém " + alunos.size() + "alunos.";
    }
}
