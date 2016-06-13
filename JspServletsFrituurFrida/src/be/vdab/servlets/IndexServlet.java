package be.vdab.servlets;

import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.vdab.exceptions.PostCodeException;
import be.vdab.valueobjects.Adres;
import be.vdab.valueobjects.Gemeente;

/**
 * Servlet implementation class IndexServlet	
 */
@WebServlet(urlPatterns="/index.htm", name="indexServlet")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final String VIEW = "/WEB-INF/JSP/index.jsp";
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Adres adres = null;
		try {
			adres = new Adres("Somersstraat", "70A", new Gemeente("Antwerpen", 2000));
		} catch (PostCodeException | NullPointerException | IllegalArgumentException e) {
			// TODO deftige logging voor in de praktijk...
			e.printStackTrace();
		}
		request.setAttribute("adres", adres);
		DayOfWeek today = LocalDate.now().getDayOfWeek();
		request.setAttribute("openGesloten", 
				((today.equals(DayOfWeek.MONDAY) || today.equals(DayOfWeek.THURSDAY)? "gesloten" : "open")));
		request.setAttribute("telefoonnummerHelpdesk", this.getServletContext().getInitParameter("telefoonnummerHelpdesk"));
		request.getRequestDispatcher(VIEW).forward(request, response);
	}

}
