package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Statement;

public class Photo implements DataModel {
	
	String path;
	@Override
	public String insert(){
		return null;
	}
	public Statement insertStmt() {
		File file = new File(path);
		String insert_picture = "insert into photos(id, photo) values (?, ?)";
		try {
			FileInputStream fis = new FileInputStream(file);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
