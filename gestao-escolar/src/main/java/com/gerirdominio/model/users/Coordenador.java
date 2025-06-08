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
    public void criarTurma(Turma turma){
 if (turma != null &&  !turmas.contains(turma)) {
    turmas.add(turma);
    System.out.println("Turma criada: " + turma.getNome());
 }
    }
    public void editarTurma(Turma turmaEditar){
        for(int i = 0; i < turmas.size(); i++){
            if (turmas.get(i).getId() == turmaEditar.getId()) {
                turmas.set(i, turmaEditar);
                System.out.println("Turma editada " + turmaEditar.getNome());
                return;
                
            }
        }
        System.out.println("Turma não encontrada");
    }
    public void removerTurma(Turma turma){
        if (turmas.removeIf(t -> t.getId() == turma.getId())) {
            System.out.println("Turma removida: " + turma.getNome());
            
        }else {
            System.out.println("Turma não encontrada");
        }

    }
    

    public List<Turma> getTurmas() {
        return turmas;
    }

    public void setTurmas(List<Turma> turmas) {
        this.turmas = turmas;
    }

    @Override
    public boolean autenticar() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'autenticar'");
    }
}
