package com.gerirdominio.view;

import java.util.Scanner;

public class MenuDiretor {

    public void exibirMenuDiretor(){
        Scanner sc = new Scanner(System.in);
        Integer opcao;
        System.out.println("=====MENU DIRETOR=====");
        System.out.println("1. Cadastrar Professor");
        System.out.println("2. Cadastrar Coordenador");
        System.out.println("3. Cadastrar Aluno");
        System.out.println("4. Alterar Aluno");
        System.out.println("5. Alterar Professor");
        System.out.println("6. Alterar Coordenador");
        System.out.println("7. Removar Aluno");
        System.out.println("8. Remover Professor");
        System.out.println("9. Remover Coordenador");
        System.out.println("10. Consultar pagamentos");
        System.out.println("11. Emitir Boletos");
        System.out.println("12. Visualizar dados dos Alunos");
        System.out.println("13. Visualizar dados dos Funcionarios");
        opcao = sc.nextInt();


        switch (opcao) {
            case 1:
          
                //Metodo cadastrar funcionario
                break;
            case 2: 
                //Metodo de cadastrar ALuno
                break;
            case 3:
            //metodo Alterar aluno
            break;
            case 4:
            //metodo alterar funcionario
            break;
            case 5:
            //metodo remover aluno
            break;
            case 6: 
            //metodo remover funcionario
            break;
            case 7:
            //metodo consultar pagamentos
            break;
            case 8:
            //emitir boletos
            break;
            case 9:
            //visualizar dados dos alunos
            break;
            case 10:
            //visualizar dados dos funcionarios
            break;
        
            default:
            System.out.println("OPÇÃO INVALIDA");
                break;
        }
        sc.close();
    }
}
