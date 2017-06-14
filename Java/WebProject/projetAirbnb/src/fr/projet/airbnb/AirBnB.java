package fr.projet.airbnb;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/srvAirbnb")
public class AirBnB extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AirBnB() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
	    String lnk=request.getParameter("tab");
		String lien="/";

		switch (lnk) {
			case "0":
			    lien="/";
				break;
			case "1":
			    lien="creerProprio.jsp";
				request.setAttribute("monLien", lien);
			    break;
			case "2":
			    lien="creerAppart.jsp";
				request.setAttribute("monLien", lien);
			    break;
			case "3":
			    lien="gererPlanning.jsp";
				request.setAttribute("monLien", lien);
			    break;
			case "4":
			    lien="rechercher.jsp";
				request.setAttribute("monLien", lien);
			    break;
			default:
			    break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
