package be.vdab.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.vdab.repositories.IngredientenRepository;
import be.vdab.repositories.SausRepository;

@WebServlet("/ingredienten")
public class IngredientServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private static final String VIEW = "/WEB-INF/JSP/ingredienten.jsp";

	private final IngredientenRepository ingredientenRepository = new IngredientenRepository();
	private final SausRepository SausRepository = new SausRepository();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// extra JD: keuzelijst met ingredienten
		// vanaf hier zou ik dus voor een class Ingredienten opteren (vandaar de
		// IngredientenRepository)
		req.setAttribute("ingredienten", ingredientenRepository.findAll());

		if (req.getQueryString() != null) {
			if (req.getParameter("ingredient") != null && !req.getParameter("ingredient").trim().isEmpty()) {
				req.setAttribute("sauzenEnkelIngredient",
						SausRepository.findByHasIngredient(req.getParameter("ingredient")));
			}
			if (req.getParameterValues("ingredienten") != null) {
				req.setAttribute("sauzenMeerdereIngredienten",
						SausRepository.findByHasIngredient(req.getParameterValues("ingredienten")));
			}
			if (req.getParameterValues("ingredientenAlle") != null) {
				req.setAttribute("sauzenAlleIngredienten",
						SausRepository.findByHasAllIngredients(req.getParameterValues("ingredientenAlle")));
			}
		}
		req.getRequestDispatcher(VIEW).forward(req, resp);
	}

}
