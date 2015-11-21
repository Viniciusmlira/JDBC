package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


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
	public void queryFuncionario(String funcionarioCpf) throws SQLException, ClassNotFoundException {
		Connection con = connectToDatabase(username, password);
		Statement stmt = con.createStatement();
		//String query = "";
		stmt.executeQuery(funcionarioCpf);
		
		ResultSet rs = stmt.getResultSet ();
	    int count = 0;
	    while (rs.next ()){
	       String idVal = rs.getString("nome");
	       System.out.println ("nome = " + idVal);
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
