package model;

public class Participacao {
	
	private Membro membro;
	private Atividade atividade;
	
	public Participacao(Membro membro, Atividade atividade) {
		
		this.membro = membro;
		this.atividade = atividade;
		
	}
	
	public Membro getMembro() {
		
		return this.membro;
		
	}
	
	public void setMembro(Membro membro) {
		
		this.membro = membro;
		
	}
	
	public Atividade getAtividade() {
		
		return this.atividade;
		
	}
	
	public void setAtividade(Atividade atividade) {
		
		this.atividade = atividade;
	
	}

}
