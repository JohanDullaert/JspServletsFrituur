/**
 * 
 */
package be.vdab.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author Johan.Dullaert
 *
 */
@WebServlet("/zoekdefriet")
public class ZoekDeFrietServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private static final String VIEW = "WEB-INF/JSP/zoekdefriet.jsp";
	private static final String DEUREN_STATUS = "deuren";
	private static final String DE_FRIET = "deFriet";
	private static final int AANTAL_DEUREN = 7;
	private static final String DEURTOE = "deurtoe";
	private static final String DEUROPEN = "deuropen";	
	private static final String DEURGEVONDEN = "gevonden";
	
	@SuppressWarnings("unchecked") // voor de deuren uit de session...
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
		List<String> deuren;
		HttpSession session = req.getSession(false);
		if (session == null) {			
			deuren = new ArrayList<>();
			for (int i = 0; i < AANTAL_DEUREN; i++) {
				deuren.add(DEURTOE);
			}
			req.setAttribute(DEUREN_STATUS, deuren);
		} 
//		else {				
//			deuren = (List<String>) session.getAttribute(DEUREN_STATUS);			
//		}
//		req.setAttribute(DEUREN_STATUS, deuren);		
		req.getRequestDispatcher(VIEW).forward(req, resp);		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		// TODO best nog in een try-catch met foutpagina
		int volgnummer = Integer.parseInt(req.getParameter("volgnummer"));
		int deFriet;
		List<String> deuren = (List<String>) session.getAttribute(DEUREN_STATUS);
		if (deuren == null) {
			deFriet = (new Random()).nextInt(AANTAL_DEUREN);
			deuren = new ArrayList<>();
			for (int i = 0; i < AANTAL_DEUREN; i++) {
				deuren.add(DEURTOE);
			}
		}
		deFriet = (int) session.getAttribute(DE_FRIET);
	}	

}
