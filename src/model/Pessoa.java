package model;

/**
 * @author mra2
 *
 */

public class Pessoa implements DataModel {

	private String cpf, name, date, email,sexo;
	private String[] phone;
	private Logadouro logadouro;

	public Pessoa(String cpf, String name, String date, String email, String sexo,
			String[] phone, Logadouro logadouro) {
		this.cpf = cpf;
		this.name = name;
		this.date = date;
		this.email = email;
		this.phone = phone;
		this.sexo = sexo;
		this.logadouro = logadouro;
	}
	
	public Logadouro getLogadouro(){
		return this.logadouro;
	}
	public String getCpf() {
		return cpf;
	}

	public String getDate() {
		return date;
	}

	public String getEmail() {
		return email;
	}

	public String getName() {
		return name;
	}
	
	public String getSexo() {
		return sexo;
	}
	public String[] getPhone() {
		return phone;
	}
	
	public String insert(){
		return null;
	}
	static public String getTable() {
		// TODO Auto-generated method stub
		return null;
	}
}
