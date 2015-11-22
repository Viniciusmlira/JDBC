package model;

public class Evento {
	
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

}
