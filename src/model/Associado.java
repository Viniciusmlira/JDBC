package model;

public class Associado extends Membro {
	
	private String status;
	private Dependente[] dependentes;
	
	public Associado(String cpf, String name, String date, String email, String sexo,
			String[] phone, Logadouro logadouro, String dataAssociacao, String status, Dependente[] dependentes) {
		
		super(cpf, name, date, email, sexo, phone, logadouro, dataAssociacao);
		this.status = status;
		this.dependentes = dependentes;
		
	}
	
	public String getStatus() {
		
		return this.status;
		
	}
	
	public void setStatus(String status) {
		
		this.status = status;
		
	}
	
	public Dependente[] getDependentes() {
		
		return this.dependentes;
		
	}
	
	public void setDependentes(Dependente[] dependentes) {
		
		this.dependentes = dependentes;
	
	}
}
