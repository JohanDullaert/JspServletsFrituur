package be.vdab.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.vdab.repositories.SausRepository;

/**
 * Servlet implementation class SausServlet
 */
@WebServlet("/sauzen")
public class SausServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/WEB-INF/JSP/sauzen.jsp";
	private final SausRepository sausRepository = new SausRepository();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// na 10 MVC niet meer nodig, nu via DAO (ofte Repository)
//		List<Saus> sauzen = new ArrayList<>();
//		try {
//			sauzen.add(new Saus(1, "mayonaise", new String[]{"ei", "olie", "mosterd"}));
//			sauzen.add(new Saus(2, "cocktail", new String[]{}));
//			sauzen.add(new Saus(3, "mosterd", new String[]{"chilli"}));
//			sauzen.add(new Saus(4, "tartare", new String[]{"mayo", "pikkels"}));
//			sauzen.add(new Saus(5, "vinaigrette", new String[]{"olie", "honing", "bieslook"}));
//		} catch (Exception e) {
//			// ignoring exception: I'm responsible for correct instances here...
//			e.printStackTrace();
//		}			 
		request.setAttribute("sauzen", sausRepository.findAll());
		request.getRequestDispatcher(VIEW).forward(request, response);
	}

}
