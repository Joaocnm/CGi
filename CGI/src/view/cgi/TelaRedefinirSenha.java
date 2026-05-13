package view.cgi;

import java.awt.Color;
import java.awt.Font;

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

public class TelaRedefinirSenha extends JFrame {
    
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtEmail, txtNome, txtProfissao;
    private JPasswordField txtNovaSenha;

    public TelaRedefinirSenha() {
    	setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Joao-PC\\Pictures\\icon\\cgi.jpg"));
        setTitle("Recuperar Acesso");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 400, 480); 
        setLocationRelativeTo(null); 
        
        contentPane = new JPanel();
        contentPane.setBackground(new Color(13, 13, 13));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);
        setContentPane(contentPane);

        //logo cgi colorido
        JLabel lblLogoCGI = new JLabel("<html><font color='#FFFFFF'>C</font><font color='#00E676'>G</font><font color='#FFFFFF'>I</font></html>");
        lblLogoCGI.setFont(new Font("Tahoma", Font.BOLD, 35));
        lblLogoCGI.setBounds(150, 11, 100, 50);
        contentPane.add(lblLogoCGI);

        
        JLabel lblEmail = new JLabel("E-mail Cadastrado:");
        lblEmail.setBackground(new Color(232, 232, 232));
        lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblEmail.setForeground(new Color(232, 232, 232));
        lblEmail.setBounds(20, 70, 200, 20);
        contentPane.add(lblEmail);
        
        txtEmail = new JTextField();
        txtEmail.setForeground(new Color(34, 34, 34));
        txtEmail.setEnabled(true);
        txtEmail.setFont(new Font("Consolas", Font.PLAIN, 16));
        txtEmail.setBounds(20, 90, 340, 30);
        contentPane.add(txtEmail);
        txtEmail.setColumns(10);

        
        JLabel lblNome = new JLabel("Nome Completo:");
        lblNome.setBackground(new Color(232, 232, 232));
        lblNome.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNome.setForeground(new Color(232, 232, 232));
        lblNome.setBounds(20, 130, 200, 20);
        contentPane.add(lblNome);
        
        txtNome = new JTextField();
        txtNome.setForeground(new Color(34, 34, 34));
        txtNome.setFont(new Font("Consolas", Font.PLAIN, 16));
        txtNome.setBounds(20, 150, 340, 30);
        contentPane.add(txtNome);
        txtNome.setColumns(10);

        
        JLabel lblProfissao = new JLabel("Profissão Cadastrada:");
        lblProfissao.setBackground(new Color(232, 232, 232));
        lblProfissao.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblProfissao.setForeground(new Color(255, 255, 255));
        lblProfissao.setBounds(20, 190, 200, 20);
        contentPane.add(lblProfissao);
        
        txtProfissao = new JTextField();
        txtProfissao.setForeground(new Color(34, 34, 34));
        txtProfissao.setFont(new Font("Consolas", Font.PLAIN, 16));
        txtProfissao.setBounds(20, 210, 340, 30);
        contentPane.add(txtProfissao);
        txtProfissao.setColumns(10);
        
        
        JLabel lblNova = new JLabel("Nova Senha:");
        lblNova.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNova.setForeground(new Color(167, 139, 250));
        lblNova.setBounds(20, 260, 200, 20);
        contentPane.add(lblNova);
        
        txtNovaSenha = new JPasswordField();
        txtNovaSenha.setForeground(new Color(34, 34, 34));
        txtNovaSenha.setFont(new Font("Consolas", Font.PLAIN, 16));
        txtNovaSenha.setBounds(20, 280, 340, 30);
        contentPane.add(txtNovaSenha);

        
        JButton btnConfirmar = new JButton("COMFIRMAR");
        btnConfirmar.setFont(new Font("Tahoma", Font.BOLD, 10));
        btnConfirmar.setBackground(new Color(167, 139, 250));
        btnConfirmar.setBounds(120, 339, 160, 30);
        contentPane.add(btnConfirmar);

        //validação tripla de segurança
        btnConfirmar.addActionListener(e -> {
            String email = txtEmail.getText();
            String nome = txtNome.getText();
            String profissao = txtProfissao.getText();
            String novaS = new String(txtNovaSenha.getPassword());

            Usuario alvo = null;
          //aq ele vai buscar o usuario  
            for(Usuario u : Usuario.listaUsuarios) {
                if(u.getEmail().equals(email)) {
                    alvo = u;
                    break;
                }
            }

            //verifica se o usuário foi encontrado e se nome e profissão conferem
            if (alvo != null && alvo.getNome().equalsIgnoreCase(nome) && alvo.getProfissao().equalsIgnoreCase(profissao)) {
                
                //garante que a nova senha não é apenas espaços em branco
                if (!novaS.trim().isEmpty()) {
                    alvo.setSenha(novaS); // atualiza a senha do usuário encontrado
                    JOptionPane.showMessageDialog(null, "Identidade confirmada! Senha alterada com sucesso.");
                    dispose(); // fecha a tela atual após a alteração
                } else {
                    //impede senha vazia ou com só espaços
                    JOptionPane.showMessageDialog(null, "A nova senha não pode estar vazia.");
                }

            } else {
                //usuário não encontrado ou dados de confirmação incorretos
                JOptionPane.showMessageDialog(null, "Dados não conferem. Verifique as informações.");
            }
        });
    }
}