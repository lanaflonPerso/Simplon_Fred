package projet.frontoffice;

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
 * Servlet implementation class ListeServlet
 */

public class ListeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	 process(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 process(request, response);
	}

	protected void process (HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
		  if (Catalogue.catalogueLogement.size()==0){
			  Logement logement1 = new Logement(); 
			  logement1.setDescription("vaste");
			  logement1.setIdentifiant(1);
			  
			  Catalogue.catalogueLogement.add(logement1);
			  
			  Logement logement2 = new Logement(); 
			  logement2.setDescription("Taudis");
			  logement2.setIdentifiant(2);
			  
			  Catalogue.catalogueLogement.add(logement2);
		  }
		  response.setContentType("text/html");
			PrintWriter out = response.getWriter(); 
			out.println("<html><body>");
			for (Logement vitrine : Catalogue.catalogueLogement) {
				out.println("<a href=\"descriptif?identifiant="+vitrine.getIdentifiant()+"\">");
				out.println(vitrine.getDescription());
				out.println("</a>");
				out.println("<BR>");
			}
			out.println("</body></html>");
	}
}
