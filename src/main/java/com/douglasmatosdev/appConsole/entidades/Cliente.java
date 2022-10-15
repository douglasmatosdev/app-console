package com.douglasmatosdev.appConsole.entidades;

public class Cliente {
    private String nome;
    private int quantidadeDeCaixas;
    private double valorTotal;

    public Cliente(String nome, int quantidadeDeCaixas, double valorTotal) {
        this.nome = nome;
        this.quantidadeDeCaixas = quantidadeDeCaixas;
        this.valorTotal = valorTotal;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidadeDeCaixas() {
        return quantidadeDeCaixas;
    }

    public void setQuantidadeDeCaixas(int quantidadeDeCaixas) {
        this.quantidadeDeCaixas = quantidadeDeCaixas;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

}
