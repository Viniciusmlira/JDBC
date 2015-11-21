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

import controller.Engine;
import model.Funcionario;
import model.Logadouro;

public class InsertFileFrame {
	private static Engine in;
	static {
		in = new Engine();
	}
	private JFrame frame;

	private JTextField path;
	public InsertFileFrame() {

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
		path = new JTextField();
		path.setText("Nome");
		path.setColumns(15);
		path.setBounds(10, 50, 178, 20);
		frame.getContentPane().add(path);
		
		JButton clientBtnInsert = new JButton("Inserir Photo");
		clientBtnInsert.setText("Add picture");
		clientBtnInsert.setBounds(10, 80, 150, 20);
		frame.getContentPane().add(clientBtnInsert);
		
		clientBtnInsert.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					in.insertPhoto(path.getText());
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}

			}
		});
	}

}
