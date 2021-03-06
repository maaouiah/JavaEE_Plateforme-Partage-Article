package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controllers.CategorieCtlr;

/**
 * Servlet implementation class SupprimerCategorie
 */
@WebServlet("/deleteCat")
public class SupprimerCategorie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SupprimerCategorie() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession() ;
		if (  session.getAttribute("user") != null ){
			if (  request.getParameter("id") != null ){
				
					CategorieCtlr catCtlr = new CategorieCtlr();
					catCtlr.SupprimerCategorie(request);
					response.sendRedirect("/ProjetEE/categories");
					
			}
		}
		else{
			session.setAttribute("msgAll", "Veuillez vous connecter pour effectuer cette opération");
			response.sendRedirect("/ProjetEE/index");
		}
	}

}
