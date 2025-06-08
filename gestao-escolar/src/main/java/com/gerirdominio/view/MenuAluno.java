package com.gerirdominio.view;

import java.util.Scanner;

public class MenuAluno {
public void exibirMenuAluno(){
        Scanner sc = new Scanner(System.in);
        Integer opcao;
        System.out.println("=====MENU ALUNO=====");
        System.out.println("1. Ver Nota " + "\n2. Ver frequência " + "\n3. Ver Grade");
        opcao = sc.nextInt();
        switch (opcao) {
            case 1:
                //Metodo para visualizar nota do aluno
                break;
            case 2:
            //metodo para visualizar a frequencia do aluno
            break;
            case 3:
            //metodo para visualizar a grade
            break;
        
            default:
                break;
        }
        sc.close();
    }
}
