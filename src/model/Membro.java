package model;

public abstract class Membro extends Pessoa {
	
	private String dataAssociacao;
	
	public Membro(String cpf, String name, String date, String email, String sexo,
			String[] phone, Logadouro logadouro, String dataAssociacao) {
		
		super(cpf, name, date, email, sexo, phone, logadouro);
		
		this.dataAssociacao = dataAssociacao;
		
	}
	
	public String getDataAssociacao() {
		
		return this.dataAssociacao;
		
	}
	
	public void setDataAssociacao(String dataAssociacao) {
		
		this.dataAssociacao = dataAssociacao;
		
	}

}
