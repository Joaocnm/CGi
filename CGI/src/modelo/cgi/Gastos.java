package modelo.cgi;
import java.time.LocalDate;

//classe filha
public class Gastos extends MovimentacaoFinanceira {
	
	 private String categoria; //o usuario titulariza, escreve oq quiser! 
	 private boolean isFixo; // true se for fixo , false se for variavel
	 
	 public Gastos (String descricao, double valor, LocalDate data, String categoria, boolean isFixo) {
		 super (descricao , valor , data); // chamar construtor da classe mãe
		 this.categoria = categoria;
		 this.isFixo = isFixo;
	 }
	 
	 public boolean getIsFixo() {return isFixo; }
	 public void setIsFixo(boolean isFixo) {this.isFixo = isFixo; }
	 
	  
	 //o polimorfismo aq papai d tds 
	@Override
	public String exibirResumo() {
		String tipo = isFixo? "Gasto Fixo" : "Gasto Variável";
		return tipo + ": " + getDescricao() + "(" +categoria +") "+ 
				"| Valor: R$ " + getValor();
	}
	
	@Override
	public String getCategoria() {
	    return this.categoria; //atributo q já tem nessa classe
	}

}
