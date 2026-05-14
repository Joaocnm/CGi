package view.cgi;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import modelo.cgi.Usuario;
import java.awt.Toolkit;

public class TelaCadastro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldNome, textFieldApelido, textFieldProfissao, textFieldRenda, textFieldEmail;
	private JPasswordField passwordFieldSenha;

	public TelaCadastro() {
		setTitle("Cadastro");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Joao-PC\\Desktop\\CGI\\CGI.01\\bin\\imagens\\cgi\\cgi.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		setResizable(false);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(13, 13, 13));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

	
		JLabel lblLogoCGI = new JLabel("<html><font color='#FFFFFF'>C</font><font color='#00E676'>G</font><font color='#FFFFFF'>I</font></html>");
		lblLogoCGI.setFont(new Font("Tahoma", Font.BOLD, 36));
		lblLogoCGI.setBounds(29, 20, 155, 50); 
		contentPane.add(lblLogoCGI);

		JLabel lblFrase1 = new JLabel("controle de gastos e investimento");
		lblFrase1.setForeground(new Color(240, 240, 240));
		lblFrase1.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblFrase1.setBounds(29, 53, 250, 40);
		contentPane.add(lblFrase1);

		JLabel lblDesc = new JLabel("<html>Crie sua conta e comece a<br>controlar suas finanças hoje!</html>");
		lblDesc.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblDesc.setForeground(new Color(240, 240, 240));
		lblDesc.setBounds(559, 43, 217, 40);
		contentPane.add(lblDesc);

		
				JLabel lblCriarConta = new JLabel("Criar conta");
				lblCriarConta.setFont(new Font("Trebuchet MS", Font.BOLD, 27));
				lblCriarConta.setForeground(new Color(0, 230, 118));
				lblCriarConta.setBounds(400, 43, 200, 42);
				contentPane.add(lblCriarConta);

				int xLabel = 400;
				int larguraField = 330;

				
				JLabel lblNome = new JLabel("NOME COMPLETO");
				lblNome.setBackground(new Color(232, 232, 232));
				lblNome.setForeground(new Color(232, 232, 232));
				lblNome.setFont(new Font("Tahoma", Font.PLAIN, 13));
				lblNome.setBounds(xLabel, 100, 200, 20);
				contentPane.add(lblNome);
				
				textFieldNome = new JTextField();
				textFieldNome.setFont(new Font("Consolas", Font.PLAIN, 16));
				textFieldNome.setForeground(new Color(34, 34, 34));
				textFieldNome.setBounds(xLabel, 120, larguraField, 30);
				contentPane.add(textFieldNome);

			
				JLabel lblApelido = new JLabel("APELIDO (OPCIONAL)");
				lblApelido.setBackground(new Color(232, 232, 232));
				lblApelido.setForeground(new Color(232, 232, 232));
				lblApelido.setFont(new Font("Tahoma", Font.PLAIN, 13));
				lblApelido.setBounds(xLabel, 160, 200, 20);
				contentPane.add(lblApelido);
				
				textFieldApelido = new JTextField();
				textFieldApelido.setFont(new Font("Consolas", Font.PLAIN, 16));
				textFieldApelido.setForeground(new Color(34, 34, 34));
				textFieldApelido.setBounds(xLabel, 180, larguraField, 30);
				contentPane.add(textFieldApelido);

			
				JLabel lblProfissao = new JLabel("PROFISSÃO");
				lblProfissao.setBackground(new Color(232, 232, 232));
				lblProfissao.setForeground(new Color(232, 232, 232));
				lblProfissao.setFont(new Font("Tahoma", Font.PLAIN, 13));
				lblProfissao.setBounds(xLabel, 220, 200, 20);
				contentPane.add(lblProfissao);
				
				textFieldProfissao = new JTextField();
				textFieldProfissao.setFont(new Font("Consolas", Font.PLAIN, 16));
				textFieldProfissao.setForeground(new Color(34, 34, 34));
				textFieldProfissao.setBounds(xLabel, 240, larguraField, 30);
				contentPane.add(textFieldProfissao);

				JLabel lblRenda = new JLabel("RENDA MENSAL (R$)");
				lblRenda.setBackground(new Color(232, 232, 232));
				lblRenda.setForeground(new Color(232, 232, 232));
				lblRenda.setFont(new Font("Tahoma", Font.PLAIN, 13));
				lblRenda.setBounds(xLabel, 280, 200, 20);
				contentPane.add(lblRenda);
				
				textFieldRenda = new JTextField();
				textFieldRenda.setForeground(new Color(34, 34, 34));
				textFieldRenda.setFont(new Font("Consolas", Font.PLAIN, 16));
				textFieldRenda.setBounds(xLabel, 300, larguraField, 30);
				contentPane.add(textFieldRenda);

				
				JLabel lblEmail = new JLabel("EMAIL");
				lblEmail.setBackground(new Color(232, 232, 232));
				lblEmail.setForeground(new Color(232, 232, 232));
				lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 13));
				lblEmail.setBounds(xLabel, 340, 200, 20);
				contentPane.add(lblEmail);
				
				textFieldEmail = new JTextField();
				textFieldEmail.setForeground(new Color(34, 34, 34));
				textFieldEmail.setFont(new Font("Consolas", Font.PLAIN, 16));
				textFieldEmail.setBounds(xLabel, 360, larguraField, 30);
				contentPane.add(textFieldEmail);

				
				JLabel lblSenha = new JLabel("SENHA");
				lblSenha.setForeground(new Color(232, 232, 232));
				lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 13));
				lblSenha.setBounds(xLabel, 400, 200, 20);
				contentPane.add(lblSenha);
				
				passwordFieldSenha = new JPasswordField();
				passwordFieldSenha.setForeground(new Color(34, 34, 34));
				passwordFieldSenha.setFont(new Font("Consolas", Font.PLAIN, 16));
				passwordFieldSenha.setBounds(xLabel, 420, larguraField, 30);
				contentPane.add(passwordFieldSenha);
		
		JButton btnCadastrar = new JButton("Finalizar Cadastro");
		btnCadastrar.setBackground(new Color(0, 230, 118));
		btnCadastrar.setForeground(new Color(0, 0, 0));
		btnCadastrar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCadastrar.setBounds(400, 480, 160, 35);
		contentPane.add(btnCadastrar);
		btnCadastrar.setBorderPainted(false);
		btnCadastrar.setFocusPainted(false);
		btnCadastrar.setContentAreaFilled(true);

		JButton btnVoltar = new JButton("Voltar ao login");
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnVoltar.setBounds(570, 480, 160, 35);
		contentPane.add(btnVoltar);
		
		JLabel lblWillSmith = new JLabel("");
		lblWillSmith.setIcon(new ImageIcon("C:\\Users\\Joao-PC\\Desktop\\CGI\\CGI.01\\bin\\imagens\\cgi\\will smith.png"));
		lblWillSmith.setBounds(-28, 35, 532, 630);
		contentPane.add(lblWillSmith);

		
		btnCadastrar.addActionListener(e -> {
			try {
				String nome = textFieldNome.getText();
				String apelido = textFieldApelido.getText();
				String profissao = textFieldProfissao.getText();
				String email = textFieldEmail.getText();
				String senha = new String(passwordFieldSenha.getPassword());
				double renda = Double.parseDouble(textFieldRenda.getText());

				// Cria o novo usuário com os dados preenchidos
				Usuario novoUser = new Usuario(email, senha, nome, apelido, profissao, renda);
				// Adiciona o usuário à lista estática compartilhada
				Usuario.listaUsuarios.add(novoUser);

				JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");
				new TelaLogin().setVisible(true);
				dispose();
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Erro: Verifique os dados (Renda deve ser número).");
			}
		});

		btnVoltar.addActionListener(e -> {
			btnVoltar.setBorderPainted(false);
			btnVoltar.setFocusPainted(false);
			btnVoltar.setContentAreaFilled(true);
			new TelaLogin().setVisible(true);
			dispose();
		});
	}
}