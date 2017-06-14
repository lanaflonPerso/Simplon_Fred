package fr.bisback.dao;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class DAO {
	
	protected String url = "jdbc:mysql://localhost/projet";
	protected String login ="root"; 
	protected String pswd ="adminadmin"; 
	protected Connection cn=null; 
	protected Statement st = null; 
	
	
	public void seConnecter(){
		
		try {
			Class.forName("com.mysql.jdbc.Driver"); 
			cn = (Connection) DriverManager.getConnection(url, login, pswd); 
			st = (Statement) cn.createStatement();
			
		} catch (ClassNotFoundException e){
			e.printStackTrace();
			
		} catch (SQLException e){
			e.printStackTrace();
			
			
		}
	}
	
	public void seDeconnecter() {
		 try {
			 cn.close();
			 st.close();
			 
		 } catch (SQLException e) {
			 e.printStackTrace();
		 }
		
		
	}
	
}