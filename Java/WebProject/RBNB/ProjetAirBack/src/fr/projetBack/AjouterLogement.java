package fr.projetBack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.projet.beans.Catalogue;
import fr.projet.beans.Logement;

/**
 * Servlet implementation class AjouterLogement
 */
@WebServlet("/AjouterLogement")
public class AjouterLogement extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjouterLogement() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String description = request.getParameter("description");
	
	Logement nouveau= new Logement(); 
	nouveau.setDescription(description);
	
	Catalogue.catalogueLogement.add(nouveau); 
	 
	response.setContentType("text/html");
	PrintWriter out = response.getWriter(); 
out.println("<html><body>  ");
out.println("le film a bien été crée !");
out.println("</body><html>");
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
