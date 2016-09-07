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

@WebServlet("/zoekdefriet")
public class ZoekdeFrietServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private static final String VIEW = "/WEB-INF/JSP/zoekdefriet.jsp";

	// aanpak door aparte Spel class valt ook wel iets voor te zeggen
	// met mijn flexibele aanpak vgl met vb opl is het een beetje dubbel : 
	// view dinges in class? indien niet blijft er hier veel vertaling booleans staan
	// zie deur ipv deurtoe
	private final static String DEUREN_STATUS = "deuren";
	private final static String DEUR_OPEN = "deuropen";
	private final static String DEUR_TOE = "deur";//deurtoe
	private final static String DEUR_GEVONDEN = "gevonden";
	private final static String DE_FRIET = "defriet";
	private static final int AANTAL_DEUREN = 7;
	private static final String VOLGNUMMER = "volgnummer";

	private final static String OPNIEUW = "nieuwspel";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		if (session == null || session.getAttribute(DEUREN_STATUS) == null) {
			List<String> deuren = new ArrayList<String>();
			for (int i = 0; i < AANTAL_DEUREN; i++) {
				deuren.add(DEUR_TOE);
			}
			req.setAttribute(DEUREN_STATUS, deuren);
		}
		req.getRequestDispatcher(VIEW).forward(req, resp);
	}

	// TODO nog zien of deze annotation toch niet op een kleinere scope kan 
	// worden gezet (toch opteren voor wat extra local var's?)
	@SuppressWarnings("unchecked")
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO try-catch, foutpagina of melding; friet gevonden => niet verder spelen & ...
		HttpSession session = req.getSession();	
//			System.out.println("/////////" +  req.getParameter(OPNIEUW));
		if (req.getParameter(OPNIEUW) != null) {
			session.invalidate();
		} else {
			int deFriet;
			List<String> deuren;
			if (session.getAttribute(DE_FRIET) == null) {
				deFriet = new Random().nextInt(AANTAL_DEUREN);
				session.setAttribute(DE_FRIET, deFriet);
			} else {
				deFriet = (int) session.getAttribute(DE_FRIET);
			}
			if (session.getAttribute(DEUREN_STATUS) == null) {
				deuren = new ArrayList<String>();
				for (int i = 0; i < AANTAL_DEUREN; i++) {
					deuren.add(DEUR_TOE);
				}
			} else {
				deuren = (List<String>) session.getAttribute(DEUREN_STATUS);				
			}		
			// TODO door wijzigen aanpak in jsp dit eens herbekijken (null check nog nut? is hidden field nu)
			if (req.getParameter(VOLGNUMMER) != null) {
				int volgnummer = Integer.parseInt(req.getParameter(VOLGNUMMER));
				if (volgnummer == deFriet) {
					deuren.set(volgnummer, DEUR_GEVONDEN);
				} else {
					deuren.set(volgnummer, DEUR_OPEN);
				}
				session.setAttribute(DEUREN_STATUS, deuren);
			}
		}
		resp.sendRedirect(resp.encodeRedirectURL(req.getRequestURI()));
	}
}
