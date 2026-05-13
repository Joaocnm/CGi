package view.cgi;

import java.awt.Color;
import java.awt.Font;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import modelo.cgi.Gastos;
import modelo.cgi.Investimento;
import modelo.cgi.Usuario;
import java.awt.Toolkit;

public class TelaHistorico extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel model;
	private Usuario userLogado;
	private JLabel lblRenda, lblGastos, lblInvestido, lblSaldo;

	public TelaHistorico(Usuario usuario) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Joao-PC\\Pictures\\icon\\cgi.jpg"));
		setTitle("Histórico");
		this.userLogado = usuario;

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		setResizable(false);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(13, 13, 13));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		//botões de filtrar 
		JButton btnTodos = new JButton("Todos");
		btnTodos.setBounds(50, 40, 100, 30);
		contentPane.add(btnTodos);

		JButton btnFixos = new JButton("Fixos");
		btnFixos.setBounds(160, 40, 100, 30);
		btnFixos.setBackground(new Color(255, 150, 0));
		contentPane.add(btnFixos);

		JButton btnVariaveis = new JButton("Variáveis");
		btnVariaveis.setBounds(270, 40, 100, 30);
		btnVariaveis.setBackground(new Color(255, 77, 77));
		contentPane.add(btnVariaveis);

		JButton btnMetas = new JButton("Metas");
		btnMetas.setBounds(380, 40, 100, 30);
		btnMetas.setBackground(new Color(96, 165, 250));
		contentPane.add(btnMetas);

		//tabela 
		String[] colunas = {"Tipo", "Categoria", "Descrição", "Valor", "Data"};
		model = new DefaultTableModel(colunas, 0) {
			@Override
			public boolean isCellEditable(int row, int column) { return false; }
		};
		
		table = new JTable(model);
		table.setBackground(new Color(25, 25, 25));
		table.setForeground(Color.WHITE);
		table.getTableHeader().setBackground(new Color(40, 40, 40));
		table.getTableHeader().setForeground(Color.WHITE);

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(50, 80, 700, 300);
		contentPane.add(scrollPane);

		
		lblRenda = new JLabel("Renda: R$ " + String.format(Locale.US, "%.2f", userLogado.getRendaMensal()));
		lblRenda.setForeground(Color.LIGHT_GRAY);
		lblRenda.setBounds(50, 400, 200, 20);
		contentPane.add(lblRenda);

		lblGastos = new JLabel("Total Gastos: R$ 0.00");
		lblGastos.setForeground(new Color(255, 77, 77));
		lblGastos.setBounds(250, 400, 200, 20);
		contentPane.add(lblGastos);

		lblInvestido = new JLabel("Total Investido: R$ 0.00");
		lblInvestido.setForeground(new Color(96, 165, 250));
		lblInvestido.setBounds(450, 400, 200, 20);
		contentPane.add(lblInvestido);

		lblSaldo = new JLabel("Saldo Final: R$ 0.00");
		lblSaldo.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblSaldo.setBounds(50, 435, 400, 30);
		contentPane.add(lblSaldo);

		
		JButton btnHome = new JButton("VOLTAR HOME");
		btnHome.setBounds(50, 500, 150, 40);
		contentPane.add(btnHome);
		btnHome.addActionListener(e -> { new TelaDashboard(userLogado).setVisible(true); dispose(); });

		
		btnTodos.addActionListener(e -> carregarTabela("Todos"));
		btnFixos.addActionListener(e -> carregarTabela("Fixo"));
		btnVariaveis.addActionListener(e -> carregarTabela("Variável"));
		btnMetas.addActionListener(e -> carregarTabela("Meta"));

		carregarTabela("Todos");
	}

	private void carregarTabela(String filtro) {
	    model.setRowCount(0);
	    double totalG = 0;
	    double totalI = 0;

	    for (Object obj : userLogado.historico) {
	        String tipo = "";
	        String cat = "";
	        String desc = "";
	        double valor = 0;
	        String data = "";
	        boolean fixo = false;
	        boolean add = false;

	        if (obj instanceof Gastos) {
	            Gastos g = (Gastos) obj;
	            tipo = "Gasto";
	            cat = g.getCategoria();
	            //gastos usa getDescricao() da classe mãe
	            desc = g.getDescricao(); 
	            valor = g.getValor();
	            data = (g.getData() != null) ? g.getData().toString() : "--/--/--";
	            fixo = g.getIsFixo();
	            totalG += valor;
	        } else if (obj instanceof Investimento) {
	            Investimento i = (Investimento) obj;
	            tipo = "Investimento";
	            cat = "Meta: " + i.getNomeMeta();
	            //investimento também herda getDescricao()
	            desc = i.getDescricao(); 
	            valor = i.getValor();
	            data = (i.getData() != null) ? i.getData().toString() : "--/--/--";
	            totalI += valor;
	        }

	        // Filtros
	        if (filtro.equals("Todos")) add = true;
	        else if (filtro.equals("Fixo") && tipo.equals("Gasto") && fixo) add = true;
	        else if (filtro.equals("Variável") && tipo.equals("Gasto") && !fixo) add = true;
	        else if (filtro.equals("Meta") && tipo.equals("Investimento")) add = true;

	        if (add) {
	            model.addRow(new Object[]{tipo, cat, desc, "R$ " + String.format(Locale.US, "%.2f", valor), data});
	        }
	    }

	    lblGastos.setText("Total Gastos: R$ " + String.format(Locale.US, "%.2f", totalG));
	    lblInvestido.setText("Total Investido: R$ " + String.format(Locale.US, "%.2f", totalI));
	    double saldo = userLogado.getRendaMensal() - totalG - totalI;
	    lblSaldo.setText("Saldo Final: R$ " + String.format(Locale.US, "%.2f", saldo));
	    lblSaldo.setForeground(saldo < 0 ? Color.RED : new Color(0, 230, 118));
	}}