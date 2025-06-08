package com.gerirdominio.view;

import java.util.Scanner;

public class MenuCoordenador {
 public void exibirMenuCoordenador(){
    Scanner sc = new Scanner(System.in);
        Integer opcao;
        System.out.println("=====MENU COORDENADOR=====");
        System.out.println("1. Criar Turmas");
        System.out.println("2. Editar Turma");
        System.out.println("3. Remover Turmas");
        System.out.println("4. Criar Grades");
        System.out.println("5. Editar Grades");
        System.out.println("6. Alocar Professor");
        System.out.println("7. Alterar Aluno de Turma");
        System.out.println("SELECIONE UMA OPÇÃO: ");
        opcao = sc.nextInt();

        switch (opcao) {
            case 1:
                //Metodo criar turmas
                break;
            case 2:
            //metodo editar turmas
                break;
            case 3:
            //metodo Remover  turma
               break;
            case 4:
            //metodo criar grade
                break;
            case 5:
            //metodo editar grade
               break;
            case 6:
            //metodo alocar professor
               break;
            case 7:
            //metodo alterar aluno de turma
               break;
        
            default:
            System.out.println("OPÇÃO INVALIDA");
            break;

        }
        sc.close();
    }
    
}
