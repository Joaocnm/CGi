package view.cgi;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import modelo.cgi.Gastos;
import modelo.cgi.Investimento;
import modelo.cgi.Usuario;
import java.awt.Toolkit;

public class TelaGerenciamento extends JFrame {
	private String dataHoje = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    private static final long serialVersionUID = 1L;
    private Usuario userLogado;
    private JPanel contentPane, panelCamposGasto, panelCamposMeta;
    private JTextField txtNomeGasto, txtValorGasto, txtNomeMeta, txtValorMeta, txtDataInicio, txtPrazoMeta;
    private JComboBox<String> cbTipoDef, cbDefinicaoLancar, cbMetasCriadas, cbExcluir;
    private JTextField txtDescricaoLancar, txtValorLancar, txtDataLancar;

    public TelaGerenciamento(Usuario u) {
    	setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Joao-PC\\Desktop\\CGI\\CGI.01\\bin\\imagens\\cgi\\cgi.jpg"));
        this.userLogado = u;
        setTitle("Gerenciamento");
        setBounds(100, 10, 950, 720); 
        setLocationRelativeTo(null);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(13, 13, 13));
        contentPane.setLayout(null);
        setContentPane(contentPane);

        //lado esquerdo (definir)
        JPanel panelDefinir = new JPanel();
        panelDefinir.setBounds(20, 10, 430, 520);
        panelDefinir.setBackground(new Color(20, 20, 20));
        panelDefinir.setBorder(new TitledBorder(new LineBorder(Color.WHITE), "DEFINIR", 0, 0, null, Color.WHITE));
        panelDefinir.setLayout(null);
        contentPane.add(panelDefinir);

        JLabel lblTipo = new JLabel("TIPO");
        lblTipo.setFont(new Font("Tahoma", Font.BOLD, 10));
        lblTipo.setForeground(Color.GRAY);
        lblTipo.setBounds(20, 30, 100, 20);
        panelDefinir.add(lblTipo);

        cbTipoDef = new JComboBox<>(new String[]{"Selecione...", "Gasto Fixo", "Meta"});
        cbTipoDef.setForeground(new Color(34, 34, 34));
        cbTipoDef.setBounds(20, 50, 390, 35);
        panelDefinir.add(cbTipoDef);

        //sub-painel do campo gasto
        panelCamposGasto = new JPanel();
        panelCamposGasto.setBorder(new TitledBorder(new LineBorder(new Color(0, 230, 118)), "CAMPOS DE GASTO", 0, 0, null, new Color(0, 230, 118)));
        panelCamposGasto.setBackground(new Color(25, 25, 25));
        panelCamposGasto.setBounds(20, 95, 390, 135);
        panelCamposGasto.setLayout(null);
        panelCamposGasto.setEnabled(false);
        panelDefinir.add(panelCamposGasto);

        JLabel lblDescGasto = new JLabel("DESCRIÇÃO *");
        lblDescGasto.setForeground(new Color(160, 160, 160));
        lblDescGasto.setFont(new Font("Tahoma", Font.BOLD, 10));
        lblDescGasto.setBounds(15, 15, 200, 20);
        panelCamposGasto.add(lblDescGasto);

        txtNomeGasto = new JTextField();
        txtNomeGasto.setForeground(new Color(34, 34, 34));
        txtNomeGasto.setFont(new Font("Consolas", Font.PLAIN, 16));
        txtNomeGasto.setBounds(15, 32, 360, 30);
        panelCamposGasto.add(txtNomeGasto);

        JLabel lblValGasto = new JLabel("VALOR (R$) *");
        lblValGasto.setForeground(new Color(160, 160, 160));
        lblValGasto.setFont(new Font("Tahoma", Font.BOLD, 10));
        lblValGasto.setBounds(15, 72, 200, 20);
        panelCamposGasto.add(lblValGasto);

        txtValorGasto = new JTextField();
        txtValorGasto.setForeground(new Color(34, 34, 34));
        txtValorGasto.setFont(new Font("Consolas", Font.PLAIN, 16));
        txtValorGasto.setBounds(15, 90, 150, 30);
        panelCamposGasto.add(txtValorGasto);

        //sub-pAainel do campo meta 
        panelCamposMeta = new JPanel();
        panelCamposMeta.setBorder(new TitledBorder(new LineBorder(new Color(96, 165, 250)), "CAMPOS DE META", 0, 0, null, new Color(96, 165, 250)));
        panelCamposMeta.setBackground(new Color(25, 25, 25));
        panelCamposMeta.setBounds(20, 240, 390, 200);
        panelCamposMeta.setLayout(null);
        panelDefinir.add(panelCamposMeta);

        JLabel lblNomeMeta = new JLabel("NOME DA META *");
        lblNomeMeta.setForeground(new Color(160, 160, 160));
        lblNomeMeta.setFont(new Font("Tahoma", Font.BOLD, 10));
        lblNomeMeta.setBounds(15, 25, 200, 20);
        panelCamposMeta.add(lblNomeMeta);

        txtNomeMeta = new JTextField();
        txtNomeMeta.setForeground(new Color(34, 34, 34));
        txtNomeMeta.setFont(new Font("Consolas", Font.PLAIN, 16));
        txtNomeMeta.setBounds(15, 45, 360, 30);
        panelCamposMeta.add(txtNomeMeta);

        JLabel lblValMeta = new JLabel("VALOR META");
        lblValMeta.setForeground(new Color(160, 160, 160));
        lblValMeta.setFont(new Font("Tahoma", Font.BOLD, 10));
        lblValMeta.setBounds(15, 85, 200, 20);
        panelCamposMeta.add(lblValMeta);

        txtValorMeta = new JTextField();
        txtValorMeta.setFont(new Font("Consolas", Font.PLAIN, 16));
        txtValorMeta.setForeground(new Color(34, 34, 34));
        txtValorMeta.setBounds(15, 105, 160, 30);
        panelCamposMeta.add(txtValorMeta);

        JLabel lblDtInicio = new JLabel("DT. INÍCIO");
        lblDtInicio.setForeground(new Color(160, 160, 160));
        lblDtInicio.setFont(new Font("Tahoma", Font.BOLD, 10));
        lblDtInicio.setBounds(200, 85, 200, 20);
        panelCamposMeta.add(lblDtInicio);
        txtDataInicio = new JTextField(dataHoje);

        txtDataInicio = new JTextField(dataHoje);
        txtDataInicio.setFont(new Font("Consolas", Font.PLAIN, 15));
        txtDataInicio.setForeground(new Color(34, 34, 34));
        txtDataInicio.setBounds(200, 105, 175, 30);
        panelCamposMeta.add(txtDataInicio);

        JLabel lblPrazo = new JLabel("PRAZO (OPCIONAL)");
        lblPrazo.setForeground(new Color(160, 160, 160));
        lblPrazo.setFont(new Font("Tahoma", Font.BOLD, 10));
        lblPrazo.setBounds(15, 140, 200, 20);
        panelCamposMeta.add(lblPrazo);

        txtPrazoMeta = new JTextField();
        txtPrazoMeta.setForeground(new Color(34, 34, 34));
        txtPrazoMeta.setFont(new Font("Consolas", Font.PLAIN, 15));
        txtPrazoMeta.setBounds(15, 160, 360, 30);
        panelCamposMeta.add(txtPrazoMeta);

        JButton btnSalvarDef = new JButton("+ Salvar Definição");
        btnSalvarDef.setBackground(new Color(0, 230, 118));
        btnSalvarDef.setBounds(20, 460, 390, 40);
        panelDefinir.add(btnSalvarDef);

        //lados direito (lançar)
        JPanel panelLancar = new JPanel();
        panelLancar.setBounds(480, 10, 430, 520);
        panelLancar.setBackground(new Color(20, 20, 20));
        panelLancar.setBorder(new TitledBorder(new LineBorder(Color.WHITE), "LANÇAR MOVIMENTAÇÃO", 0, 0, null, Color.WHITE));
        panelLancar.setLayout(null);
        contentPane.add(panelLancar);

        JLabel lblDefLancar = new JLabel("PARA QUAL DEFINIÇÃO?");
        lblDefLancar.setForeground(new Color(160, 160, 160));
        lblDefLancar.setFont(new Font("Tahoma", Font.BOLD, 10));
        lblDefLancar.setBounds(20, 30, 200, 20);
        panelLancar.add(lblDefLancar);

        cbDefinicaoLancar = new JComboBox<>(new String[]{"Gasto Variável", "Aporte em Meta"});
        cbDefinicaoLancar.setBounds(20, 50, 390, 35);
        panelLancar.add(cbDefinicaoLancar);

        JLabel lblMetaAporte = new JLabel("SELECIONE A META (CASO SEJA APORTE)");
        lblMetaAporte.setForeground(new Color(160, 160, 160));
        lblMetaAporte.setFont(new Font("Tahoma", Font.BOLD, 10));
        lblMetaAporte.setBounds(20, 100, 236, 20);
        panelLancar.add(lblMetaAporte);

        cbMetasCriadas = new JComboBox<>();
        cbMetasCriadas.setForeground(new Color(34, 34, 34));
        cbMetasCriadas.setFont(new Font("Consolas", Font.PLAIN, 16));
        cbMetasCriadas.setBounds(20, 120, 390, 35);
        cbMetasCriadas.setEnabled(false);
        panelLancar.add(cbMetasCriadas);

        JLabel lblDescLancar = new JLabel("DESCRIÇÃO");
        lblDescLancar.setForeground(new Color(160, 160, 160));
        lblDescLancar.setFont(new Font("Tahoma", Font.BOLD, 10));
        lblDescLancar.setBounds(20, 170, 200, 20);
        panelLancar.add(lblDescLancar);

        txtDescricaoLancar = new JTextField();
        txtDescricaoLancar.setForeground(new Color(34, 34, 34));
        txtDescricaoLancar.setFont(new Font("Consolas", Font.PLAIN, 16));
        txtDescricaoLancar.setBounds(20, 190, 390, 35);
        panelLancar.add(txtDescricaoLancar);

        JLabel lblValLancar = new JLabel("VALOR (R$) *");
        lblValLancar.setForeground(new Color(160, 160, 160));
        lblValLancar.setFont(new Font("Tahoma", Font.BOLD, 10));
        lblValLancar.setBounds(20, 240, 200, 20);
        panelLancar.add(lblValLancar);

        txtValorLancar = new JTextField();
        txtValorLancar.setForeground(new Color(34, 34, 34));
        txtValorLancar.setFont(new Font("Consolas", Font.PLAIN, 16));
        txtValorLancar.setBounds(20, 260, 180, 35);
        panelLancar.add(txtValorLancar);

        JLabel lblDataLancar = new JLabel("DATA *");
        lblDataLancar.setForeground(new Color(160, 160, 160));
        lblDataLancar.setFont(new Font("Tahoma", Font.BOLD, 10));
        lblDataLancar.setBounds(230, 240, 200, 20);
        panelLancar.add(lblDataLancar);
        txtDataInicio = new JTextField(dataHoje);

        txtDataLancar = new JTextField(dataHoje);
        txtDataLancar.setForeground(new Color(34, 34, 34));
        txtDataLancar.setFont(new Font("Consolas", Font.PLAIN, 15));
        txtDataLancar.setBounds(230, 260, 180, 35);
        panelLancar.add(txtDataLancar);

        JButton btnRegistrar = new JButton("✓ Registrar Lançamento");
        btnRegistrar.setBackground(new Color(0, 230, 118));
        btnRegistrar.setBounds(20, 320, 390, 45);
        panelLancar.add(btnRegistrar);

        //paineol lá em baixo : exclui 
        JPanel panelExcluir = new JPanel();
        panelExcluir.setBounds(20, 540, 890, 80);
        panelExcluir.setBackground(new Color(25, 25, 25));
        panelExcluir.setBorder(new TitledBorder(new LineBorder(Color.RED), "EXCLUIR DEFINIÇÕES", 0, 0, null, Color.RED));
        panelExcluir.setLayout(null);
        contentPane.add(panelExcluir);

        cbExcluir = new JComboBox<>();
        cbExcluir.setForeground(new Color(0, 0, 0));
        cbExcluir.setBounds(20, 30, 550, 35);
        panelExcluir.add(cbExcluir);

        JButton btnCarregar = new JButton("Carregar Itens");
        btnCarregar.setBounds(580, 30, 140, 35);
        panelExcluir.add(btnCarregar);

        JButton btnDeletar = new JButton("Excluir");
        btnDeletar.setBackground(new Color(255, 77, 77));
        btnDeletar.setBounds(730, 30, 140, 35);
        panelExcluir.add(btnDeletar);

      
        cbTipoDef.addActionListener(e -> {
            boolean isGasto = cbTipoDef.getSelectedIndex() == 1;
            boolean isMeta = cbTipoDef.getSelectedIndex() == 2;
            configurarPainel(panelCamposGasto, isGasto);
            configurarPainel(panelCamposMeta, isMeta);
        });

        cbDefinicaoLancar.addActionListener(e -> {
            boolean isAporte = cbDefinicaoLancar.getSelectedIndex() == 1;
            cbMetasCriadas.setEnabled(isAporte);
            if(isAporte) {
                cbMetasCriadas.removeAllItems();
                for(String m : userLogado.definicaoMetas) cbMetasCriadas.addItem(m);
            }
        });

        btnSalvarDef.addActionListener(e -> {
            if(cbTipoDef.getSelectedIndex() == 1) {
                String nome = txtNomeGasto.getText();
                String valor = txtValorGasto.getText().replace(",", ".");
                userLogado.definicaoGastosFixos.add(nome + ":" + valor);
                JOptionPane.showMessageDialog(null, "Gasto Fixo '" + nome + "' salvo!");
                txtNomeGasto.setText(""); txtValorGasto.setText("");
            } else if(cbTipoDef.getSelectedIndex() == 2) {
                userLogado.definicaoMetas.add(txtNomeMeta.getText());
                JOptionPane.showMessageDialog(null, "Meta '" + txtNomeMeta.getText() + "' criada!");
                txtNomeMeta.setText("");
            }
        });

        btnRegistrar.addActionListener(e -> {
            try {
                double valor = Double.parseDouble(txtValorLancar.getText().replace(",", "."));
                if(cbDefinicaoLancar.getSelectedIndex() == 1) {
                    String metaAlvo = cbMetasCriadas.getSelectedItem().toString();
                    userLogado.historico.add(new Investimento("Aporte " + metaAlvo, valor, java.time.LocalDate.now(), metaAlvo, 0, null, null));
                    JOptionPane.showMessageDialog(null, "Aporte registrado para " + metaAlvo);
                } else {
                    userLogado.historico.add(new Gastos(txtDescricaoLancar.getText(), valor, java.time.LocalDate.now(), "Variável", false));
                    JOptionPane.showMessageDialog(null, "Gasto variável lançado!");
                }
                txtValorLancar.setText(""); txtDescricaoLancar.setText("");
            } catch (Exception ex) { JOptionPane.showMessageDialog(null, "Erro nos dados."); }
        });

        btnCarregar.addActionListener(e -> {
            cbExcluir.removeAllItems();
            for(String g : userLogado.definicaoGastosFixos) cbExcluir.addItem("Gasto: " + g);
            for(String m : userLogado.definicaoMetas) cbExcluir.addItem("Meta: " + m);
        });

        btnDeletar.addActionListener(e -> {
            if(cbExcluir.getSelectedItem() != null) {
                String selecionado = cbExcluir.getSelectedItem().toString();
                if(selecionado.startsWith("Gasto: ")) userLogado.definicaoGastosFixos.remove(selecionado.replace("Gasto: ", ""));
                else userLogado.definicaoMetas.remove(selecionado.replace("Meta: ", ""));
                cbExcluir.removeItem(selecionado);
                JOptionPane.showMessageDialog(null, "Excluído com sucesso!");
            }
        });

        JButton btnVoltar = new JButton("Home");
        btnVoltar.setBounds(20, 630, 100, 30);
        contentPane.add(btnVoltar);
        btnVoltar.addActionListener(e -> { new TelaDashboard(userLogado).setVisible(true); dispose(); });
    }
    
    private void configurarPainel(JPanel p, boolean ativado) {
        p.setEnabled(ativado);
        
        //pega o título gasto ou meta 
        String titulo = ((TitledBorder)p.getBorder()).getTitle();
        Color corDestaque;

        if (titulo.contains("GASTO")) {
            corDestaque = ativado ? new Color(0, 230, 118) : new Color(60, 60, 60);
        } else {
            corDestaque = ativado ? new Color(96, 165, 250) : new Color(60, 60, 60);
        }

        //cordestaque no final para pintar a letrta do cabeçalho
        p.setBorder(new TitledBorder(
            new LineBorder(corDestaque), 
            titulo, 
            TitledBorder.LEADING, 
            TitledBorder.TOP, 
            null, 
            corDestaque 
        ));

        //mater o fundo escuro
        p.setBackground(new Color(25, 25, 25)); 

        for(Component c : p.getComponents()) {
            c.setEnabled(ativado);
        }
    }
}