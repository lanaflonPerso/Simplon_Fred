package com.ojis.demojdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


public class DemoJdbc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		correctionServeur();
		sauverEnBase("John McARTHUR");
//		lireEnBase();

	}

	
	public static void correctionServeur() {
		Properties properties = new Properties();
		properties.setProperty("user", "root");
		properties.setProperty("password", "Jeanmarc1967");
		properties.setProperty("useSSL", "false");
		properties.setProperty("autoReconnect", "true");

		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/formation", properties)) {
			System.out.println("Ok !");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

	public static void sauverEnBase (String personne) {
//		 Information d'accès à la base de données
		String url = "jdbc:mysql://localhost/formation";
		String login = "root";
		String passwd = "Jeanmarc1967";
		Connection cn = null;
		Statement st = null;
		try {
			// Etape 1 : Chargement du driver
			Class.forName("com.mysql.jdbc.Driver");
			// Etape 2 : récupération de la connexion
			cn = DriverManager.getConnection(url, login, passwd);
			// Etape 3 : Création d'un statement
			st = cn.createStatement();
			String sql = "INSERT INTO `javadb` (`personne`) VALUES ('" + personne + "')";
			
			// Etape 4 : exécution requête
			st.executeUpdate(sql);
			
		} catch (SQLException e) {
			e.printStackTrace();
//			System.out.println(1);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("3rr9u7");
		} finally {
			try {
				// Etape 5 : libérer ressources de la mémoire.
				cn.close();
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println(3);
			}
		}
	}

	public static void lireEnBase() {

		// Information d'accès à la base de données
		String url = "jdbc:mysql://localhost/formation";
		String login = "root";
		String passwd = "Jeanmarc1967";
		Connection cn =null;
		Statement st =null;
		ResultSet rs =null;
		
		try {

			// Etape 1 : Chargement du driver
			Class.forName("com.mysql.jdbc.Driver");

			// Etape 2 : récupération de la connexion
			cn = DriverManager.getConnection(url, login, passwd);

			// Etape 3 : Création d'un statement
			st = cn.createStatement();

			String sql = "SELECT * FROM javadb";

			// Etape 4 : exécution requête
			rs = st.executeQuery(sql);

			// Si récup données alors étapes 5 (parcours Resultset)

			while (rs.next()) {
				System.out.println(rs.getString("personne"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
			// Etape 6 : libérer ressources de la mémoire.
				cn.close();
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
}
