package modelo.cgi;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter; //data aparecer em formato brasileiro (dd/mm/aaaa)

//classe filha 
public class Investimento extends MovimentacaoFinanceira {
	private String nomeMeta; 
	private double valorMeta; 
	private LocalDate dataInicio;
	private LocalDate dataPrazo; //opcional 
	
	public Investimento (String descricao, double valor , LocalDate data, String nomeMeta , double valorMeta , LocalDate dataInicio, LocalDate dataPrazo) {
		super(descricao , valor , data);
		this.nomeMeta = nomeMeta;
		this.valorMeta = valorMeta;
		this.dataPrazo = dataPrazo;
	}
	
	public String getNomeMeta() {return nomeMeta; }
	public void setNomeMeta(String nomeMeta) {this.nomeMeta = nomeMeta; }
	
	public double getValorMeta() {return valorMeta; }
	public void setValorMeta(double valorMeta) {this.valorMeta = valorMeta; } 
	
	public LocalDate getDataInicio() {return dataInicio; }
	public void setDataInicio(LocalDate dataInicio) {this.dataInicio = dataInicio; }
	
	public LocalDate getDataPrazo() {return dataPrazo; }
	public void setDataPrazo(LocalDate dataPrazo) {this.dataPrazo = dataPrazo; }

	@Override
	public String exibirResumo() {
		//opcional, só mostra a data se ela existir
		String prazoExibicao;
	    
	    if (dataPrazo != null) {
	        // define o formato desejado (dd/mm/aaaa)
	        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	        prazoExibicao = dataPrazo.format(formato);
	    } else {
	        prazoExibicao = "Sem prazo definido";
	    } 
	    return " Investimento: " + nomeMeta +
				"| Meta: R$ " + valorMeta +
				"| Prazo: " + prazoExibicao;
	}
	
	@Override
	public String getCategoria() {
	    return "Meta: " + this.nomeMeta; //retorna o nome da meta como se fosse a categoria
	}

}
