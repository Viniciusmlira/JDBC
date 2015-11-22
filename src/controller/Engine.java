package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Ref;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;

import model.DataModel;
import model.Funcionario;

/**
 * @author mra2
 * 
 */

public class Engine {

	static final String driver = "oracle.jdbc.driver.OracleDriver";
	static final String URL = "jdbc:oracle:thin:hr/hr@localhost:1521/XE";
	static final String username = "SYSTEM";
	static final String password = ""; // local password
	static int photoCounter = 0;

	public static Connection connectToDatabase(String username, String password)
			throws ClassNotFoundException {

		Connection con = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(URL, username, password);
		} catch (ClassNotFoundException exc1) {
			exc1.printStackTrace();
		} catch (SQLException exc2) {
			exc2.printStackTrace();
		}

		return con;
	}

	/*
	 * This method allow insert, delete and update data over database
	 */
	
	public ImageIcon queryPhotoById(String id) throws ClassNotFoundException, SQLException, IOException{
		Connection con = connectToDatabase(username, password);
		String  sql = "select photo from photos where id = "+id;
		PreparedStatement stmt = con.prepareStatement(sql);
	    ResultSet resultSet = stmt.executeQuery();
	    File image;
	    String tempFileLocation = "C:\\temp\\image.jpg";
	    while (resultSet.next()) {
	      image = new File(tempFileLocation);
	      FileOutputStream fos = new FileOutputStream(image);

	      byte[] buffer = new byte[1];
	      java.io.InputStream is = resultSet.getBinaryStream(1);
	      while (is.read(buffer) > 0) {
	        fos.write(buffer);
	      }
	      fos.close();
	    }
	    con.close();
	    ImageIcon im =new ImageIcon(tempFileLocation);
	    return im;
	}
	public void insertPhoto(String path) throws ClassNotFoundException, SQLException {
		Connection con = connectToDatabase(username, password);
		File file = new File(path);
		String insert_picture = "insert into photos(id, photo) values (?, ?)";
		PreparedStatement ps = null;
		try {
			con.setAutoCommit(false);
			FileInputStream fis = new FileInputStream(file);
			ps = con.prepareStatement(insert_picture);
			ps.setString(1, ""+Engine.photoCounter++);
		    ps.setBinaryStream(2, fis, (int) file.length());
			ps.executeUpdate();
			System.out.println("photo adicionada");
			ps.close();
			con.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void insert(DataModel data) throws ClassNotFoundException, SQLException{
		Connection con = connectToDatabase(username, password);
		Statement stmt = con.createStatement();
		//String insertS = data.insert();
		stmt.executeUpdate(data.insert());
		stmt.close();
		con.close();
		System.out.println("Funcionario Inserido");
		
	}
	
	public void queryFuncionario(String funcionarioCpf) throws SQLException, ClassNotFoundException {
		Connection con = connectToDatabase(username, password);
		Statement stmt = con.createStatement();
		//String query = "";
		stmt.executeQuery(funcionarioCpf);
		
		ResultSet rs = stmt.getResultSet ();
	    int count = 0;
	    ResultSetMetaData md=  rs.getMetaData();
	    
	    
	    while (rs.next ()){
	    	//get first 5 columns
	    	for(int i = 1 ; i <= 5;i++){
	    		String columnName = md.getColumnName(i);
		    	 String idVal = rs.getString(columnName);
			     System.out.println (columnName+" = " + idVal);
		    	
		    }
	    	//tp_logadouro
	    	//tp_fones
	    	for(int i = 8 ; i <= 9;i++){
	    		String columnName = md.getColumnName(i);
		    	 String idVal = rs.getString(columnName);
			     System.out.println (columnName+" = " + idVal);	
		    }
	    	//nested table
	    	//ResultSet nested = rs.getArray(md.getColumnName(10)).getResultSet(); 
	    	System.out.println(md.getColumnTypeName(10));
	    	//ResultSetMetaData nestedmd=  nested.getMetaData();
//	    	System.out.println("Supervisiona: ");
//	    	while(nested.next()){
//	    		
//	    	}
	    	
	       ++count;
	    }
	    rs.close ();
		stmt.close();
		con.close();
	}
	
	/*
	 * This method creates a new table!
	 */
	public void createTable(DataModel c) throws SQLException, ClassNotFoundException {
		Connection con = connectToDatabase(username, password);
		Statement stmt = con.createStatement();
		String sql = "";
		stmt.executeUpdate(sql);
	}
}
