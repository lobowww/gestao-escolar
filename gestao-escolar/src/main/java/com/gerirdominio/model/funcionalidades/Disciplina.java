package com.gerirdominio.model.funcionalidades;

import java.util.List;

public class Disciplina {
    private String nome;
    private List<Grade> grades;

    public Disciplina(String nome, List<Grade> grades) {
        this.nome = nome;
        this.grades = grades;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Grade> getGrades() {
        return grades;
    }

    public void setGrades(List<Grade> grades) {
        this.grades = grades;
    }

    @Override
    public String toString() {
        return "Disciplina: " + nome + "Presente em : " + grades.size() + " grades.";
    }
}