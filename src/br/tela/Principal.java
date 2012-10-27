package br.tela;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Label;
import java.awt.Color;
import br.unisal.Carro;
import br.unisal.Estacionamento;
import java.awt.TextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Date;
import javax.swing.JFormattedTextField;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

public class Principal extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JFormattedTextField EdtPlacaVeiculo;
	private Estacionamento estacionamento;
	private static Label lblVagasDisponiveis;
	private static TextArea edtResultados;
	private Label LblTotalCaixa;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Principal dialog = new Principal();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Principal() {
		estacionamento = new Estacionamento(5);

		iniciarComponentes();
	}

	private void iniciarComponentes() {
		prepararComponentes();

		setTitle("[P\u00D3S-UNISAL] - Programa\u00E7\u00E3o Orientada a Objetos I");
		setBounds(100, 100, 627, 453);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JButton BtnTotalCaixa = new JButton("Total no Caixa");
		BtnTotalCaixa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				totalCaixa();
			}
		});
		BtnTotalCaixa.setBounds(364, 353, 123, 23);
		contentPanel.add(BtnTotalCaixa);

		JButton BtnVagasDisponiveis = new JButton("Vagas Dispon\u00EDveis");

		BtnVagasDisponiveis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vagasDisponiveis();
			}
		});
		BtnVagasDisponiveis.setBounds(10, 352, 138, 23);
		contentPanel.add(BtnVagasDisponiveis);

		JLabel lblProjetoEstacionamento = new JLabel("Projeto Estacionamento");
		lblProjetoEstacionamento.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblProjetoEstacionamento.setBounds(177, 11, 249, 25);
		contentPanel.add(lblProjetoEstacionamento);

		Label label = new Label("===>");
		label.setFont(new Font("Dialog", Font.BOLD, 14));
		label.setBounds(154, 352, 38, 22);
		contentPanel.add(label);

		Label label_1 = new Label("===>");
		label_1.setFont(new Font("Dialog", Font.BOLD, 14));
		label_1.setBounds(493, 353, 38, 22);
		contentPanel.add(label_1);

		Label label_6 = new Label("Informe a Placa do Ve\u00EDculo:");
		label_6.setBounds(10, 63, 161, 22);
		contentPanel.add(label_6);

		JButton BtnRegistrarEntrada = new JButton("Registrar Entrada");
		BtnRegistrarEntrada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				registraEntrada();
			}
		});
		BtnRegistrarEntrada.setBounds(10, 125, 203, 23);
		contentPanel.add(BtnRegistrarEntrada);

		JButton BtnConsultarValorSaida = new JButton(
				"Consultar Valor na Sa\u00EDda");
		BtnConsultarValorSaida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				consultarValorSaida();
			}
		});
		BtnConsultarValorSaida.setBounds(10, 170, 203, 23);
		contentPanel.add(BtnConsultarValorSaida);

		JButton BtnConfirmarSaida = new JButton("Confirmar Sa\u00EDda");
		BtnConfirmarSaida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				confirmarSaida();
			}
		});
		BtnConfirmarSaida.setBounds(10, 215, 203, 23);
		contentPanel.add(BtnConfirmarSaida);

		JButton BtnConsultarHistoricoEntrada = new JButton(
				"Consultar Hor\u00E1rio de Entrada");
		BtnConsultarHistoricoEntrada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				consultarHistoricoEntrada();
			}
		});
		BtnConsultarHistoricoEntrada.setBounds(10, 260, 203, 23);
		contentPanel.add(BtnConsultarHistoricoEntrada);

		Label label_8 = new Label("* Utilize as Op\u00E7\u00F5es Abaixo.");
		label_8.setForeground(Color.RED);
		label_8.setBounds(280, 63, 153, 22);
		contentPanel.add(label_8);
		
		JButton BtnListarCarrosEstacionados = new JButton("Listar Carros Estacionados");
		BtnListarCarrosEstacionados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listarCarrosEstacionados();
			}
		});
		BtnListarCarrosEstacionados.setBounds(10, 305, 203, 23);
		contentPanel.add(BtnListarCarrosEstacionados);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBounds(10, 106, 591, 4);
		contentPanel.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.BLACK);
		separator_1.setBounds(10, 47, 591, 4);
		contentPanel.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setForeground(Color.BLACK);
		separator_2.setBounds(10, 343, 591, 4);
		contentPanel.add(separator_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setForeground(Color.BLACK);
		separator_3.setBounds(10, 381, 591, 4);
		contentPanel.add(separator_3);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnSair.setBounds(530, 385, 71, 23);
		contentPanel.add(btnSair);
		
		JButton btnCreditos = new JButton("Cr\u00E9ditos");
		btnCreditos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exibirCreditos();
			}
		});
		btnCreditos.setBounds(364, 387, 123, 23);
		contentPanel.add(btnCreditos);
	}

	private void prepararComponentes() {
		prepararLblVagas();
		prepararEdtResultados();
		prepararEdtPlacaVeiculo();
		prepararLblTotalCaixa();
	}

	private void prepararEdtResultados() {
		edtResultados = new TextArea();
		edtResultados.setBounds(219, 127, 382, 201);
		contentPanel.add(edtResultados);
	}

	private void prepararLblVagas() {
		lblVagasDisponiveis = new Label("");
		lblVagasDisponiveis.setForeground(Color.BLUE);
		lblVagasDisponiveis.setFont(new Font("Dialog", Font.BOLD, 14));
		lblVagasDisponiveis.setBounds(198, 353, 38, 22);
		contentPanel.add(lblVagasDisponiveis);
	}
	
	private void prepararLblTotalCaixa(){
		LblTotalCaixa = new Label();
		LblTotalCaixa.setForeground(Color.BLUE);
		LblTotalCaixa.setFont(new Font("Dialog", Font.BOLD, 14));
		LblTotalCaixa.setBounds(539, 353, 38, 22);
		contentPanel.add(LblTotalCaixa);	
	}
	
	private void prepararEdtPlacaVeiculo(){
		EdtPlacaVeiculo = new JFormattedTextField();
		EdtPlacaVeiculo.setHorizontalAlignment(SwingConstants.CENTER);
		EdtPlacaVeiculo.setFocusLostBehavior(JFormattedTextField.COMMIT);  
		EdtPlacaVeiculo.setBounds(177, 65, 86, 20);
		try {
			EdtPlacaVeiculo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("UUU-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
		
		contentPanel.add(EdtPlacaVeiculo);
	}

	private void registraEntrada() {
		if (permiteEntrada()) {
			Carro carro = new Carro(EdtPlacaVeiculo.getText());
			estacionamento.estacionar(carro);
			consultarHistoricoEntrada();
			limparPlaca();
			vagasDisponiveis();
		}
	}

	private boolean permiteEntrada() {
		if (verifcaSeTemVagaDisponivel() && verificaSeFoiInformadoPlaca()) {
			return true;
		}
		return false;
	}

	private boolean verifcaSeTemVagaDisponivel() {
		if (estacionamento.quantidadeVagasLivre() == 0) {
			edtResultados.setText("Não temos vaga disponivel!");
			return false;
		}
		return true;
	}

	private boolean verificaSeFoiInformadoPlaca() {
		String placa = EdtPlacaVeiculo.getText();
		if (placa.isEmpty() || placa.trim().equals("-")) {
			edtResultados.setText("Informe a placa do carro!");
			return false;
		}
		return true;
	}
	
	private boolean verificaSeEncontraCarro() {
		String placa = EdtPlacaVeiculo.getText();
		
		if (estacionamento.informacaoDoCarro(placa).isEmpty()) {
			edtResultados.setText("Carro com a placa " + placa + " não encontrado ");
			return false;
		}
		return true;
	}

	private void totalCaixa() {
		LblTotalCaixa.setText("" + this.estacionamento.getTotalRecebido());
	}

	private void vagasDisponiveis() {
		int vagasLivres = this.estacionamento.quantidadeVagasLivre();
		lblVagasDisponiveis.setText("" + vagasLivres);
	}

	private void consultarValorSaida() {
		if (verificaSeFoiInformadoPlaca() && verificaSeEncontraCarro()) {
			String info = this.estacionamento.informacaoDoCarro(EdtPlacaVeiculo
					.getText())
					+ "\nHora Atual: "
					+ new Date()
					+ "\nValor: "
					+ this.estacionamento
							.valorEstacionamentoCarro(EdtPlacaVeiculo.getText());

			edtResultados.setText(info);
		}
	}

	private void confirmarSaida() {
		if (verificaSeFoiInformadoPlaca() && verificaSeEncontraCarro()) {
			String info = this.estacionamento.sair(EdtPlacaVeiculo.getText());
			edtResultados.setText(info);
			
			this.limparPlaca();
			
			this.vagasDisponiveis();
			this.consultarValorSaida();
		}
	}

	private void consultarHistoricoEntrada() {
		if (verificaSeFoiInformadoPlaca() && verificaSeEncontraCarro()) {
			edtResultados.setText(this.estacionamento
					.informacaoDoCarro(EdtPlacaVeiculo.getText()));
		}
	}
	
	private void listarCarrosEstacionados() {
		this.limparPlaca();
		edtResultados.setText( this.estacionamento.listarCarrosEstacionados() );
	}
	
	private void limparPlaca(){
		EdtPlacaVeiculo.setText(null);
		EdtPlacaVeiculo.resetKeyboardActions();
	}
	
	private void exibirCreditos() {
		String info = "Responsáveis pela Elaboração:\n"
				    + "=========================\n"				    				    
				    + "\n"
				    + "Nome: Amauri Rodrigues dos Santos RA: 120005310\n"
				    + "Nome: Alexandre Luis Cella RA: 120006132\n"
				    + "Nome: Gustavo Henrique Assis RA: 110053547\n"
				    + "\n"
				    + "Curso: Engenharia de Software Orientado a Objetos\n"
				    + "Disciplina: Progração Orientada a Objetos I\n"
				    + "Professor: Eder Ignatowicz\n"
				    + "Versão 1.0";
		edtResultados.setText(info);
	}
}