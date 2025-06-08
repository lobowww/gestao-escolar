package com.gerirdominio;

import java.util.Scanner;

public class App {
    public static void main(String[] args){
         Scanner scan = new Scanner(System.in);
        System.out.println("======================GERIR - SISTEMA DE GESTÃO ESCOLAR===================\n Seja bem vindo ao nosso sistema Por gentileza informe:\n");
        System.out.println("Login: ");
        String login = scan.nextLine();
        System.out.println("Senha: ");
        String senha = scan.nextLine();

        String tipomenu = "";

        if (login.equals("diretor123") ) {
            tipomenu = "Diretor";
            System.out.println("DIRETOR ESTÁ FUNCINANDO");
            //METODO PARA EXIBIR MENU DO DIRETOR
        } else if (login.equals("coordenador123")) {
            tipomenu = "Coordenador";
            System.out.println("O COORDENADOR ESTÁ FUNCIONANDO");
            //METODO PARA EXIBIR O MENU DO COORDENADOR
            
        } else if (login.equals("aluno123")) {
            tipomenu = "Aluno";
            System.out.println("O ALUNO ESTÁ FUNCINANDO");
            //METODO PARA EXIBIR O MENU DO ALUNO
            
        } else if (login.equals("professor123")) {
            tipomenu = "Professor";
            System.out.println("O PROFESSOR ESTÁ FUNCIONANDO");
            //METODO PARA EXIBIR O MENU DO PROFESSOR
        } else{
            System.out.println("OPÇÃO INVALIDA");
        }

        
            scan.close();
        
    }
    
    }

