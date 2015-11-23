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

import model.Evento;
import controller.Engine;

public class InsertEvento {
	
	private static Engine in;
	static {
		in = new Engine();
	}
	private JFrame frame;

	private JTextField id;
	private JTextField descricao;

	public InsertEvento() {

		frame = new JFrame();
		frame.setTitle("Evento");
		frame.setBounds(100, 100, 800, 600);
		frame.setLocationByPlatform(true);
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);

		JLabel lblBuscarCliente = new JLabel("Inserir Evento");
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

		// label -> descricao
		this.descricao = new JTextField();
		this.descricao.setText("Nome");
		this.descricao.setColumns(15);
		this.descricao.setBounds(10, 80, 178, 20);
		frame.getContentPane().add(this.descricao);

		/*--------------------END SECTION--------------------*/

		JButton clientBtnInsert = new JButton("Inserir Evento");

		clientBtnInsert.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
	
				Evento evento = new Evento(id.getText(), descricao.getText());

				try {
					in.insert(evento);
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
