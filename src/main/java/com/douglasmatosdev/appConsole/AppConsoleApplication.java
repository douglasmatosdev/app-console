package com.douglasmatosdev.appConsole;

import java.io.*;

// import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppConsoleApplication {

	/*
	 * João é um comerciante que vende laranjas.
	 * Ele precisa fazer uma entrega de algumas coixas.
	 * Cada laranja ele vende por 0,50 centavosm cada caixa tem 50 laranjas.
	 * 
	 * Faça um programa que peça a quantidade de caixas para o joão e de o total de
	 * receber.
	 * 
	 * Perguntar se o pagamento é a vista, caso seja a vista e valor for maior que
	 * R$100 dar um desconto de 10%
	 * 
	 * Promoção levou 10 ganhou 10%, ou seja se for 10 caixas dar 10% de desconto.
	 * 
	 * Caso o pagamento seja parcelado acrescentar 15% sobre o valor total segundo a
	 * tabela.
	 * 2x = 5%
	 * 3x = 8%
	 * 4x = 10%
	 * 5x = 13
	 * Maior que 5x = 15%
	 * 
	 * Obs.: Aceitar parcelas no máximo até 12 meses, e mostrar o valor de cada
	 * parcela já com acréscimo.
	 * 
	 * O lucro do comerciante será de 45% em suas vendas
	 * 
	 * Dar um relatório final a operação acima.
	 */

	public static void main(String[] args) {
		System.out.println("============================");
		System.out.println("		Welcome!!!			");
		System.out.println("============================");

		Console cnsl = System.console();
		int quantidadeDeCaixas = Integer.parseInt(cnsl.readLine("Digite a quantidade de caixas: \n"));

		double valorDaLaranjaUnidade = 0.50;
		int porcentagemDeLucro = 40;
		int quantidadeDeCaixasPromocao = 10;
		int porcentagemDeDesconto = 10;
		int porcentagemDeAcrescimo = 15;
		int maximoParcelas = 12;
		int valorParaDesconto = 100;
		int quantidadeDeLaranjaPorCaixa = 50;
		int totalDeLaranjas = quantidadeDeCaixas * quantidadeDeLaranjaPorCaixa;
		double valorTotal = totalDeLaranjas * valorDaLaranjaUnidade;
		double valorTotalAlterado = valorTotal;
		int parcelas = 0;
		String tipoPagamento = cnsl.readLine("Pagamento a vista ou parcelado ?\n [A/P]:\n");
		boolean aVista = tipoPagamento.toUpperCase().equals("A");

		if (aVista) {
			System.out.println("Pagamento a vista foi selecionado!\n\n");

			if (valorTotal > valorParaDesconto || quantidadeDeCaixas == quantidadeDeCaixasPromocao) {
				valorTotalAlterado -= (valorTotal * porcentagemDeDesconto / 100);
			}
		} else {
			parcelas = Integer.parseInt(
					cnsl.readLine("Pagamento parcelado foi selecionado!\n\nDigite a quantidade de parcelas:\n"));

			if (parcelas > maximoParcelas) {
				System.out.println("Quantidade de parcelas inválida, iremos assumir em " + maximoParcelas + " vezes");
				parcelas = maximoParcelas;
			}

			if (parcelas == 1) {
				System.out.println("Pagamento a vista foi selecionado!\n\n");
				if (valorTotal > valorParaDesconto || quantidadeDeCaixas == quantidadeDeCaixasPromocao) {
					valorTotalAlterado -= (valorTotal * porcentagemDeDesconto / 100);
				}
			} else if (parcelas > 5) {
				valorTotalAlterado += (valorTotal * porcentagemDeAcrescimo / 100);
			} else {
				switch (parcelas) {
					case 2:
						porcentagemDeAcrescimo = 5;
						break;
					case 3:
						porcentagemDeAcrescimo = 8;
						break;
					case 4:
						porcentagemDeAcrescimo = 10;
						break;
					case 5:
						porcentagemDeAcrescimo = 13;
						break;
				}
				valorTotalAlterado += (valorTotal * porcentagemDeAcrescimo / 100);
			}

		}

		double lucroAReceber = (valorTotalAlterado * porcentagemDeLucro / 100);

		System.out.println("============================================\n");
		System.out.println("Parabéns pela venda!!!\n\n");
		System.out.println("O lucro é de R$ " + lucroAReceber);
		System.out.println("O valor total a cobrar do cliente é de R$ " + valorTotalAlterado);
		System.out.println("O cliente escolheu o tipo de pagamento "
				+ (aVista ? "À vista" : "Parcelado em " + parcelas + " vezes."));
		if (aVista) {
			System.out.println("Para pagamento a vista demos o desconto dê R$ " + (valorTotal - valorTotalAlterado));
		} else {
			System.out.println(
					"Para pagamento parcelado colocamos um acréscimo de R$ " + (valorTotalAlterado - valorTotal));
			System.out.println("o valor das parcelas será de R$ " + (valorTotalAlterado / parcelas));
		}
		System.out.println(" ");
		System.out.println("============================================\n\n");

		// SpringApplication.run(AppConsoleApplication.class, args);
	}

}
