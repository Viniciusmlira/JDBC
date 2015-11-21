package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.concurrent.atomic.LongAdder;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import controller.Engine;
import model.Pessoa;
import model.*;

/**
 * @author mra2
 *
 */
public class InsertFrame {

	private static Engine in;
	static {
		in = new Engine();
	}
	private JFrame frame;

	private JTextField name, cpf, date, phone1, phone2, phone3, email, sexo;
	private JTextField cep, rua, bairro, uf, cidade, numero_rua_residencia;
	private JTextField admission,remuneracao;

	public InsertFrame() {

		frame = new JFrame();
		frame.setTitle("Conectividade com JDBC");
		frame.setBounds(100, 100, 600, 380);
		frame.setLocationByPlatform(true);
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);

		JLabel lblBuscarCliente = new JLabel("Inserir Cliente");
		lblBuscarCliente.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBuscarCliente.setBounds(10, 10, 227, 14);
		frame.getContentPane().add(lblBuscarCliente);

		/*--------------------LABEL SECTION--------------------*/
		// label -> name
		name = new JTextField();
		name.setText("Nome");
		name.setColumns(15);
		name.setBounds(10, 50, 178, 20);
		frame.getContentPane().add(name);

		// label -> cpf
		cpf = new JTextField();
		cpf.setText("CPF");
		cpf.setColumns(15);
		cpf.setBounds(10, 80, 178, 20);
		frame.getContentPane().add(cpf);
		
		// label -> date
		date = new JTextField();
		date.setText("Data de Nascimento");
		date.setColumns(15);
		date.setBounds(10, 110, 178, 20);
		frame.getContentPane().add(date);
		

		// label -> email
		email = new JTextField();
		email.setText("Email");
		email.setColumns(15);
		email.setBounds(10, 140, 178, 20);
		frame.getContentPane().add(email);

		// label -> phone 1
		phone1 = new JTextField();
		phone1.setText("Telefone 1");
		phone1.setColumns(15);
		phone1.setBounds(10, 170, 178, 20);
		frame.getContentPane().add(phone1);

		// label -> phone 2
		phone2 = new JTextField();
		phone2.setText("Telefone 2");
		phone2.setColumns(15);
		phone2.setBounds(10, 200, 178, 20);
		frame.getContentPane().add(phone2);

		// label -> phone 3
		phone3 = new JTextField();
		phone3.setText("Telefone 3");
		phone3.setColumns(15);
		phone3.setBounds(10, 230, 178, 20);
		frame.getContentPane().add(phone3);
		
		// label -> sexo
		sexo = new JTextField();
		sexo.setText("Sexo");
		sexo.setColumns(15);
		sexo.setBounds(10, 260, 178, 20);
		frame.getContentPane().add(sexo);
		
		// label -> CEP
		cep = new JTextField();
		cep.setText("CEP");
		cep.setColumns(15);
		cep.setBounds(200, 50, 178, 20);
		frame.getContentPane().add(cep);
		
		// label -> Rua
		rua = new JTextField();
		rua.setText("Rua");
		rua.setColumns(15);
		rua.setBounds(200, 80, 178, 20);
		frame.getContentPane().add(rua);

		// label -> Bairro
		bairro = new JTextField();
		bairro.setText("Bairro");
		bairro.setColumns(15);
		bairro.setBounds(200, 110, 178, 20);
		frame.getContentPane().add(bairro);
		
		// label -> UF
		uf = new JTextField();
		uf.setText("UF");
		uf.setColumns(15);
		uf.setBounds(200, 140, 178, 20);
		frame.getContentPane().add(uf);
		
		// label -> Cidade
		cidade = new JTextField();
		cidade.setText("Cidade");
		cidade.setColumns(15);
		cidade.setBounds(200, 170, 178, 20);
		frame.getContentPane().add(cidade);

		// label -> Numero
		numero_rua_residencia = new JTextField();
		numero_rua_residencia.setText("Numero");
		numero_rua_residencia.setColumns(15);
		numero_rua_residencia.setBounds(200, 200, 178, 20);
		frame.getContentPane().add(numero_rua_residencia);

		// label -> Cidade
		admission = new JTextField();
		admission.setText("Data de admissao");
		admission.setColumns(15);
		admission.setBounds(200, 230, 178, 20);
		frame.getContentPane().add(admission);

		// label -> Numero
		remuneracao = new JTextField();
		remuneracao.setText("Remuneraçao");
		remuneracao.setColumns(15);
		remuneracao.setBounds(200, 260, 178, 20);
		frame.getContentPane().add(remuneracao);
		/*--------------------END SECTION--------------------*/

		JButton clientBtnInsert = new JButton("Inserir Funcionário");

		clientBtnInsert.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String[] telefones = new String[3];
				
				telefones[0] = phone1.getText();
				telefones[1] = phone2.getText();
				telefones[2] = phone3.getText();
				
				Logadouro log = new Logadouro(cep.getText(),rua.getText(),bairro.getText(), uf.getText(),
						cidade.getText(),numero_rua_residencia.getText());

				Funcionario novoCliente = new Funcionario("tb_funcionario",admission.getText()
						, remuneracao.getText(), cpf.getText(), name.getText(), date.getText(), email.getText()
						, sexo.getText(), telefones, log);
				
//						date.getText(), email.getText(),sexo.getText() , telefones);
//
				try {
					in.insert(novoCliente);
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}

			}
		});

		clientBtnInsert.setBounds(10, 290, 178, 23);
		frame.getContentPane().add(clientBtnInsert);
	}

	public void setVisible(boolean v) {
		this.frame.setVisible(v);
	}
}
