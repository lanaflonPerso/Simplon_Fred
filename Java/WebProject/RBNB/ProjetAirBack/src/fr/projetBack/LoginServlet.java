package fr.projetBack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Cookie[] cookies = request.getCookies();

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.println("<html><body>");
		out.println("<form method=\"POST\" action=\"login\">");
		out.println("login:<input type=\"text\" name=\"username\" />");
		 if (cookies!=null){
			 for (Cookie cookie : cookies) {
				 if (cookie.getName().equals("login")){
					 out.println("value=\""+cookie.getValue()+"\"");
				 }
				
			}
		 }
		out.println("/>");
		out.println("password: <input type=\"password\" name=\"pass\">");
		out.println("<input type=\"submit\" value=\"go\"/>");

		out.println("</form>");
		out.println("</body><html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String login = request.getParameter("username");
		String password = request.getParameter("pass");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><body>");

		if (login.equals("admin") && password.equals("12345")) {
			out.println("Vous êtes bien identifiés !");
			Cookie cookie = new Cookie("login", login);
			response.addCookie(cookie);
			
		} else {
			out.println("Erreur d'authenfication !");
		}

		out.println("</body><html>");
	}

}
