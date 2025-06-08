package com.gerirdominio.view;

import java.util.Scanner;

public class MenuPrincipal {

    public static void MenuPrincipal(){
        Scanner scan = new Scanner(System.in);
        System.out.println("======================GERIR - SISTEMA DE GESTÃO ESCOLAR===================\n" +
                            "Seja bem vindo ao nosso sistema!\n"+
                            "Por gentileza informe:\n"+
                            "Login: ");
        String login = scan.nextLine();
        System.out.println("Senha: ");
        String senha = scan.nextLine();
        String tipomenu;

        

        switch (tipomenu) {
            case "Diretor":
                //METÓDO EXIBIR MENU DIRETOR
                break;
            case "Coordenador":
            //METÓDO EXIBIR MENU COORDENADOR
            break;
            case "Aluno":
            //METÓDO EXIBIR MENU ALUNO
            break;
            case "Professor":
            //METÓDO EXIBIR MENU PROFESSOR            
            break;    
            default:
            System.out.println("OPÇÃO INVALIDA");
                break;
        }
    }
}

