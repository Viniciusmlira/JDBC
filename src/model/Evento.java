package model;

public class Evento implements DataModel{
	
	private String id;
	private String descricao;
	
	public Evento(String id, String descricao) {
		
		this.id = id;
		this.descricao = descricao;
		
	}
	
	public String getID() {
		
		return this.id;
		
	}
	
	public void setID(String id) {
		
		this.id = id;
		
	}
	
	public String getDescricao() {
		
		return this.descricao;
		
	}
	
	public void setDescricao(String descricao) {
		
		this.descricao = descricao;
		
	}
	
	static public String getTable(){
		
		return "select * from tb_evento";
		
	}
	
	static public String searchById(String id){
		
		return "select * from tb_evento where codigo_de_id = \'"+id+"\'";
	}

	@Override
	public String insert() {
		
		String insert =  "insert into tb_evento values(\'"+ this.getID() +"\',\'"+ this.getDescricao() +"\')";
		
		return insert;
		
	}

}
