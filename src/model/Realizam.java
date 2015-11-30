package model;

public class Realizam {
	
	private Membro membro;
	private Evento evento;
	private Espaco espaco;
	private String date;
	private int duracao;
	
	public Realizam(Membro membro, Evento evento, Espaco espaco, String date, int duracao) {
		
		this.membro = membro;
		this.evento = evento;
		this.espaco = espaco;
		this.date = date;
		this.duracao = duracao;
		
	}

	public Membro getMembro() {
		return membro;
	}

	public void setMembro(Membro membro) {
		this.membro = membro;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public Espaco getEspaco() {
		return espaco;
	}

	public void setEspaco(Espaco espaco) {
		this.espaco = espaco;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getDuracao() {
		return duracao;
	}

	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}

}
