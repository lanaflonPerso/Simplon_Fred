package co.simplon.laposte.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.simplon.laposte.bean.Blogement;
import co.simplon.laposte.dao.Dlogement;

@WebServlet("/creerLogement")
public class Slogement extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/Vlogement.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String description = request.getParameter("des");
		String rue         = request.getParameter("rue");
		String code        = request.getParameter("cpl");
		String ville       = request.getParameter("vil");
		String type        = request.getParameter("typ");
		
		Blogement logementB = new Blogement();
		logementB.setDescription(description);
		logementB.setRue(rue);
		logementB.setCode(code);
		logementB.setVille(ville);
		logementB.setType(type);

		Dlogement logementD = new Dlogement();
		try {
			logementD.seConnecter();
			logementD.ajouterlogement(logementB);
			logementD.seDeconnecter();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
	}
	
}
