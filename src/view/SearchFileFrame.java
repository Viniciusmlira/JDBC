package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import controller.Engine;
import model.Funcionario;

public class SearchFileFrame {
	
	private static Engine in;
	static {
		in = new Engine();
	}
	private JFrame frame;

	private JTextField id;
	private ImageIcon image;
	private JLabel display;
	
	public SearchFileFrame(){
		
		frame = new JFrame();
		frame.setTitle("Conectividade com JDBC");
		frame.setBounds(100, 100, 800, 700);
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		id = new JTextField();
		id.setBounds(10, 30, 178, 20);
		id.setText("Nome");
		frame.getContentPane().add(id);
		id.setColumns(15);
		
		JButton button = new JButton("Buscar CPF");
		button.setBounds(198, 30, 100, 23);
		frame.getContentPane().add(button);
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					image = in.queryPhotoById(id.getText());
					
					display = new JLabel();
					display.setBounds(100, 100, 800, 700);
					display.setIcon(image);
					display.setVisible(true);
					
					JFrame f = new JFrame();
					f.setTitle("Buscar Imagem");
					f.setBounds(100, 100, 800, 700);
					f.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
					f.getContentPane().setLayout(null);
					f.setVisible(true);
					
					f.add(display);
					//frame.pack();
				} catch (ClassNotFoundException | SQLException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		
		
		
	}
	

}
