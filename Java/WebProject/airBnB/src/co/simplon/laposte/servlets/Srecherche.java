package co.simplon.laposte.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.simplon.laposte.bean.Brecherche;
import co.simplon.laposte.dao.Drecherche;


@WebServlet("/recherche")
public class Srecherche extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/Vrecherche.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ville = request.getParameter("vil");
		String debut = request.getParameter("deb");
		String fin   = request.getParameter("fin");
		
		Brecherche rechercheB = new Brecherche();
		rechercheB.setVille(ville);
		rechercheB.setDebut(debut);
		rechercheB.setFin(fin);
		
	Drecherche rechercheD = new Drecherche();
	try {
		rechercheD.seConnecter();
		rechercheD.dispon(rechercheB);
		rechercheD.seDeconnecter();
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	this.getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
	
	}
}
