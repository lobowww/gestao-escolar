package com.gerirdominio.model.funcionalidades;

import java.util.List;

public class Disciplina {
    private int id;
    private String nome;
    private List<Grade> grades;

    public Disciplina(int id, String nome, List<Grade> grades) {
        this.id = id;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Disciplina: " + nome + "Presente em : " + grades.size() + " grades.";
    }
}