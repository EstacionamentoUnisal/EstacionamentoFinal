package br.unisal;

import java.io.*;
import java.util.Date;

public class Menu {
	private BufferedReader dado;
	private Estacionamento estacionamento;

	// Construtor
	public Menu() {
		this.dado = new BufferedReader(new InputStreamReader(System.in));
		this.estacionamento = new Estacionamento(5);
	}

	// Inicia a aplicacao
	public static void main(String[] args) throws IOException {
		Menu aplicacao = new Menu();

		aplicacao.chamaMenuInicial();
	}

	public void chamaMenuInicial() {
		System.out.println("Projeto Estacionamento:\n"
				         + "======= ===============\n"
				         + "\n"
				         + "1 - Consultar se há vagas\n"
  				         + "2 - Registrar entrada do veículo\n"
				         + "3 - Consultar valor na saída do veículo\n"
				         + "4 - Confirmar a saída\n"
				         + "5 - Consultar horário de entrada do veículo\n"
				         + "6 - Consultar valor total no caixa\n" 
				         + "0 - Sair\n"
				         + "\nDigite o número da opção:");

		String selecionada = this.lerTeclado();

		this.executaOpcao(selecionada);
	}

	private void executaOpcao(String selecionada) {
		int opcao = -1;
		try {
			opcao = Integer.parseInt(selecionada);
		} 
		catch (Exception e) {
		}

		switch (opcao) {
		case 0:
			break;
		case 1:
			this.consultarVagasLivres();
			break;
		case 2:
			this.registrarEntradaCarro();
			break;
		case 3:
			this.consultarValorSaida();
			break;
		case 4:
			this.confirmarSaida();
			break;
		case 5:
			this.consultarHorarioEntradaVeiculo();
			break;
		case 6:
			this.consultarValorTotalCaixa();
			break;
		default:
			System.out.println("\nAtenção opção Inválida!");
		}

		if (opcao != 0) {
			System.out.println("\nPressione <ENTER> para continuar... \n");
			this.lerTeclado();

			this.chamaMenuInicial();
		}
	}

	private void consultarVagasLivres() {		
		int vagasLivres = this.estacionamento.quantidadeVagasLivre();

		System.out.println("\nVagas livres: " + vagasLivres);
	}

	private void registrarEntradaCarro() {
		// registra a entrada através da placa do veículo
		System.out.println("\nDigite a placa do veículo:");
		String placa = this.lerTeclado();

		// variável placa guarda a placa do veículo que entrou
		Carro uno10 = new Carro(placa);
		estacionamento.estacionar(uno10);

		System.out.println("\n" + this.estacionamento.informacaoDoCarro(placa));
	}

	private void consultarValorSaida() {
		// consulta o valor através da placa do veículo
		System.out.println("\nDigite a placa do veículo:");
		String placa = this.lerTeclado();

		String info = this.estacionamento.informacaoDoCarro(placa)
				+ "\nHora Atual: " + new Date() + "\nValor: "
				+ this.estacionamento.valorEstacionamentoCarro(placa);

		// this.estacionamento.
		System.out.println(info);
	}
	
	private void confirmarSaida() {
		System.out.println("\nDigite a placa do veículo:");
		String placa = this.lerTeclado();
		
		String info = this.estacionamento.sair(placa);

		System.out.println(info);
	}
	
	private void consultarHorarioEntradaVeiculo() {
		// registra a entrada através da placa do veículo
		System.out.println("\nDigite a placa do veículo:");
		String placa = this.lerTeclado();

		System.out.println("\n" + this.estacionamento.informacaoDoCarro(placa));
	}

	private void consultarValorTotalCaixa() {
		System.out.println("\nConsulta valor total no caixa");
		System.out.println("\nValor total: "
				+ this.estacionamento.getTotalRecebido());
	}

	private String lerTeclado() {
		String linha = "";

		try {
			linha = this.dado.readLine();

		} catch (Exception e) {
			System.out.println("Erro: " + e);
		}
		return linha;
	}
}