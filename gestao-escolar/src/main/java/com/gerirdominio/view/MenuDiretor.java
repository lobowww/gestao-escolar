package com.gerirdominio.view;

import com.gerirdominio.service.DiretorService;
import java.util.Scanner;

public class MenuDiretor {

    private final DiretorService diretorService;
    private final Scanner scanner;

    public MenuDiretor() {
        this.diretorService = new DiretorService(); // O menu cria o serviço
        this.scanner = new Scanner(System.in);
    }
    
    public void exibirMenu() {
        // ...
        System.out.println("Opção 1: Cadastrar Novo Aluno");
        iniciarCadastroAluno();
    }
    
    private void iniciarCadastroAluno() {
        System.out.println("--- Cadastro de Novo Aluno ---");
        
        System.out.print("Nome completo: ");
        String nome = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Login: ");
        String login = scanner.nextLine();
        System.out.print("Senha: ");
        String senha = scanner.nextLine();
        System.out.print("Matrícula: ");
        String matricula = scanner.nextLine();
        
        System.out.println("\nA processar o cadastro...");

        // O menu simplesmente chama o serviço. Toda a complexidade está escondida.
        if (diretorService.cadastrarNovoAluno(nome, cpf, telefone, email, login, senha, matricula, null) != null) {
            System.out.println("Operação finalizada com sucesso!");
        } else {
            System.out.println("A operação falhou. Verifique a mensagem de erro acima.");
        }
    }
}
