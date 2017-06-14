package co.simplon.laposte.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.simplon.laposte.bean.Bproprio;
import co.simplon.laposte.dao.Dproprio;

@WebServlet("/creerProprio")
public class Sproprio extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/Vproprio.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nom       = request.getParameter("nom");
		String prenom    = request.getParameter("pre");
		String telephone = request.getParameter("tel");
		String mail      = request.getParameter("mel");
		
		Bproprio proprioB = new Bproprio();
		proprioB.setNom(nom);
		proprioB.setPrenom(prenom);
		proprioB.setTelephone(telephone);
		proprioB.setEmail(mail);
		
	Dproprio proprioD = new Dproprio();
	try {
		proprioD.seConnecter();
		proprioD.ajouterProprio(proprioB);
		proprioD.seDeconnecter();
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	this.getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
	
	}
}
