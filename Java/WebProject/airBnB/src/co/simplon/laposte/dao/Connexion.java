package co.simplon.laposte.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

abstract class Connexion {
	
	protected String url = "jdbc:mysql://localhost/airbnb";
	protected String login = "airbnb";
	protected String passwd = "Level-42";
	protected Connection cn;

	public void seConnecter() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		cn = DriverManager.getConnection(url, login, passwd);
	}

	public void seDeconnecter() throws SQLException {
		cn.close();
	}

}
