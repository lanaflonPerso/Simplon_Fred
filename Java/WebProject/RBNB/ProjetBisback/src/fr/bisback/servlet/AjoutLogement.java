package fr.bisback.servlet;

import java.io.IOException;
import java.sql.Date;
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

/**
 * Servlet implementation class AjoutLogement
 */
@WebServlet("/AjoutLogement")
public class AjoutLogement extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AjoutLogement() {
		super();

		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		process(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		process(request, response);
	}

	protected void process (HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
	
		{
	// recupération de données du formulaire 
			String ruef = request.getParameter("rue")	;
			String villef = request.getParameter("ville");
			String dateduf = request.getParameter("datedu");
			String dateauf = request.getParameter("dateau");
			String idproriof = request.getParameter("idproprio"); 
			String descriptionf = request.getParameter("description"); 
			
			Connection conn = null; 
			
			try {
// attaquer la bdd
				Class.forName("com.mysql.jdbc.Driver");
				System.out.println("Driver O.K.");
                 String url = "jdbc:mysql://127.0.0.1:3306/projet";
                 String user = "root";
                 String passwd = "adminadmin";

				 conn =  (Connection) DriverManager.getConnection(url, user, passwd); 
				System.out.println("Connexion effective !");
	// 	adresse 	
				PreparedStatement state0 =  conn.prepareStatement("insert into adresse (rue,ville)values(?,?)", new String[] {"idadressse"});
                state0.setString(1,ruef );
                state0.setString(2, villef);
                state0.executeUpdate(); 
    // obtenir l'idadresse qui va avec             
                ResultSet resultat = state0.getGeneratedKeys(); 
                int idadresse =0; 
                if (resultat.next()){
                	idadresse=resultat.getInt(1); // obtenir l'idadresse qui va avec 
                    
                }
 // disponibilité
                PreparedStatement state1 =  conn.prepareStatement("insert into disponibilite (datedu,dateau)values(?,?)",new String[] {"iddisponibilite"});
                state1.setString(1,dateduf);
                state1.setString(2,dateauf);
                state1.executeUpdate(); 
    // obtenir l'iddispo qui va avec                  
                ResultSet resultat1 = state1.getGeneratedKeys(); 
                int iddisponibilite =0; 
                if (resultat1.next()){
                	iddisponibilite=resultat1.getInt(1); 
                }
                
   // création  du logemnt dans la bbd avec les id correspondante
				PreparedStatement state =  conn.prepareStatement("insert into logement (description, Proprietaire_idProprietaire, Adresse_idAdresse, Disponibilite_idDisponibilite)values(?,?,?,?)");
                state.setString(1, descriptionf);
                state.setString(2, idproriof);
                state.setInt(3, idadresse); 
                state.setInt(4, iddisponibilite);
                state.executeUpdate();
                
                
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("succesl.html"); 
                requestDispatcher.forward(request, response);
                
                
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
	
	

			 }}}
}
