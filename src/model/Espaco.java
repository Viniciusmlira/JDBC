package model;

public class Espaco {
	
	private String id;
	private String nome;
	private int capacidade;
	
	public Espaco(String id, String nome, int capacidade) {
		
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
	
	public int getCapacidade() {
		
		return this.capacidade;
		
	}
	
	public void setCapacidade(int capacidade) {
		
		this.capacidade = capacidade;
		
	}

}
