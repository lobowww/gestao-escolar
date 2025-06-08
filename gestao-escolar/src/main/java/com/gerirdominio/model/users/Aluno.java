package com.gerirdominio.model.users;
import java.util.List;

import com.gerirdominio.model.funcionalidades.Disciplina;
import com.gerirdominio.model.funcionalidades.Mensalidade;
import com.gerirdominio.model.funcionalidades.Turma;

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
    public void consultarNotas(){
        System.out.println("Notas para o aluno " + nome);
        if (turma != null && turma.getGrade() != null) {
            for (Disciplina disciplina : turma.getGrade().getDisciplina()) {
                System.out.println(" - " + disciplina.getNome() + ": [Nota: 2.0]" );
            }
            
        } else{
            System.out.println("Aluno não está em turma");
        }

    }

    public void consultarFaltas(){
        System.out.println("Faltas para o aluno: " + nome);
        System.out.println("[20]");

    }
    public void consultarGrade(){

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

    @Override
    public boolean autenticar() {
        return login != null && senha != null;
    }
}