package view;

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

public class SearchAtividadeFrame {
	
	private static Engine in;
	static {
		in = new Engine();
	}
	private JTextField id;
	private JFrame frame;
	private JTextField name;

	public SearchAtividadeFrame() {
		
		frame = new JFrame();
		frame.setTitle("Buscar Atividade");
		frame.setBounds(100, 100, 400, 200);
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		//label -> id
		this.id = new JTextField();
		this.id.setText("ID da Atividade");
		this.id.setColumns(15);
		this.id.setBounds(10, 64, 178, 20);
		frame.getContentPane().add(this.id);
		
		JButton button = new JButton("Buscar Atividade");
		button.setBounds(198, 63, 100, 23);
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					in.queryAtividade(Atividade.searchById(id.getText()));
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		frame.getContentPane().add(button);
		
		JLabel lblBuscarCliente = new JLabel("Buscar Atividade");
		lblBuscarCliente.setBounds(10, 11, 125, 14);
		frame.getContentPane().add(lblBuscarCliente);
		
	}

}
