package com.gerirdominio.util;

import java.sql.Connection;
import java.sql.SQLException;

public class TesteConexao {

    public static void main(String[] args) {
        Connection conexao = null;
        System.out.println("Iniciando teste de conexão...");

        try {
            System.out.println("Tentando obter conexão da ConnectionFactory...");
            conexao = ConnectionFactory.getConnection(); // Tenta obter a conexão

            // Se chegou até aqui sem exceção, a conexão foi estabelecida
            System.out.println("SUCESSO: Conexão com o banco de dados estabelecida!");

            // (Opcional) Verificar se a conexão está aberta e válida
            if (conexao != null && !conexao.isClosed()) {
                System.out.println("INFO: A conexão está aberta.");
                try {
                    if (conexao.isValid(5)) { // Timeout de 5 segundos
                        System.out.println("INFO: A conexão é válida (verificado com isValid(5)).");
                    } else {
                        System.err.println("ERRO: A conexão não é válida (verificado com isValid(5)).");
                    }
                } catch (SQLException e_valid) {
                    System.err.println("ERRO ao verificar a validade da conexão: " + e_valid.getMessage());
                    e_valid.printStackTrace();
                }
            } else if (conexao == null) {
                System.err.println("ERRO: O objeto de conexão é nulo após chamar ConnectionFactory.getConnection().");
            } else if (conexao.isClosed()) {
                System.err.println("ERRO: A conexão foi fechada inesperadamente.");
            }

        } catch (RuntimeException e_runtime) {
            System.err.println("FALHA AO CONECTAR: Erro ao tentar obter conexão da ConnectionFactory.");
            System.err.println("Mensagem da RuntimeException: " + e_runtime.getMessage());
            if (e_runtime.getCause() instanceof SQLException) {
                SQLException e_sql = (SQLException) e_runtime.getCause();
                System.err.println("Causa Raiz (SQLException):");
                System.err.println("  SQLState: " + e_sql.getSQLState());
                System.err.println("  ErrorCode: " + e_sql.getErrorCode());
                System.err.println("  Message: " + e_sql.getMessage());
            }
            e_runtime.printStackTrace();
        } catch (Exception e_geral) {
            System.err.println("FALHA AO CONECTAR: Ocorreu um erro inesperado.");
            e_geral.printStackTrace();
        }
        finally {
            if (conexao != null) {
                try {
                    System.out.println("INFO: Tentando fechar a conexão com o banco de dados...");
                    conexao.close();
                    System.out.println("SUCESSO: Conexão fechada.");
                } catch (SQLException e_close) {
                    System.err.println("ERRO ao fechar a conexão: " + e_close.getMessage());
                    e_close.printStackTrace();
                }
            }
        }
        System.out.println("Teste de conexão finalizado.");
    }
}
