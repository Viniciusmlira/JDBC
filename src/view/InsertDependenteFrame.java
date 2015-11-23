package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import model.Dependente;
import model.Logadouro;
import controller.Engine;

public class InsertDependenteFrame {
	
	private static Engine in;
	static {
		in = new Engine();
	}
	private JDialog dialog;

	private JTextField name, cpf, date, phone1, phone2, phone3, email, sexo;
	private JTextField cep, rua, bairro, uf, cidade, numero_rua_residencia;
	private JTextField dataAssociacao;
	
	private Dependente dependente;
	
	public InsertDependenteFrame(JFrame parent) {
	
		dialog = new JDialog(parent, "Inserir Dependente", true);
		dialog.setBounds(100, 100, 800, 600);
		dialog.setLocationByPlatform(true);
		dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		dialog.getContentPane().setLayout(null);

		JLabel lblBuscarCliente = new JLabel("Inserir Cliente");
		lblBuscarCliente.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBuscarCliente.setBounds(10, 10, 227, 14);
		this.dialog.getContentPane().add(lblBuscarCliente);

		/*--------------------LABEL SECTION--------------------*/
		// label -> name
		name = new JTextField();
		name.setText("Nome");
		name.setColumns(15);
		name.setBounds(10, 50, 178, 20);
		dialog.getContentPane().add(name);

		// label -> cpf
		cpf = new JTextField();
		cpf.setText("CPF");
		cpf.setColumns(15);
		cpf.setBounds(10, 80, 178, 20);
		dialog.getContentPane().add(cpf);
		
		// label -> date
		date = new JTextField();
		date.setText("Data de Nascimento");
		date.setColumns(15);
		date.setBounds(10, 110, 178, 20);
		dialog.getContentPane().add(date);
		

		// label -> email
		email = new JTextField();
		email.setText("Email");
		email.setColumns(15);
		email.setBounds(10, 140, 178, 20);
		dialog.getContentPane().add(email);

		// label -> phone 1
		phone1 = new JTextField();
		phone1.setText("Telefone 1");
		phone1.setColumns(15);
		phone1.setBounds(10, 170, 178, 20);
		dialog.getContentPane().add(phone1);

		// label -> phone 2
		phone2 = new JTextField();
		phone2.setText("Telefone 2");
		phone2.setColumns(15);
		phone2.setBounds(10, 200, 178, 20);
		dialog.getContentPane().add(phone2);

		// label -> phone 3
		phone3 = new JTextField();
		phone3.setText("Telefone 3");
		phone3.setColumns(15);
		phone3.setBounds(10, 230, 178, 20);
		dialog.getContentPane().add(phone3);
		
		// label -> sexo
		sexo = new JTextField();
		sexo.setText("Sexo");
		sexo.setColumns(15);
		sexo.setBounds(10, 260, 178, 20);
		dialog.getContentPane().add(sexo);
		
		// label -> CEP
		cep = new JTextField();
		cep.setText("CEP");
		cep.setColumns(15);
		cep.setBounds(200, 50, 178, 20);
		dialog.getContentPane().add(cep);
		
		// label -> Rua
		rua = new JTextField();
		rua.setText("Rua");
		rua.setColumns(15);
		rua.setBounds(200, 80, 178, 20);
		dialog.getContentPane().add(rua);

		// label -> Bairro
		bairro = new JTextField();
		bairro.setText("Bairro");
		bairro.setColumns(15);
		bairro.setBounds(200, 110, 178, 20);
		dialog.getContentPane().add(bairro);
		
		// label -> UF
		uf = new JTextField();
		uf.setText("UF");
		uf.setColumns(15);
		uf.setBounds(200, 140, 178, 20);
		dialog.getContentPane().add(uf);
		
		// label -> Cidade
		cidade = new JTextField();
		cidade.setText("Cidade");
		cidade.setColumns(15);
		cidade.setBounds(200, 170, 178, 20);
		dialog.getContentPane().add(cidade);

		// label -> Numero
		numero_rua_residencia = new JTextField();
		numero_rua_residencia.setText("Numero");
		numero_rua_residencia.setColumns(15);
		numero_rua_residencia.setBounds(200, 200, 178, 20);
		dialog.getContentPane().add(numero_rua_residencia);

		// label -> data associacao
		dataAssociacao = new JTextField();
		dataAssociacao.setText("Data de admissao");
		dataAssociacao.setColumns(15);
		dataAssociacao.setBounds(200, 230, 178, 20);
		dialog.getContentPane().add(dataAssociacao);
		
		/*--------------------END SECTION--------------------*/

		JButton clientBtnInsert = new JButton("Inserir Dependente");

		clientBtnInsert.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String[] telefones = new String[3];
				
				telefones[0] = phone1.getText();
				telefones[1] = phone2.getText();
				telefones[2] = phone3.getText();
				
				Logadouro log = new Logadouro(cep.getText(),rua.getText(),bairro.getText(), uf.getText(),
						cidade.getText(),numero_rua_residencia.getText());

				Dependente novoDependente = new Dependente(cpf.getText(), name.getText(), date.getText(), email.getText(), sexo.getText(), telefones, log, dataAssociacao.getText());
				dependente = novoDependente;

			}
		});

		clientBtnInsert.setBounds(10, 290, 178, 23);
		dialog.getContentPane().add(clientBtnInsert);
		
		dialog.setVisible(true);
	}
	
	public Dependente getDependente() {
		
		return this.dependente;
		
	}
	
	public void setVisible(boolean v) {
		this.dialog.setVisible(v);
	}

}
