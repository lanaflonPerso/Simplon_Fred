 package fr.bisfront.servlet;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;

import fr.projet.beans.Adresse;
import fr.projet.beans.Disponibilité;
import fr.projet.beans.Logement;

/**
 * Servlet implementation class Recherche
 */
@WebServlet("/Recherche")
public class Recherche extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Recherche() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	process(request,response); 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	process(request,response); 
	}
	
	
	private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
// données pour la recherche 
		String villef = request.getParameter("ville"); 
		String dateduf = request.getParameter("datedu"); 
		String dateauf = request.getParameter("dateau");
		Connection conn = null; 
		
		try {
//attaquer la base
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver O.K.");
             String url = "jdbc:mysql://127.0.0.1:3306/projet";
             String user = "root";
             String passwd = "adminadmin";

			 conn =  (Connection) DriverManager.getConnection(url, user, passwd); 
			System.out.println("Connexion effective !");
// touver le logement avec les données saisi
			PreparedStatement state =  conn.prepareStatement("select idLogement, description, idadresse, rue, ville, iddisponibilite, dateDu, dateAu from adresse left join logement on idadresse = Adresse_idAdresse right join  disponibilite on Disponibilite_idDisponibilite = idDisponibilite WHERE ville =? and dateDu >=? and dateAu <=?");
            state.setString(1, villef);
            state.setString(2, dateduf);
            state.setString(3, dateauf);
	// stocker le résultat de la requete	
			ResultSet resultat= state.executeQuery(); 
			
			int idadresse = 0; 
			int iddisponibilité = 0; 
			
	// instancier un objet bean logement pour l'affichage 
			 Logement l = new Logement(); 
			 if (resultat.next()){
				
				  l.setId(resultat.getInt("idlogement"));
				  l.setDescription(resultat.getString("description"));
	// connaitre son idadresse et disponibilité pour faire un select de correspondance rue, ville, datedu dateau		  
				  idadresse =  resultat.getInt("idadresse");
					 iddisponibilité = resultat.getInt("iddisponibilite"); 
					 
					 
					// System.out.println(idadresse+"  "+iddisponibilité);
					 
				  
			 } 
	// instancier un objetbean adresse  et l'attribué au logement à afficher dan sla jsp 		
			 PreparedStatement state2 =  conn.prepareStatement("select rue, ville from adresse WHERE idadresse = ? ");
	            state2.setInt(1, idadresse);
	            ResultSet resultat2= state2.executeQuery(); 
	            Adresse a = new Adresse (); 
	            if ( resultat2.next()){
	            	
	            	a.setRue(resultat2.getString("rue"));
	            	a.setVille(resultat2.getString("ville"));
	            	l.setAdresse(a); 
	            }
	        
	         // instancier un objetbean dispobinilité et l'attribué au logement à afficher dans la jsp 
	            PreparedStatement state3 =  conn.prepareStatement("select dateDu, dateAu from disponibilite WHERE idDisponibilite= ?");  
	            state3.setInt(1, iddisponibilité);
	            ResultSet resultat3= state3.executeQuery(); 
	            if ( resultat3.next()){
	            	  Disponibilité d = new  Disponibilité(); 
	            	d.setDateDu(resultat3.getString("datedu"));
	            	d.setDateAu(resultat3.getString("dateau"));
	            	l.setDisponibilité(d);
	            	
	            	
	            }

	      // System.out.println(l.getId()+l.getDescription()+l.getAdresse().getVille()+l.getDisponibilité().getDateDu());     

	// attacher l'objet bean l à un attribut pour l'affichage de ses propriétés
			request.setAttribute("logement", l);
			

		
            
		}  
		catch (Exception e){
			System.out.println("Echec à la connexion");
		}
		finally {
			if (conn!= null){
				try { conn.close(); 
				}catch (SQLException e)
				{e.printStackTrace(); 
				}
				
		}

			 RequestDispatcher requestDispatcher = request.getRequestDispatcher("resultat.jsp"); 
		     requestDispatcher.forward(request, response);
		     

		 }}

	
     
		
	}
		
	


