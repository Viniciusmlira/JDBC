package model;

public class Funcionario extends Pessoa {
	
    private String data_adimissao;
    private double remuneracao;
	
	public Funcionario(String cpf, String name, String date, String email, String sexo, String[] phone, Logadouro logadouro) {
		super(cpf, name, date, email, sexo, phone, logadouro);
	}
	
	public Funcionario(String data_adimissao, double remuneracao,String cpf, String name, String date, String email, String sexo, String[] phone, Logadouro logadouro) {
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
	public double getRemuneracao(){
		return remuneracao;
	}
	public String getDataAdimissao(){
		return data_adimissao;
	}
	
	@Override
	public String insert(){
		String ret =  "insert into tb_funcionario values("+ this.getCpf() +","+ this.getSexo()+","+ this.getName()
		+","+ this.getEmail()+","+ this.getSexo()+this.getDate()+","+ this.getLogadouro()+",tp_fones(";
		
		for(int i =0; i< this.getPhone().length;i++){
			if(this.getPhone()[i] != null){	
				ret+= "tp_fone("+this.getPhone()[i]+")";
				if(i < this.getPhone().length -1 ){
					ret+=",";
				}
			}
		}
		ret+=", tp_nested_funcionario()";
		
		ret+=")";
		
		return ret;
	}

}
