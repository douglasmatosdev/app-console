package com.douglasmatosdev.appConsole.entidades;

public class Pedido {
    private Cliente cliente;
    private int quantidadeDeCaixas;
    private double valorTotal;
    private int totalDeLaranjas = 0;
    private double valorTotalAlterado = 0;
    private int parcelas = 0;
    private int porcentagemAcrescimo = 0;
    private double lucroAReceber = 0;

    public double getLucroAReceber() {
        return lucroAReceber;
    }

    public int getTotalDeLaranjas() {
        return totalDeLaranjas;
    }

    public void setTotalDeLaranjas(int quantidadeDeCaixas, double valorDaLaranja, int quantidadeDeLaranjaPorCaixa) {
        this.totalDeLaranjas = quantidadeDeCaixas * quantidadeDeLaranjaPorCaixa;
        this.setValorTotal(totalDeLaranjas * valorDaLaranja);
    }

    public double getValorTotalAlterado() {
        return valorTotalAlterado;
    }

    public void setValorTotalAlterado(double valorTotalAlterado) {
        this.valorTotalAlterado = valorTotalAlterado;
    }

    public int getParcelas() {
        return parcelas;
    }

    public void setParcelas(int parcelas) {
        this.parcelas = parcelas;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
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
        this.setValorTotalAlterado(this.getValorTotal());
    }

    public void alterarValorParaPagamentoAVista(
            int valorParaDesconto,
            int quantidadeDeCaixas2,
            int quantidadeDeCaixasPromocao,
            int porcentagemDeDesconto) {

        if (valorTotal > valorParaDesconto || quantidadeDeCaixas == quantidadeDeCaixasPromocao) {
            valorTotalAlterado -= (valorTotal * porcentagemDeDesconto / 100);
        }
    }

    public void acrescentaJuros(int porcentagemDeAcrescimoPadrao) {
        this.porcentagemAcrescimo = porcentagemDeAcrescimoPadrao;
        if (this.parcelas <= 5) {
            switch (this.parcelas) {
                case 2:
                    this.porcentagemAcrescimo = 5;
                    break;
                case 3:
                    this.porcentagemAcrescimo = 8;
                    break;
                case 4:
                    this.porcentagemAcrescimo = 10;
                    break;
                case 5:
                    this.porcentagemAcrescimo = 13;
                    break;
            }
        }
        this.valorTotalAlterado += (this.valorTotal * this.porcentagemAcrescimo / 100);
    }

    public void calculaLucroAReceber(int porcentagemLucro) {
        this.lucroAReceber = (this.valorTotalAlterado * porcentagemLucro / 100);
    }

    public double valorDoDesconto() {
        return this.valorTotal - this.valorTotalAlterado;
    }

    public double valorDoJuros() {
        return this.valorTotalAlterado - this.valorTotal;
    }

    public double valorDasParcelas() {
        return this.valorTotalAlterado / this.parcelas;
    }
}
