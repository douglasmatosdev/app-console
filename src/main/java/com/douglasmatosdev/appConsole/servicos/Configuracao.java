package com.douglasmatosdev.appConsole.servicos;

public class Configuracao {

    private double valorDaLaranjaUnidade = 0.50;
    private int quantidadeDeCaixasPromocao = 3;
    private int quantidadeDeLaranjaPorCaixa = 50;
    private int porcentagemDeLucro = 40;
    private int porcentagemDeDesconto = 10;
    private int porcentagemDeAcrescimo = 15;
    private int maximoParcelas = 12;
    private int valorParaDesconto = 100;

    public double getValorDaLaranjaUnidade() {
        return valorDaLaranjaUnidade;
    }

    public int getQuantidadeDeCaixasPromocao() {
        return quantidadeDeCaixasPromocao;
    }

    public int getQuantidadeDeLaranjaPorCaixa() {
        return quantidadeDeLaranjaPorCaixa;
    }

    public int getPorcentagemDeLucro() {
        return porcentagemDeLucro;
    }

    public int getPorcentagemDeDesconto() {
        return porcentagemDeDesconto;
    }

    public int getPorcentagemDeAcrescimo() {
        return porcentagemDeAcrescimo;
    }

    public int getMaximoParcelas() {
        return maximoParcelas;
    }

    public int getValorParaDesconto() {
        return valorParaDesconto;
    }
}
