package model;

public class Dependente extends Membro implements DataModel {
	
	public Dependente(String cpf, String name, String date, String email, String sexo,
			String[] phone, Logadouro logadouro, String dataAssociacao) {
		
		super(cpf, name, date, email, sexo, phone, logadouro, dataAssociacao);
		
	}
	
	static public String getTable() {
		return null;
	}
	
	static public String searchById(){
		return null;
	}
	
	@Override
	public String insert() {
		
		String insert = "tp_dependente(\'"+ this.getCpf() +"\',\'"+ this.getSexo()+"\',\'"+ this.getName()
				+"\',\'"+ this.getEmail()+"\', to_date(\'"+this.getDate()+"\',\'dd/mm/yyyy\'),"+ this.getLogadouro().insert()+",tp_fones(";
		
				for(int i =0; i< this.getPhone().length;i++){
					if(this.getPhone()[i] != null){	
						insert+= "tp_fone(\'"+this.getPhone()[i]+"\')";
						if(i < this.getPhone().length -1 ){
							insert+=",";
						}
					}
				}
				insert+="), to_date(\'"+ this.getDataAssociacao()+"\',\'dd/mm/yyyy\')";
				
				insert+=")";
				
		return insert;
	
	}

}
