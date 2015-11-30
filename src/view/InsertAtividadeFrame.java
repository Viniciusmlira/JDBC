package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import model.Atividade;
import controller.Engine;

public class InsertAtividadeFrame {
	
	private static Engine in;
	static {
		in = new Engine();
	}
	private JFrame frame;

	private JTextField id;
	private JTextField nome;
	private JTextField diaSemana;
	private JTextField horario;
	private JTextField duracao;

	public InsertAtividadeFrame() {

		frame = new JFrame();
		frame.setTitle("Atividade");
		frame.setBounds(100, 100, 800, 600);
		frame.setLocationByPlatform(true);
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);

		JLabel lblBuscarCliente = new JLabel("Inserir Atividade");
		lblBuscarCliente.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBuscarCliente.setBounds(10, 10, 227, 14);
		frame.getContentPane().add(lblBuscarCliente);

		/*--------------------LABEL SECTION--------------------*/
		// label -> id
		this.id = new JTextField();
		this.id.setText("ID");
		this.id.setColumns(15);
		this.id.setBounds(10, 50, 178, 20);
		frame.getContentPane().add(this.id);

		// label -> nome
		this.nome = new JTextField();
		this.nome.setText("Nome");
		this.nome.setColumns(15);
		this.nome.setBounds(10, 80, 178, 20);
		frame.getContentPane().add(this.nome);
		
		// label -> dia da semana
		this.diaSemana = new JTextField();
		this.diaSemana.setText("Dia da Semana");
		this.diaSemana.setColumns(15);
		this.diaSemana.setBounds(10, 110, 178, 20);
		frame.getContentPane().add(this.diaSemana);
		
		// label -> horario
		this.horario = new JTextField();
		this.horario.setText("Horário");
		this.horario.setColumns(15);
		this.horario.setBounds(10, 140, 178, 20);
		frame.getContentPane().add(this.horario);

		// label -> duracao
		this.duracao = new JTextField();
		this.duracao.setText("Duração");
		this.duracao.setColumns(15);
		this.duracao.setBounds(10, 170, 178, 20);
		frame.getContentPane().add(this.duracao);

		/*--------------------END SECTION--------------------*/

		JButton clientBtnInsert = new JButton("Inserir Atividade");

		clientBtnInsert.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
	
				Atividade atividade = new Atividade(id.getText(), nome.getText(), diaSemana.getText(), horario.getText(), duracao.getText());

				try {
					in.insert(atividade);
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
