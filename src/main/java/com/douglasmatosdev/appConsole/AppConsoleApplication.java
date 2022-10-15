package com.douglasmatosdev.appConsole;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

// import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.douglasmatosdev.appConsole.entidades.Cliente;
import com.douglasmatosdev.appConsole.entidades.Pedido;
import com.douglasmatosdev.appConsole.servicos.Configuracao;

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
	 * 
	 * Armazene o nome e o valor do cliente para que o final da operaão você possa
	 * mostrar o nome ea quantidade de caixas
	 */

	public static void main(String[] args) {
		List<Pedido> pedidos = new ArrayList<Pedido>();
		Configuracao config = new Configuracao();

		while (true) {
			Console cnsl = System.console();
			System.out.println("============================");
			System.out.println("\tWelcome!!!");
			System.out.println("============================");
			int sair = Integer.parseInt(cnsl.readLine("Digite:\n1 para continuar\n0 para sair\n"));
			if (sair == 0) {
				break;
			}

			Pedido pedido = new Pedido();
			pedido.setCliente(new Cliente());

			pedido.getCliente().setNome(cnsl.readLine("Digite o nome do cliente:\n"));
			int quantidadeDeCaixas = Integer
					.parseInt(
							cnsl.readLine("Digite a quantidade de caixas que o " + pedido.getCliente().getNome()
									+ " deseja: \n"));

			pedido.setQuantidadeDeCaixas(quantidadeDeCaixas);

			System.out.println("[" + quantidadeDeCaixas + "]");

			pedido.setTotalDeLaranjas(quantidadeDeCaixas, config.getValorDaLaranjaUnidade(),
					config.getQuantidadeDeLaranjaPorCaixa());

			String tipoPagamento = cnsl.readLine("Pagamento a vista ou parcelado ?\n [A/P]:\n");
			boolean aVista = tipoPagamento.toUpperCase().equals("A");

			if (aVista) {
				System.out.println("Pagamento a vista foi selecionado!\n\n");

				pedido.alterarValorParaPagamentoAVista(
						config.getValorParaDesconto(),
						quantidadeDeCaixas,
						config.getQuantidadeDeCaixasPromocao(),
						config.getPorcentagemDeDesconto());

			} else {
				pedido.setParcelas(Integer.parseInt(
						cnsl.readLine("Pagamento parcelado foi selecionado!\n\nDigite a quantidade de parcelas:\n")));

				if (pedido.getParcelas() > config.getMaximoParcelas()) {
					System.out
							.println("Quantidade de parcelas inválida, iremos assumir em " + config.getMaximoParcelas()
									+ " vezes");
					pedido.setParcelas(config.getMaximoParcelas());
				}

				if (pedido.getParcelas() == 1) {
					System.out.println("Pagamento a vista foi selecionado!\n\n");
					pedido.alterarValorParaPagamentoAVista(
							config.getValorParaDesconto(),
							quantidadeDeCaixas,
							config.getQuantidadeDeCaixasPromocao(),
							config.getPorcentagemDeDesconto());
				} else {
					pedido.acrescentaJuros(config.getPorcentagemDeAcrescimo());

				}

			}

			pedido.calculaLucroAReceber(config.getPorcentagemDeLucro());

			pedidos.add(pedido);

			System.out.println("============================================\n");
			System.out.println("Parabéns pela venda!!!\n\n");
			System.out.println("O lucro é de R$ " + pedido.getLucroAReceber());
			System.out.println("O valor total a cobrar do cliente é de R$ " + pedido.getValorTotalAlterado());
			System.out.println("O cliente escolheu o tipo de pagamento "
					+ (aVista ? "À vista" : "Parcelado em " + pedido.getParcelas() + " vezes."));
			if (aVista) {
				System.out
						.println("Para pagamento a vista demos o desconto dê R$ " + (pedido.valorDoDesconto()));
			} else {
				System.out.println(
						"Para pagamento parcelado colocamos um acréscimo de R$ " + (pedido.valorDoJuros()));
				System.out.println("o valor das parcelas será de R$ " + (pedido.valorDasParcelas()));
			}
			System.out.println(" ");
			System.out.println("============================================\n\n");

			for (int i = 0; i < pedidos.size(); i++) {
				Pedido p = pedidos.get(i);
				Cliente c = pedido.getCliente();
				System.out.println("============================================\n\n");
				System.out.println("Cliente: " + c.getNome());
				System.out.println("Quantidade de caixas: " + p.getQuantidadeDeCaixas());
				System.out.println("Valor total a pagar: " + p.getValorTotal());
				System.out.println("============================================\n\n");
			}
		}
		// SpringApplication.run(AppConsoleApplication.class, args);
	}

}
