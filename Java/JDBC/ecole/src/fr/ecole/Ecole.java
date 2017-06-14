package fr.ecole;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class Ecole {

	public static void main(String[] args) {
		String sql;
	    try {
	        Class.forName("com.mysql.jdbc.Driver");
	           
	        String url = "jdbc:mysql://localhost:3306/Ecole";
	        String user = "root";
	        String passwd = "Jeanmarc1967";
	           
	        Connection conn = DriverManager.getConnection(url, user, passwd);
	           
	        //Création d'un objet Statement
	        Statement state = conn.createStatement();
	        //L'objet ResultSet contient le résultat de la requête SQL
	        
//          sql = "SELECT * FROM classe"; // Exo 1
	        
//	        sql = "SELECT * FROM professeur"; // Exo 2
	        
	        sql = "Select prof_nom, prof_prenom, mat_nom from";
	        sql+= " matiere inner join j_mat_prof on mat_id = jmp_mat_k inner join";
	        sql+= " professeur on jmp_prof_k = prof_id order by prof_nom";
	        
	        ResultSet result = state.executeQuery(sql);
	        //On récupère les MetaData
	        ResultSetMetaData resultMeta = result.getMetaData();

	        System.out.println("- Il y a " + resultMeta.getColumnCount() + " colonnes dans cette table");
	        for(int i = 1; i <= resultMeta.getColumnCount(); i++)
	          System.out.println("\t *" + resultMeta.getColumnName(i));
	        
	        System.out.println("\n**********************************");
	        //On affiche le nom des colonnes
	        for(int i = 1; i <= resultMeta.getColumnCount(); i++) {
	          System.out.print("\t" + resultMeta.getColumnName(i).toUpperCase() + "\t *");
	        }
	        System.out.println("\n**********************************");
	           
	        while(result.next()){         
	          for(int i = 1; i <= resultMeta.getColumnCount(); i++)
	            System.out.print("\t" + result.getObject(i).toString() + "\t |");
	              
	          System.out.println("\n---------------------------------");

	        }

	        result.close();
	        state.close();
	           
	      } catch (Exception e) {
	        e.printStackTrace();
	      } 	
	    	}

}
