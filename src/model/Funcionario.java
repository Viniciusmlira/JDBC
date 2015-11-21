package model;

import java.sql.SQLData;
import java.sql.SQLException;
import java.sql.SQLInput;
import java.sql.SQLOutput;

public class Funcionario extends Pessoa implements SQLData {
	
	String type_name;
	
    private String data_adimissao;
    private String remuneracao;
	
	public Funcionario(String cpf, String name, String date, String email, String sexo, String[] phone, Logadouro logadouro) {
		super(cpf, name, date, email, sexo, phone, logadouro);
	}
	
	public Funcionario(String sql_type,String data_adimissao, String remuneracao,String cpf, String name, String date, String email, String sexo, String[] phone, Logadouro logadouro) {
		super(cpf, name, date, email, sexo, phone, logadouro);
		this.data_adimissao = data_adimissao;
		this.remuneracao = remuneracao;
	}
	static public String getTable(){
		return "select * from tb_funcionario";
	}
	static public String searchById(String cpf){
		
		return "select * from tb_funcionario where cpf = \'"+cpf+"\'";
	}
	public String getRemuneracao(){
		return remuneracao;
	}
	public String getDataAdimissao(){
		return data_adimissao;
	}
	
	@Override
	public String insert(){
		String ret =  "insert into tb_funcionario values(\'"+ this.getCpf() +"\',\'"+ this.getSexo()+"\',\'"+ this.getName()
		+"\',\'"+ this.getEmail()+"\', to_date(\'"+this.getDate()+"\',\'dd/mm/yyyy\'),"+ this.getLogadouro().insert()+",tp_fones(";
		
		for(int i =0; i< this.getPhone().length;i++){
			if(this.getPhone()[i] != null){	
				ret+= "tp_fone(\'"+this.getPhone()[i]+"\')";
				if(i < this.getPhone().length -1 ){
					ret+=",";
				}
			}
		}
		ret+="), to_date(\'"+ this.getDataAdimissao()+"\',\'dd/mm/yyyy\'),"+remuneracao+", tp_nested_funcionario()";
		
		ret+=")";
		
		return ret;
	}

	@Override
	public String getSQLTypeName() throws SQLException {
		return this.type_name;
	}

	@Override
	public void readSQL(SQLInput arg0, String arg1) throws SQLException {
		this.type_name = arg1;
		cpf = arg0.readString();
		name = arg0.readString();
		email = arg0.readString();
		date = arg0.readDate().toString();
		//Object o = arg0.readObject();
		
		
	}

	@Override
	public void writeSQL(SQLOutput arg0) throws SQLException {
		// TODO Auto-generated method stub
		
	}

}
