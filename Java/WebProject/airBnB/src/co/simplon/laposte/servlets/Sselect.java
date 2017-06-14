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

@WebServlet("/selection")
public class Sselect extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Request.setAttribute("nom", valeur);
		this.getServletContext().getRequestDispatcher("/WEB-INF/Vselect.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idLogement = 1;//request.getParameter("Select");
		
		Bresa selectB = new Bresa();
		selectB.setId(idLogement);
		
		Dresa selectD = new Dresa();
		try {
			selectD.seConnecter();
			selectD.ajouterResa(selectB);
			selectD.seDeconnecter();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		this.getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);		
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
