package com.gerirdominio.model.funcionalidades;

import java.time.*;

public class Aula {
    private String dia;
    private LocalTime horarioInicio;
    private LocalTime horarioFim;
    private Disciplina disciplina;
    private Professor professor;
    
    public Aula(String dia, LocalTime horarioInicio, LocalTime horarioFim, Disciplina disciplina, Professor professor) {
        this.dia = dia;
        this.horarioInicio = horarioInicio;
        this.horarioFim = horarioFim;
        this.disciplina = disciplina;
        this.professor = professor;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public LocalTime getHorarioInicio() {
        return horarioInicio;
    }

    public void setHorarioInicio(LocalTime horarioInicio) {
        this.horarioInicio = horarioInicio;
    }

    public LocalTime getHorarioFim() {
        return horarioFim;
    }

    public void setHorarioFim(LocalTime horarioFim) {
        this.horarioFim = horarioFim;
    }
    
    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    @Override
    public String toString() {
        return "Disciplina: " + disciplina + 
        "\n"dia + " de " + horarioInicio + " até "+ horarioFim + "com o professor(a): " + professor;
    }
}