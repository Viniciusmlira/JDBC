package model;

public class Espaco implements DataModel {
	
	private String id;
	private String nome;
	private String capacidade;
	
	public Espaco(String id, String nome, String capacidade) {
		
		this.id = id;
		this.nome = nome;
		this.capacidade = capacidade;
		
	}
	
	public String getID() {
		
		return this.id;
		
	}
	
	public void setID(String id) {
		
		this.id = id;
		
	}
	
	public String getNome() {
		
		return this.nome;
		
	}
	
	public void setNome(String nome) {
		
		this.nome = nome;
		
	}
	
	public String getCapacidade() {
		
		return this.capacidade;
		
	}
	
	public void setCapacidade(String capacidade) {
		
		this.capacidade = capacidade;
		
	}
	
	static public String getTable(){
		
		return "select * from tb_espaco";
		
	}
	
	static public String searchById(String id){
		
		return "select * from tb_espaco where codigo_de_id = \'"+id+"\'";
	}

	@Override
	public String insert() {
		
		String insert =  "insert into tb_espaco values(\'"+ this.getID() +"\',\'"+ this.getNome()+"\',\'"+ this.getCapacidade() +"\')";
		
		return insert;
		
	}

}
