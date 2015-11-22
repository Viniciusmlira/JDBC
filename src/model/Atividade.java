package model;

public class Atividade {
	
	private String id;
	private String nome;
	private String diaSemana;
	private String horario;
	private int duracao;
	
	public Atividade(String id, String nome, String diaSemana, String horario, int duracao) {
		
		this.id = id;
		this.nome = nome;
		this.diaSemana = diaSemana;
		this.horario = horario;
		this.duracao = duracao;
		
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
	
	public String getDiaSemana() {
		
		return this.diaSemana;
		
	}
	
	public void setDiaSemana(String diaSemana) {
		
		this.diaSemana = diaSemana;
		
	}
	
	public String getHorario() {
		
		return this.horario;
		
	}
	
	public void setHorario(String horario) {
		
		this.horario = horario;
		
	}
	
	public int getDuracao() {
		
		return this.duracao;
		
	}
	
	public void setDuracao(int duracao) {
		
		this.duracao = duracao;
		
	}

}
