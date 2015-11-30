package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 * @author mra2
 *
 */
public class MainFrame extends JFrame {

	static class ActionBtnInsert implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			new InsertFrame();
		}	
	}
	private static final long serialVersionUID = 1L;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private JPanel panel;

	public MainFrame() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 800, 660);
		setLocationRelativeTo(null);
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panel);
		panel.setLayout(null);
		
		//label -> inserir funcionario
		JButton insertBtnClient = new JButton("Inserir funcionário");
		insertBtnClient.addActionListener(new ActionBtnInsert());
		insertBtnClient.setBounds(15, 10, 200, 100);
		panel.add(insertBtnClient);
		
		//label -> inserir espaco
		JButton insertBtnEspaco = new JButton("Inserir Espaço");
		insertBtnEspaco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new InsertEspaco();
			}		
		});
		insertBtnEspaco.setBounds(15, 410, 200, 100);
		panel.add(insertBtnEspaco);
		
		//label -> inserir evento
		JButton insertBtnEvento = new JButton("Inserir Evento");
		insertBtnEvento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new InsertEvento();
			}		
		});
		insertBtnEvento.setBounds(215, 10, 200, 100);
		panel.add(insertBtnEvento);
		
		//label -> inserir atividade
		JButton insertBtnAtividade = new JButton("Inserir Atividade");
		insertBtnAtividade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new InsertAtividadeFrame();
			}		
		});
		insertBtnAtividade.setBounds(215, 210, 200, 100);
		panel.add(insertBtnAtividade);
		
		//label -> inserir associado
		JButton insertBtnAssociado = new JButton("Inserir Associado");
		insertBtnAssociado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new InsertAssociadoFrame();
			}		
		});
		insertBtnAssociado.setBounds(215, 410, 200, 100);
		panel.add(insertBtnAssociado);
		
		//label -> search associado
		JButton searchBtnAssociado = new JButton("Buscar Associado");
		searchBtnAssociado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new SearchAssociadoFrame();
			}		
		});
		searchBtnAssociado.setBounds(215, 510, 200, 100);
		panel.add(searchBtnAssociado);
		
		//label -> search espaco
		JButton searchBtnEspaco = new JButton("Buscar Espaço");
		searchBtnEspaco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new SearchEspacoFrame();
			}		
		});
		searchBtnEspaco.setBounds(15, 510, 200, 100);
		panel.add(searchBtnEspaco);
		
		//label -> search atividade
		JButton searchBtnAtividade = new JButton("Buscar Atividade");
		searchBtnAtividade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new SearchAtividadeFrame();
			}		
		});
		searchBtnAtividade.setBounds(215, 310, 200, 100);
		panel.add(searchBtnAtividade);
		
		//label -> search evento
		JButton searchBtnEvento = new JButton("Buscar Evento");
		searchBtnEvento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new SearchEventoFrame();
			}		
		});
		searchBtnEvento.setBounds(215, 110, 200, 100);
		panel.add(searchBtnEvento);
		
		//label -> search funcionario
		JButton searchBtnClient = new JButton("Buscar funcionário");
		searchBtnClient.setBounds(15, 110, 200, 100);
		panel.add(searchBtnClient);
		
		//label -> inserir pic
		JButton insertPic = new JButton("Adicionar Imagem");
		insertPic.setBounds(15, 210, 200, 100);
		panel.add(insertPic);
		
		insertPic.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new InsertFileFrame();
			}
		});
		
		searchBtnClient.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new SearchFrame();
			}
		});	
		
		//label -> search pic
		JButton searchPic = new JButton("Buscar Imagem");
		searchPic.setBounds(15, 310, 200, 100);
		panel.add(searchPic);
		
		searchPic.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new SearchFileFrame();
			}
		});
	}
}
