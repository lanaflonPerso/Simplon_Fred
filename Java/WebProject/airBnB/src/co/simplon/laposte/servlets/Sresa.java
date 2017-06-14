package co.simplon.laposte.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.simplon.laposte.bean.Bresa;
import co.simplon.laposte.dao.Dresa;

@WebServlet("/ajouterResa")
public class Sresa extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/Vplanning.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String debut   = request.getParameter("deb");
		String fin     = request.getParameter("fin");
		
		Bresa resaB = new Bresa();
		resaB.setDebut(debut);
		resaB.setFin(fin);
		
		Dresa resaD = new Dresa();
		try {
			resaD.seConnecter();
			resaD.ajouterResa(resaB);
			resaD.seDeconnecter();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		this.getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
	}

}
