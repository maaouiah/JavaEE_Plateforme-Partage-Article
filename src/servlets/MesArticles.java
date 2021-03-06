package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controllers.ProfilCtlr;

import bean.News; 
/**
 * Servlet implementation class MesArticles
 */
@WebServlet("/mesArticles")
public class MesArticles extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MesArticles() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession() ;
		if (  session.getAttribute("user") != null ){
			
				ProfilCtlr profilCtlr = new ProfilCtlr();
				List<News> news =  profilCtlr.mesArticles(request);
				request.setAttribute("listeNews", news);
				this.getServletContext().getRequestDispatcher("/WEB-INF/views/listeNews.jsp").forward( request, response );
		
		}
		else{
			
			session.setAttribute("msgAll", "Veuillez vous connecter pour accèder à cette section");
			response.sendRedirect("/ProjetEE/index");
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
