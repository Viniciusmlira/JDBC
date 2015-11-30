package model;

public class Associado extends Membro implements DataModel {
	
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
	
	static public String getTable(){
		return "select * from tb_associado";
	}
	static public String searchById(String cpf){
		
		return "select * from tb_associado where cpf = \'"+cpf+"\'";
	}
	
	public String insert() {
		
		String insert = "insert into tb_associado values(\'"+ this.getCpf() +"\',\'"+ this.getSexo()+"\',\'"+ this.getName()
		+"\',\'"+ this.getEmail()+"\', to_date(\'"+this.getDate()+"\',\'dd/mm/yyyy\'),"+ this.getLogadouro().insert()+",tp_fones(";
		
		for(int i =0; i< this.getPhone().length;i++){
			if(this.getPhone()[i] != null){	
				insert+= "tp_fone(\'"+this.getPhone()[i]+"\')";
				if(i < this.getPhone().length -1 ){
					insert+=",";
				}
			}
		}
		insert+="), to_date(\'"+ this.getDataAssociacao()+"\',\'dd/mm/yyyy\'),"+"\'"+ this.getStatus()+ "\'" +", dependente_nested(";
		
		if(this.getDependentes() != null) {
			
			for(int j=0; j<this.getDependentes().length; j++) {
				
				if(this.getDependentes()[j] != null) {
					
					insert+= this.getDependentes()[j].insert();
					if(j < this.getDependentes().length -1) {
						
						insert+=",";
					}
					
				}
				
			}
			
			insert+=")";
		}

		insert+=")";
		
		return insert;
		
	}
}
