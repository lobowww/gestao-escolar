package com.gerirdominio.view;

import java.util.Scanner;

public class MenuProfessor {
    Scanner sc = new Scanner(System.in);

    public void exibirMenuProfessor(){
        Integer opcao;
        System.out.println("====MENU PROFESSOR=====");
        System.out.println("1. Registrar nota");
        System.out.println("2. Registrar frequência");
        System.out.println("3. Visualizar grade");
        opcao =sc.nextInt();



        switch (opcao) {
            case 1:
                //Metodo registrar nota
                break;
            case 2:
            //Metodo registrar frequência
            break;
            case 3:
            //Metodo para visualizar a grade
            break;
        
            default:
            System.out.println("OPÇÃO INVALIDA");
                break;
        }
    }
    

}
