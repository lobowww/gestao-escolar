package com.gerirdominio.model.users;

import java.util.List;

public class Aluno extends Usuario {
    private String matricula;
    private Turma turma;
    private List<Mensalidade> historicoPagamento;
    
    public Aluno(int id, String nome, String cpf, String telefone, String email, String login, String senha,
            String matricula, Turma turma, List<Mensalidade> historicoPagamento) {
        super(id, nome, cpf, telefone, email, login, senha);
        this.matricula = matricula;
        this.turma = turma;
        this.historicoPagamento = historicoPagamento;
    }

    //Métodos a criar: consultarNotas, consultarFaltas, consultarGrade, Adc notas, adc presença
    public void adcNotas(Disciplina disciplina, double nota){

    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public List<Mensalidade> getHistoricoPagamento() {
        return historicoPagamento;
    }

    public void setHistoricoPagamento(List<Mensalidade> historicoPagamento) {
        this.historicoPagamento = historicoPagamento;
    }

    @Override
    public String toString() {
        return "Matricula: "+ matricula + 
        "\nAluno: " + super.getNome() + 
        "\nTurma: " + turma.getNome();
    }
}