package view;

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

/**
 * @author mra2
 *
 */
public class SearchFrame {
	private static Engine in;
	static {
		in = new Engine();
	}
	private JTextField cpf;
	private JFrame frame;
	private JTextField name;

	public SearchFrame() {
		
		frame = new JFrame();
		frame.setTitle("Conectividade com JDBC");
		frame.setBounds(100, 100, 400, 200);
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		//label -> name
		name = new JTextField();
		name.setBounds(10, 30, 178, 20);
		name.setText("Nome");
		frame.getContentPane().add(name);
		name.setColumns(15);
		
		//label -> cpf
		cpf = new JTextField();
		cpf.setText("CPF");
		cpf.setColumns(15);
		cpf.setBounds(10, 64, 178, 20);
		frame.getContentPane().add(cpf);
		
		JButton button = new JButton("Buscar CPF");
		button.setBounds(198, 63, 100, 23);
	//	button.setB
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					in.queryFuncionario(Funcionario.searchById(cpf.getText()));
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		frame.getContentPane().add(button);
		
		
		JLabel lblBuscarCliente = new JLabel("Buscar funcionario");
		lblBuscarCliente.setBounds(10, 11, 125, 14);
		frame.getContentPane().add(lblBuscarCliente);
		
		JButton bucar = new JButton("Buscar Nome");
		bucar.setBounds(198, 31, 100, 23);
		frame.getContentPane().add(bucar);
	}
}
