package view.cgi;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.Locale;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;

import modelo.cgi.Gastos;
import modelo.cgi.Investimento;
import modelo.cgi.Usuario;
import java.awt.Toolkit;

public class TelaDashboard extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblOláNome, lblRendaValor, lblSaldoValor, lblGastosValor, lblInvestidoValor;
	private JPanel panelGastosFixos;
	private Usuario userLogado;

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				// Usuário de teste com renda de 5000.00
				Usuario teste = new Usuario("teste@email.com", "123", "Usuário Teste", "Gih", "Dev", 5000.0);
				new TelaDashboard(teste).setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	public TelaDashboard(Usuario usuario) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Joao-PC\\Pictures\\icon\\cgi.jpg"));
		setTitle("Dashboard");
		this.userLogado = usuario;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		setResizable(false);
		setLocationRelativeTo(null);

		contentPane = new JPanel();
		contentPane.setBackground(new Color(13, 13, 13));
		contentPane.setBorder(new MatteBorder(0, 0, 1, 0, Color.DARK_GRAY));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblOláNome = new JLabel("Olá, " + userLogado.getComoChamar());
		lblOláNome.setFont(new Font("Trebuchet MS", Font.PLAIN, 27));
		lblOláNome.setForeground(Color.WHITE);
		lblOláNome.setBounds(40, 50, 400, 40);
		contentPane.add(lblOláNome);

		
		lblRendaValor = new JLabel("Renda Mensal: R$ " + String.format(Locale.US, "%.2f", userLogado.getRendaMensal()));
		lblRendaValor.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblRendaValor.setForeground(new Color(240, 240, 240));
		lblRendaValor.setBounds(40, 90, 300, 20);
		contentPane.add(lblRendaValor);

		
		JPanel panelSaldo = new JPanel();
		panelSaldo.setBackground(new Color(25, 25, 25));
		panelSaldo.setBounds(40, 140, 320, 150);
		panelSaldo.setLayout(null);
		panelSaldo.setBorder(new TitledBorder(new LineBorder(new Color(0, 230, 118)), "SALDO ATUAL", 0, 0, null, new Color(0, 230, 118)));
		contentPane.add(panelSaldo);

		lblSaldoValor = new JLabel("R$ 0.00");
		lblSaldoValor.setForeground(new Color(0, 230, 118));
		lblSaldoValor.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblSaldoValor.setBounds(20, 50, 280, 50);
		panelSaldo.add(lblSaldoValor);

		
		JPanel panelResumo = new JPanel();
		panelResumo.setBackground(new Color(25, 25, 25));
		panelResumo.setBounds(40, 310, 320, 150);
		panelResumo.setLayout(null);
		panelResumo.setBorder(new TitledBorder(new LineBorder(Color.GRAY), "RESUMO FINANCEIRO", 0, 0, null, Color.GRAY));
		contentPane.add(panelResumo);

		JLabel lblG = new JLabel("TOTAL GASTOS");
		lblG.setForeground(new Color(255, 77, 77));
		lblG.setBounds(20, 30, 120, 20);
		panelResumo.add(lblG);

		lblGastosValor = new JLabel("R$ 0.00");
		lblGastosValor.setForeground(new Color(255, 77, 77));
		lblGastosValor.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblGastosValor.setBounds(20, 50, 120, 30);
		panelResumo.add(lblGastosValor);

		JLabel lblI = new JLabel("TOTAL INVESTIDO");
		lblI.setForeground(new Color(96, 165, 250));
		lblI.setBounds(160, 30, 140, 20);
		panelResumo.add(lblI);

		lblInvestidoValor = new JLabel("R$ 0.00");
		lblInvestidoValor.setForeground(new Color(96, 165, 250));
		lblInvestidoValor.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblInvestidoValor.setBounds(160, 50, 140, 30);
		panelResumo.add(lblInvestidoValor);

		
		panelGastosFixos = new JPanel();
		panelGastosFixos.setBackground(new Color(25, 25, 25));
		// boxLayout deixa um embaixo do outro
		panelGastosFixos.setLayout(new BoxLayout(panelGastosFixos, BoxLayout.Y_AXIS));

		JScrollPane scrollPane = new JScrollPane(panelGastosFixos);
		scrollPane.setBounds(400, 140, 360, 320);
		scrollPane.setBorder(new TitledBorder(new LineBorder(Color.DARK_GRAY), "GASTOS FIXOS", 0, 0, null, Color.WHITE));
		contentPane.add(scrollPane);

		//carrega os dados e atualiza os números da tela
		carregarGastosFixos();
		atualizarSaldosETotais();

		
		JButton btnMovimentacao = new JButton("LANÇAR MOVIMENTAÇÃO");
		btnMovimentacao.setBackground(new Color(0, 230, 118));
		btnMovimentacao.setBounds(40, 480, 220, 45);
		contentPane.add(btnMovimentacao);
		btnMovimentacao.addActionListener(e -> {
			new TelaGerenciamento(userLogado).setVisible(true);
			dispose();
		});

		JButton btnHistorico = new JButton("HISTÓRICO");
		btnHistorico.setBounds(270, 480, 160, 45);
		contentPane.add(btnHistorico);
		btnHistorico.addActionListener(e -> {
		    // Abre a tela de histórico passando os dados do usuário
		    new TelaHistorico(userLogado).setVisible(true);
		    dispose(); // Fecha a Dashboard para não acumular janelas
		});

		JButton btnSair = new JButton("SAIR");
		btnSair.setBackground(new Color(255, 77, 77));
		btnSair.setBounds(620, 480, 120, 45);
		contentPane.add(btnSair);
		btnSair.addActionListener(e -> { new TelaLogin().setVisible(true); dispose(); });
	}

	private void carregarGastosFixos() {
		panelGastosFixos.removeAll();
		if (userLogado.definicaoGastosFixos != null) {
			for (String itemStr : userLogado.definicaoGastosFixos) {
				// Tenta separar Nome:Valor. Se não tiver ':', assume valor 0
				String[] partes = itemStr.split(":");
				String nomeGasto = partes[0];
				double valorGasto = (partes.length > 1) ? Double.parseDouble(partes[1]) : 0.0;

				JCheckBox chk = new JCheckBox(nomeGasto + " (R$ " + String.format(Locale.US, "%.2f", valorGasto) + ")");
				chk.setForeground(Color.LIGHT_GRAY);
				chk.setOpaque(false);
				chk.setFont(new Font("Tahoma", Font.PLAIN, 15));
				chk.setAlignmentX(Component.LEFT_ALIGNMENT);

				chk.addActionListener(e -> {
					if (chk.isSelected()) {
						// AUTOMÁTICO: Adiciona ao histórico usando o valor já guardado
						userLogado.historico.add(new Gastos(nomeGasto, valorGasto, java.time.LocalDate.now(), "Fixo", true));
						atualizarSaldosETotais();
						chk.setForeground(new Color(0, 230, 118)); // Feedback verde
					}
				});
				panelGastosFixos.add(chk);
				panelGastosFixos.add(Box.createRigidArea(new Dimension(0, 5))); // Espaço entre itens
			}
		}
		panelGastosFixos.revalidate();
		panelGastosFixos.repaint();
	}

	private void atualizarSaldosETotais() {
		double somaGastos = 0;
		double somaInvestido = 0;

		// Percorre o histórico real do usuário
		for (Object item : userLogado.historico) {
			if (item instanceof Gastos) {
				somaGastos += ((Gastos) item).getValor();
			} else if (item instanceof Investimento) {
				somaInvestido += ((Investimento) item).getValor();
			}
		}

		// Atualiza as Labels com Locale.US para garantir que 3000 não vire 3.00
		lblGastosValor.setText("R$ " + String.format(Locale.US, "%.2f", somaGastos));
		lblInvestidoValor.setText("R$ " + String.format(Locale.US, "%.2f", somaInvestido));

		double saldoFinal = userLogado.getRendaMensal() - somaGastos - somaInvestido;
		lblSaldoValor.setText("R$ " + String.format(Locale.US, "%.2f", saldoFinal));
		
		// Cor do Saldo (Verde se positivo, Vermelho se negativo)
		lblSaldoValor.setForeground(saldoFinal < 0 ? new Color(255, 77, 77) : new Color(0, 230, 118));
	}
}