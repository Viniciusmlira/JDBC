package model;

public class Logadouro implements DataModel {
	
	String cep;
	String rua;
	String bairro;
	String uf;
	String cidade;
	String numero;
	
	public Logadouro(String cep, String rua, String bairro,String uf, String cidade, String numero){
		this.cep = cep;
		this.rua =rua;
		this.bairro = bairro;
		this.uf = uf;
		this.cidade = cidade;
		this.numero = numero;
	}
	@Override
	public String insert() {
		return "tp_logradouros('"+this.cep +"','"+this.rua+"','"+this.bairro+"','"+this.uf+"','"+this.rua+"','"+this.numero+"')";
	}

}
