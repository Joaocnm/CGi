package modelo.cgi;
import java.util.ArrayList;
import java.util.List;

public class Usuario {
	
	private String email;
	private String senha;
	private String nome;
	private String apelido; //opcional 
	private String profissao;
	private double rendaMensal;
	public static List<Usuario> listaUsuarios = new ArrayList<>();
	public List<String> definicaoGastosFixos = new ArrayList<>();
	public List<String> definicaoMetas = new ArrayList<>(); // combão 
	public List<MovimentacaoFinanceira> historico = new ArrayList<>();
	
	public Usuario (String email, String senha, String nome, String apelido, String profissao, double rendaMensal) {
	this.email = email;
	this.senha = senha;
	this.nome = nome;
	this.apelido = apelido;
	this.profissao = profissao;
	this.rendaMensal = rendaMensal;
	//this.historico = new ArrayList<>(); //inicia a lista vazia >> acho q vai ter q exclui isso 
}
	
	public String getEmail() {return email; }
	public void setEmail(String email) {this.email = email; }
	
	public String getSenha() {return senha; }
	public void setSenha(String senha) {this.senha = senha; }

	public String getNome() {return nome; }
	public void setNome(String nome) {this.nome = nome; }
	
	public String getApelido() {return apelido; }
	public void setApelido(String apelido) {this.apelido = apelido; }
	
	public String getProfissao() {return profissao; }
	public void setProfisao(String profissao) {this.profissao = profissao; }
	
	public double getRendaMensal() {return rendaMensal; }
	public void setRendaMensal(double rendaMensal) {this.rendaMensal = rendaMensal; }
	
	//pegar historico inteiro - acho que essa parte vai ter que apagar 
	public List <Usuario> getHistorico() {return listaUsuarios; }
	
	
	//para o sistema "conversar" com o usuário pelo apelido. se ele tiver deixado em branco, ira chamalo pelo nome normal.
	public String getComoChamar () {
		if (apelido != null && !apelido.trim().isEmpty()) { //trim() remove espaços - isEmpty() verifica se a string está vazia 
			return apelido;
		}
		return nome;
	}
	}

	
	
	
