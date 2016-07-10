package be.vdab.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/meisjesjongens")
public class MeisjesJongensServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private static final String VIEW = "/WEB-INF/JSP/meisjesjongens.jsp"; 
	private static final int COOKIE_MAXIMUM_LEEFTIJD = 60 /* seconden */ * 30 /* minuten */;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// zie in de doPost : geen conversie nodig
		req.getRequestDispatcher(VIEW).forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		Cookie cookie = new Cookie("geslacht", 
				// encoding is hier overbodig, ik kan dan ook via de cookie eraan in de jsp
				// URLEncoder.encode(req.getParameter("geslacht"), "UTF-8"));
				req.getParameter("geslacht"));				
		cookie.setMaxAge(COOKIE_MAXIMUM_LEEFTIJD);
		resp.addCookie(cookie);
		resp.sendRedirect(req.getRequestURI());		
	}	

}
