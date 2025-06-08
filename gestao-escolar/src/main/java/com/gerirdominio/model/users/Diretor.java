package com.gerirdominio.model.users;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.gerirdominio.model.funcionalidades.Mensalidade;
import com.gerirdominio.model.funcionalidades.Turma;

public class Diretor extends Usuario {
    private List<Coordenador> coordenadores;
    private List<Professor> professores;
    private List<Usuario> funcionarios;
    private List<Aluno> alunos;
    private List<Turma> turmas;
    ArrayList<Usuario> user = new ArrayList<>();

    public Diretor(int id, String nome, String cpf, String telefone, String email, String login, String senha,
            List<Coordenador> coordenadores, List<Professor> professores, List<Aluno> alunos, List<Turma> turmas) {
        super(id, nome, cpf, telefone, email, login, senha);
        this.coordenadores = coordenadores;
        this.professores = professores;
        this.alunos = alunos;
        this.turmas = turmas;
    }

    //Métodos a criar: cadastrarUsuario, alterarUsuario, removerUsuario, consultarPagamentos, emitirBoleto, visualizarDadosUsuarios, alterarAlunoDeTurma
     public boolean autenticar(){
        return this.login != null && this.senha != null && !login.isEmpty() && !senha.isEmpty();
    }

    public void cadastrarUsuario(Usuario usuario){
        Scanner sc = new Scanner(System.in);
        System.out.println("Informe as seguintes informações: ");
        System.out.println("ID: ");
        int id = sc.nextInt();
        System.out.println("Nome: ");
        String nome = sc.next();
        System.out.println("cpf: ");
        String cpf = sc.next();
        System.out.println("Telefone: ");
        String telefone = sc.next();
        System.out.println("email: ");
        String email = sc.nextLine();
        System.out.println("login: ");
        String login = sc.next();
        System.out.println("senha: ");
        String senha = sc.next();
        System.out.println("disciplina: ");
        String disciplina = sc.next();
        

        if (login.equals("professor123")) {
            
        
        user.add(new Professor(id, nome, cpf, telefone, email, login, senha, disciplina, turmas, null));
        System.out.println("PROFESSOR CADASTRADO NO SISTEMA!");
        } else if (login.equals("aluno123")) {
            user.add(new Aluno(id, nome, cpf, telefone, email, login, senha, disciplina, null, null));
            System.out.println("ALUNO CADASTRADO NO SISTEMA");
        } else if (login.equals("coordenador123")) {
            user.add(new Coordenador(id, nome, cpf, telefone, email, login, senha, turmas));
            System.out.println("COORDENADOR CADASTRADO NO SISTEMA!");
        } else{
            System.out.println("OPÇÃO INVALIDA");
        }

        sc.close();

    }
    public void alterarUsuario(Usuario usuario){
        for(int i = 0; i < funcionarios.size(); i++) {
            if (funcionarios.get(i).id == usuario.id) {
                funcionarios.set(i, usuario);
                System.out.println("Usuario alterado: " + usuario.nome);
                return;
                
            }
        }       
        System.out.println("Usuario não encontrado");
    }
    public void removerUsuario(Usuario usuario){
        if (funcionarios.removeIf(u -> u.id == usuario.id)) {
            System.out.println("Usuario removido: " + usuario.nome);
            
        } else {
            System.out.println("Usuario não encontrado");
        }
    }


    public void emitirBoleto(Aluno aluno){
        Mensalidade nova = new Mensalidade(id, 500.0, null, null, cpf);
        aluno.getHistoricoPagamento().add(nova);
        System.out.println("Boleto emitido para : " + aluno.getNome());
    }

    public void dadosUsuarios(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Deseja visualizar Dados dos:\n 1.Aunos \n2.Coordenadores \n3.Professores");
        int op = sc.nextInt();

        switch (op) {
            case 1:
        System.out.println("------ ALUNOS ------");
        for (Usuario u : user) {
            if (u instanceof Aluno) {
                u.getNome();
                System.out.println("=================");
                break;
                
        }
        }
        case 3: 
        System.out.println("------ COORDENADORES ----- ");
        for (Usuario u : user) {
            if (u instanceof Coordenador) {
                u.getNome();
                System.out.println("==================");

                break;
            }
            
        }
                case 2:
                    System.out.println("------Professores-----");
                    for (Usuario u : user) {
                        if (u instanceof Professor) {
                            u.getNome();
                            System.out.println("===============");
                            break;
                        }
                    }

            default:
            break;
        }

        sc.close();
    }

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