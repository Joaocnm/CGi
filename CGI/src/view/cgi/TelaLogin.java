package view.cgi;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import modelo.cgi.Usuario;
import java.awt.Toolkit;

public class TelaLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldeEmail;
	private JPasswordField passwordFieldSenha;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLogin frame = new TelaLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	} 

	public TelaLogin() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Joao-PC\\Pictures\\icon\\cgi.jpg"));
		setTitle("LOGIN");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		
		JButton JButtonCadastrar = new JButton("CADASTRAR");
		JButtonCadastrar.setForeground(new Color(0, 0, 0));
		JButtonCadastrar.setFont(new Font("Tahoma", Font.BOLD, 10));
		JButtonCadastrar.setBackground(new Color(255, 77, 77));
		JButtonCadastrar.setBounds(153, 411, 105, 33);
		JButtonCadastrar.setFocusPainted(false);
		contentPane.add(JButtonCadastrar);

		JButtonCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastro telaCad = new TelaCadastro();
				telaCad.setVisible(true);
				dispose();
			}
		});

		
		JButton JButtonLogin = new JButton("LOGIN");
		JButtonLogin.setFont(new Font("Tahoma", Font.BOLD, 10));
		JButtonLogin.setBackground(new Color(96, 165, 250));
		JButtonLogin.setBounds(534, 411, 105, 33);
		JButtonLogin.setFocusPainted(false);
		contentPane.add(JButtonLogin);

		JButtonLogin.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        String email = textFieldeEmail.getText();
		        String senha = new String(passwordFieldSenha.getPassword());
		        
		        Usuario usuarioLogado = null;

		        //procura usuario 
		        for (Usuario u : Usuario.listaUsuarios) {
		            if (u.getEmail().equals(email) && u.getSenha().equals(senha)) {
		                usuarioLogado = u; //acho mizera 
		                break;
		            }
		        }

		        //encontro avança p dashboard
		        if (usuarioLogado != null) {
		            new TelaDashboard(usuarioLogado).setVisible(true);
		            dispose(); //fecha tela login
		        } else {
		            JOptionPane.showMessageDialog(null, "E-mail ou Senha incorretos!");
		        }
		    }
		});
		
	
		JButton btnEsqueci = new JButton("Esqueci minha senha");
		btnEsqueci.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnEsqueci.setBounds(397, 349, 179, 20); // Coloque perto do campo de senha
		btnEsqueci.setContentAreaFilled(false);
		btnEsqueci.setBorderPainted(false);
		btnEsqueci.setForeground(new Color(167, 139, 250));
		contentPane.add(btnEsqueci);

		btnEsqueci.addActionListener(e -> {
		    new TelaRedefinirSenha().setVisible(true);
		});

		
		JLabel lblSaudacoes = new JLabel("Bem-vindo de volta ");
		lblSaudacoes.setBackground(new Color(240, 240, 240));
		lblSaudacoes.setForeground(new Color(255, 255, 255));
		lblSaudacoes.setFont(new Font("Trebuchet MS", Font.BOLD, 25));
		lblSaudacoes.setBounds(167, 160, 258, 26);
		contentPane.add(lblSaudacoes);

		JLabel lblEmail = new JLabel("E-MAIL ");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEmail.setBackground(new Color(232, 232, 232));
		lblEmail.setBounds(227, 215, 91, 12);
		lblEmail.setForeground(new Color(232, 232, 232));
		contentPane.add(lblEmail);

		JLabel lblSenha = new JLabel("SENHA ");
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSenha.setBackground(new Color(232, 232, 232));
		lblSenha.setBounds(227, 282, 83, 12);
		lblSenha.setForeground(new Color(232, 232, 232));
		contentPane.add(lblSenha);
		
		JLabel lblLogoCGI = new JLabel("<html><font color='#FFFFFF'>C</font><font color='#00E676'>G</font><font color='#FFFFFF'>I</font></html>");
		lblLogoCGI.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblLogoCGI.setBounds(167, 114, 155, 50);
		contentPane.add(lblLogoCGI);

		textFieldeEmail = new JTextField();
		textFieldeEmail.setForeground(new Color(34, 34, 34));
		textFieldeEmail.setFont(new Font("Consolas", Font.PLAIN, 16));
		textFieldeEmail.setBounds(227, 237, 331, 35);
		contentPane.add(textFieldeEmail);

		passwordFieldSenha = new JPasswordField();
		passwordFieldSenha.setForeground(new Color(34, 34, 34));
		passwordFieldSenha.setFont(new Font("Consolas", Font.PLAIN, 16));
		passwordFieldSenha.setBounds(227, 304, 331, 35);
		contentPane.add(passwordFieldSenha);

		JLabel lblBarraCGI = new JLabel("CGI - Controle de Gastos Investimento");
		lblBarraCGI.setForeground(new Color(96, 96, 96));
		lblBarraCGI.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblBarraCGI.setOpaque(true);
		lblBarraCGI.setBackground(new Color(20, 20, 20));
		lblBarraCGI.setBounds(0, 0, 786, 19);
		contentPane.add(lblBarraCGI);
		

		JLabel lblFaixada = new JLabel("");
		lblFaixada.setBackground(new Color(34, 34, 34));
		lblFaixada.setBounds(143, 93, 504, 308);
		contentPane.add(lblFaixada);
		lblFaixada.setOpaque(true);

		JLabel lblPlanoFundo = new JLabel("");
		lblPlanoFundo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPlanoFundo.setHorizontalAlignment(SwingConstants.TRAILING);
		lblPlanoFundo.setIcon(new ImageIcon("C:\\Users\\gihca\\Downloads\\imagem.telalogin.jpeg"));
		lblPlanoFundo.setBounds(-38, 10, 800, 761);
		contentPane.add(lblPlanoFundo);
	
	
	}
}	
			

