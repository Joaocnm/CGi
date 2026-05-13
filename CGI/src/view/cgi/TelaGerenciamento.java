package view.cgi;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

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
    private static final long serialVersionUID = 1L;
    private Usuario userLogado;
    private JPanel contentPane, panelCamposGasto, panelCamposMeta;
    private JTextField txtNomeGasto, txtValorGasto, txtNomeMeta, txtValorMeta, txtDataInicio, txtPrazoMeta;
    private JComboBox<String> cbTipoDef, cbDefinicaoLancar, cbMetasCriadas, cbExcluir;
    private JTextField txtDescricaoLancar, txtValorLancar, txtDataLancar;

    public TelaGerenciamento(Usuario u) {
    	setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Joao-PC\\Pictures\\icon\\cgi.jpg"));
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
        panelDefinir.setBounds(20, 30, 430, 520);
        panelDefinir.setBackground(new Color(20, 20, 20));
        panelDefinir.setBorder(new TitledBorder(new LineBorder(Color.WHITE), "DEFINIR", 0, 0, null, Color.WHITE));
        panelDefinir.setLayout(null);
        contentPane.add(panelDefinir);

        JLabel lblTipo = new JLabel("TIPO");
        lblTipo.setForeground(Color.GRAY);
        lblTipo.setBounds(20, 30, 100, 20);
        panelDefinir.add(lblTipo);

        cbTipoDef = new JComboBox<>(new String[]{"Selecione...", "Gasto Fixo", "Meta"});
        cbTipoDef.setBounds(20, 50, 390, 35);
        panelDefinir.add(cbTipoDef);

        //sub-painel do campo gasto
        panelCamposGasto = new JPanel();
        panelCamposGasto.setBorder(new TitledBorder(new LineBorder(new Color(0, 230, 118)), "CAMPOS DE GASTO", 0, 0, null, new Color(0, 230, 118)));
        panelCamposGasto.setBackground(new Color(25, 25, 25));
        panelCamposGasto.setBounds(20, 100, 390, 130);
        panelCamposGasto.setLayout(null);
        panelCamposGasto.setEnabled(false);
        panelDefinir.add(panelCamposGasto);

        adicionarLabel("DESCRIÇÃO *", 15, 25, panelCamposGasto);
        txtNomeGasto = new JTextField();
        txtNomeGasto.setBounds(15, 45, 360, 30);
        panelCamposGasto.add(txtNomeGasto);

        adicionarLabel("VALOR (R$) *", 15, 80, panelCamposGasto);
        txtValorGasto = new JTextField();
        txtValorGasto.setBounds(15, 100, 150, 30);
        panelCamposGasto.add(txtValorGasto);

        //sub-pAainel do campo meta 
        panelCamposMeta = new JPanel();
        panelCamposMeta.setBorder(new TitledBorder(new LineBorder(new Color(96, 165, 250)), "CAMPOS DE META", 0, 0, null, new Color(96, 165, 250)));
        panelCamposMeta.setBackground(new Color(25, 25, 25));
        panelCamposMeta.setBounds(20, 240, 390, 200);
        panelCamposMeta.setLayout(null);
        panelDefinir.add(panelCamposMeta);

        adicionarLabel("NOME DA META *", 15, 25, panelCamposMeta);
        txtNomeMeta = new JTextField();
        txtNomeMeta.setBounds(15, 45, 360, 30);
        panelCamposMeta.add(txtNomeMeta);

        adicionarLabel("VALOR META", 15, 85, panelCamposMeta);
        txtValorMeta = new JTextField();
        txtValorMeta.setBounds(15, 105, 160, 30);
        panelCamposMeta.add(txtValorMeta);

        adicionarLabel("DT. INÍCIO", 200, 85, panelCamposMeta);
        txtDataInicio = new JTextField("10/05/2026");
        txtDataInicio.setBounds(200, 105, 175, 30);
        panelCamposMeta.add(txtDataInicio);

        adicionarLabel("PRAZO (OPCIONAL)", 15, 140, panelCamposMeta);
        txtPrazoMeta = new JTextField();
        txtPrazoMeta.setBounds(15, 160, 360, 30);
        panelCamposMeta.add(txtPrazoMeta);

        JButton btnSalvarDef = new JButton("+ Salvar Definição");
        btnSalvarDef.setBackground(new Color(0, 230, 118));
        btnSalvarDef.setBounds(20, 460, 390, 40);
        panelDefinir.add(btnSalvarDef);

        //lados direito (lançar)
        JPanel panelLancar = new JPanel();
        panelLancar.setBounds(480, 30, 430, 520);
        panelLancar.setBackground(new Color(20, 20, 20));
        panelLancar.setBorder(new TitledBorder(new LineBorder(Color.WHITE), "LANÇAR MOVIMENTAÇÃO", 0, 0, null, Color.WHITE));
        panelLancar.setLayout(null);
        contentPane.add(panelLancar);

        adicionarLabel("PARA QUAL DEFINIÇÃO?", 20, 30, panelLancar);
        cbDefinicaoLancar = new JComboBox<>(new String[]{"Gasto Variável", "Aporte em Meta"});
        cbDefinicaoLancar.setBounds(20, 50, 390, 35);
        panelLancar.add(cbDefinicaoLancar);

        adicionarLabel("SELECIONE A META (CASO SEJA APORTE)", 20, 100, panelLancar);
        cbMetasCriadas = new JComboBox<>();
        cbMetasCriadas.setBounds(20, 120, 390, 35);
        cbMetasCriadas.setEnabled(false);
        panelLancar.add(cbMetasCriadas);

        adicionarLabel("DESCRIÇÃO", 20, 170, panelLancar);
        txtDescricaoLancar = new JTextField();
        txtDescricaoLancar.setBounds(20, 190, 390, 35);
        panelLancar.add(txtDescricaoLancar);

        adicionarLabel("VALOR (R$) *", 20, 240, panelLancar);
        txtValorLancar = new JTextField();
        txtValorLancar.setBounds(20, 260, 180, 35);
        panelLancar.add(txtValorLancar);

        adicionarLabel("DATA *", 230, 240, panelLancar);
        txtDataLancar = new JTextField("10/05/2026");
        txtDataLancar.setBounds(230, 260, 180, 35);
        panelLancar.add(txtDataLancar);

        JButton btnRegistrar = new JButton("✓ Registrar Lançamento");
        btnRegistrar.setBackground(new Color(0, 230, 118));
        btnRegistrar.setBounds(20, 320, 390, 45);
        panelLancar.add(btnRegistrar);

        //paineol lá em baixo : exclui 
        JPanel panelExcluir = new JPanel();
        panelExcluir.setBounds(20, 560, 890, 80);
        panelExcluir.setBackground(new Color(25, 25, 25));
        panelExcluir.setBorder(new TitledBorder(new LineBorder(Color.RED), "EXCLUIR DEFINIÇÕES", 0, 0, null, Color.RED));
        panelExcluir.setLayout(null);
        contentPane.add(panelExcluir);

        cbExcluir = new JComboBox<>();
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
            if(cbTipoDef.getSelectedIndex() == 1) { //gasto fixo aq
                String nome = txtNomeGasto.getText();
                String valor = txtValorGasto.getText().replace(",", ".");
                userLogado.definicaoGastosFixos.add(nome + ":" + valor); //ai salva c valor junto
                JOptionPane.showMessageDialog(null, "Gasto Fixo '" + nome + "' salvo!");
                txtNomeGasto.setText(""); txtValorGasto.setText("");
            } else if(cbTipoDef.getSelectedIndex() == 2) { //meta
                userLogado.definicaoMetas.add(txtNomeMeta.getText());
                JOptionPane.showMessageDialog(null, "Meta '" + txtNomeMeta.getText() + "' criada!");
                txtNomeMeta.setText("");
            }
        });

        btnRegistrar.addActionListener(e -> {
            try {
                double valor = Double.parseDouble(txtValorLancar.getText().replace(",", "."));
                if(cbDefinicaoLancar.getSelectedIndex() == 1) { //meta
                    String metaAlvo = cbMetasCriadas.getSelectedItem().toString();
                    userLogado.historico.add(new Investimento("Aporte " + metaAlvo, valor, java.time.LocalDate.now(), metaAlvo, 0, null, null));
                    JOptionPane.showMessageDialog(null, "Aporte registrado para " + metaAlvo);
                } else { //variavel
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
        btnVoltar.setBounds(20, 650, 100, 30);
        contentPane.add(btnVoltar);
        btnVoltar.addActionListener(e -> { new TelaDashboard(userLogado).setVisible(true); dispose(); });
    }

    private void adicionarLabel(String texto, int x, int y, JPanel p) {
        JLabel l = new JLabel(texto);
        l.setForeground(Color.GRAY);
        l.setFont(new Font("Tahoma", Font.BOLD, 10));
        l.setBounds(x, y, 200, 20);
        p.add(l);
    }

    private void configurarPainel(JPanel p, boolean ativado) {
        p.setEnabled(ativado);
        for(Component c : p.getComponents()) c.setEnabled(ativado);
        String titulo = ((TitledBorder)p.getBorder()).getTitle();
        p.setBorder(new TitledBorder(new LineBorder(ativado ? (titulo.contains("GASTO") ? new Color(0, 230, 118) : new Color(96, 165, 250)) : Color.DARK_GRAY), titulo, 0, 0, null, ativado ? Color.WHITE : Color.DARK_GRAY));
    }
}
                
                
                
                