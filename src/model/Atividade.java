package model;

public class Atividade implements DataModel {
	
	private String id;
	private String nome;
	private String diaSemana;
	private String horario;
	private String duracao;
	
	public Atividade(String id, String nome, String diaSemana, String horario, String duracao) {
		
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
	
	public String getDuracao() {
		
		return this.duracao;
		
	}
	
	public void setDuracao(String duracao) {
		
		this.duracao = duracao;
		
	}
	
	static public String getTable(){
		
		return "select * from tb_atividade";
		
	}
	
	static public String searchById(String id){
		
		return "select * from tb_atividade where codigo_de_id = \'"+id+"\'";
	}

	@Override
	public String insert() {
		
		String insert =  "insert into tb_atividade values(\'"+ this.getID() +"\',\'"+ this.getNome()+"\',\'"+ this.getDiaSemana() +"\',\'"+ this.getHorario() +"\',\'"+ this.getDuracao() +"\')";
		
		return insert;
		
	}

}
