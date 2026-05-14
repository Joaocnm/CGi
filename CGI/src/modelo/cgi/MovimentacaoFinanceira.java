package modelo.cgi;
import java.time.LocalDate;

//classe mamãe
public abstract class MovimentacaoFinanceira {
	
	private String descricao;
	private double valor;
	private LocalDate data; 
	
	public MovimentacaoFinanceira (String descricao, double valor , LocalDate data) {
		this.descricao = descricao;
		this.valor = valor;
		this.data = data;
	}
	
	public String getCategoria() { return "Geral"; }//valor  padrão para qualquer movimentação
	
	public String getDescricao() {return descricao; }
	public void setDescricao(String descricao) {this.descricao = descricao; }
	
	public double getValor() {return valor; }
	public void setValor(double valor) {this.valor = valor; }
	
	public LocalDate getData () {return data; }
	public void setData (LocalDate data) {this.data = data; }
	
	public abstract String exibirResumo() ;
}
