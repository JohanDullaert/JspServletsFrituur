package be.vdab.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.vdab.entities.Saus;

/**
 * Servlet implementation class SausServlet
 */
@WebServlet("/sauzen")
public class SausServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/WEB-INF/JSP/sauzen.jsp";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Saus> sauzen = new ArrayList<>();
		try {
			sauzen.add(new Saus(1, "mayonaise", new String[]{"ei", "olie", "mosterd"}));
			sauzen.add(new Saus(2, "cocktail", new String[]{}));
			sauzen.add(new Saus(2, "mosterd", new String[]{"chilli"}));
			sauzen.add(new Saus(2, "tartare", new String[]{"mayo", "pikkels"}));
			sauzen.add(new Saus(2, "vinaigrette", new String[]{"olie", "honing", "bieslook"}));
		} catch (Exception e) {
			// ignoring exception: I'm responsible for correct instances here...
			e.printStackTrace();
		}
		request.setAttribute("sauzen", sauzen);
		request.getRequestDispatcher(VIEW).forward(request, response);
	}

}
