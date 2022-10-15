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
	 */

	public static void main(String[] args) {
		System.out.println("============================");
		System.out.println("		Welcome!!!			");
		System.out.println("============================");

		Console cnsl = System.console();
		int quantidadeDeCaixas = Integer.parseInt(cnsl.readLine("Digite a quantidade de caixas: \n"));

		double valorDaLaranjaUnidade = 0.50;
		int quantidadeDeLaranjaPorCaixa = 50;
		int totalDeLaranjas = quantidadeDeCaixas * quantidadeDeLaranjaPorCaixa;
		double valorTotal = totalDeLaranjas * valorDaLaranjaUnidade;

		System.out.println("============================================");
		System.out.println("Valor total a receber é de R$ " + valorTotal);
		System.out.println("============================================");

		// SpringApplication.run(AppConsoleApplication.class, args);
	}

}
