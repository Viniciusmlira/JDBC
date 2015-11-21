package model;

/**
 * @author mra2
 *
 */

public class Pessoa implements DataModel {

	private String cpf, name, date, email,sexo;
	private String[] phone;

	public Pessoa(String cpf, String name, String date, String email, String sexo,
			String[] phone) {
		this.cpf = cpf;
		this.name = name;
		this.date = date;
		this.email = email;
		this.phone = phone;
		this.sexo = sexo;
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
		return name;
	}
	public String[] getPhone() {
		return phone;
	}
}
