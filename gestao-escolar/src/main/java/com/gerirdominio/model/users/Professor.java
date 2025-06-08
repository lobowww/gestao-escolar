package com.gerirdominio.model.users;
import java.util.List;

import com.gerirdominio.model.funcionalidades.Disciplina;
import com.gerirdominio.model.funcionalidades.Grade;
import com.gerirdominio.model.funcionalidades.Turma;

public class Professor extends Usuario {
    private String disciplina;
    private List<Turma> turmas;
    private List<Grade> grades;

    public Professor(int id, String nome, String cpf, String telefone, String email, String login, String senha,
            String disciplina, List<Turma> turmas, List<Grade> grades) {
        super(id, nome, cpf, telefone, email, login, senha);
        this.disciplina = disciplina;
        this.turmas = turmas;
        this.grades = grades;
    }

    //Métodos a criar: registrarPresenca, lançarNotas, consultarGrade

    public void registrarPresenca(Turma turma){
        System.out.println(turma.getAlunos() + "Presença confirmada");
        


    }
    public void lancarNotas(Turma turma){
        if (turmas.contains(turma)) {
            System.out.println("Notas lançadas para a turma " + turma.getNome());

            
        }else {
            System.out.println("Você não lançou nota para esta turma");
        }

    }
    public void consultarGrade(){
        

    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public List<Turma> getTurmas() {
        return turmas;
    }

    public void setTurmas(List<Turma> turmas) {
        this.turmas = turmas;
    }

    public List<Grade> getGrades() {
        return grades;
    }

    public void setGrades(List<Grade> grades) {
        this.grades = grades;
    }

    @Override
    public String toString() {
        return super.toString() +
        "\nDisciplina: " + disciplina +
        "\nTurma: " + turmas.size() +
        "\nGrades: " + grades.size();
    }

    @Override
    public boolean autenticar() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'autenticar'");
    }
}