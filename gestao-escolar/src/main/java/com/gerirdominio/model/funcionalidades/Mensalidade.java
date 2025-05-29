package com.gerirdominio.model.funcionalidades;

import java.time.*;

public class Mensalidade {
    private int id;
    private Double valor;
    private LocalDate vencimento;
    private LocalDate dataPagamento;
    private String numBoleto;
    private boolean statusPagamento;//true = pago, false = pendente

    public Mensalidade(int id, Double valor, LocalDate vencimento, LocalDate dataPagamento, String numBoleto) {
        this.id = id;
        this.valor = valor;
        this.vencimento = vencimento;
        this.dataPagamento = dataPagamento;
        this.numBoleto = numBoleto;
        this.statusPagamento = false;
    }
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public LocalDate getVencimento() {
        return vencimento;
    }

    public void setVencimento(LocalDate vencimento) {
        this.vencimento = vencimento;
    }

    public LocalDate getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(LocalDate dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public String getNumBoleto() {
        return numBoleto;
    }

    public void setNumBoleto(String numBoleto) {
        this.numBoleto = numBoleto;
    }

    public boolean getStatusPagamento() {
        return statusPagamento;
    }

    public void setStatusPagamento(boolean statusPagamento) {
        this.statusPagamento = statusPagamento;
    }

    @Override
    public String toString() {
        String texto = "Mensalidade: " + id +
            "\nValor: R$" + valor +
            "\nVencimento: " + vencimento +
            "\nNumBoleto: " + numBoleto +
            "\nStatusPagamento: ";
    if(statusPagamento == true){
        texto += "Pago" +
        "\ndataPagamento: " + dataPagamento;
    }else{
        texto += "Pendente";
    }
    return texto;
    }
}
