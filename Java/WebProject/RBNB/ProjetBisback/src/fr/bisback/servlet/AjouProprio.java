package fr.bisback.servlet;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;

import fr.projet.beans.Adresse;
import fr.projet.beans.Proprietaire;

/**
 * Servlet implementation class AjouProprio
 */
@WebServlet("/AjouProprio")
public class AjouProprio extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AjouProprio() {
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

	protected void process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		{   
// recupération de valeur saisie dans le formulaire
			String nomf = request.getParameter("nom");
			String prenomf = request.getParameter("prenom");
			   //
			Connection conn = null;

			try {

				Class.forName("com.mysql.jdbc.Driver");
				System.out.println("Driver O.K.");
				String url = "jdbc:mysql://127.0.0.1:3306/projet";
				String user = "root";
				String passwd = "adminadmin";

				conn = (Connection) DriverManager.getConnection(url, user, passwd);
				System.out.println("Connexion effective !");
				
 // ajout du nom et prénom du  propriétaire dans la bbd
				PreparedStatement state = conn.prepareStatement("insert into proprietaire (nom,prenom)values(?,?)",
						new String[] { "idproprietaire" }); // préparation nécessaire pour choper id
				state.setString(1, nomf);
				state.setString(2, prenomf);
				state.executeUpdate();  
// obtenir l'idadresse qui va avec	
				ResultSet resultat = state.getGeneratedKeys(); 
				int idproprio = 0;
				if (resultat.next()) {
					idproprio = resultat.getInt(1); 

				}
//  pour l'affichage dans la jsp:  création d'un objetbean propio et attribution des données requetes par les set et get
				PreparedStatement state2 = conn.prepareStatement(
						"select * from proprietaire WHERE idproprietaire = ? ");
				state2.setInt(1, idproprio);

				ResultSet resultat2 = state2.executeQuery();
				Proprietaire p = new Proprietaire();
				if (resultat2.next()) {
					p.setId(resultat2.getInt("idproprietaire"));
					p.setNom(resultat2.getString("nom"));
					p.setPrenom(resultat2.getString("prenom"));
				}
// lier l'objet instancié  à l'attibut pour l'appel de l'affichage 
				request.setAttribute("proprietaire", p);
				
// basculer sur la jsp				
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("succesp.jsp");
				requestDispatcher.forward(request, response);

			} catch (Exception e) {
				System.out.println("Echec à la connexion");
			} finally {
				if (conn != null) {
					try {
						conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}

				}

			}
		}
	}
}
