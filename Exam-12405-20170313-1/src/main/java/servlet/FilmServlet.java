package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Film;
import service.FilmService;

public class FilmServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String operate = req.getParameter("operate");
		if(operate != null && "add".equals(operate)){
			addFilm(req, resp);
		} else if ("update".equals(operate)){
			updateFilm(req, resp);
		} else if ("delete".equals(operate)){
			deleteFilm(req, resp);
		}
	}
	
	protected void addFilm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String title = req.getParameter("title");
		String description = req.getParameter("description");
		String language = req.getParameter("language");
		Film film = new Film();
		film.setTitle(title);
		film.setDescription(description);
		film.setLanguage(language);
		if(new FilmService().addFilm(film)){
			getServletContext().getRequestDispatcher("/index.jsp")
			.forward(req, resp);
		}
	}
	
	protected void updateFilm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int film_id = Integer.parseInt(req.getParameter("film_id"));
		String title = req.getParameter("title");
		String description = req.getParameter("description");
		String language = req.getParameter("language");
		System.out.println("title" + title);
		Film film = new Film(film_id, title, description, language);
		if(new FilmService().updateFilm(film)){
			getServletContext().getRequestDispatcher("/index.jsp")
			.forward(req, resp);
		}
	}
	
	protected void deleteFilm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int film_id = Integer.parseInt(req.getParameter("film_id"));
		Film film = new Film();
		film.setFilm_id(film_id);
		if(new FilmService().deleteFilm(film)){
			getServletContext().getRequestDispatcher("/index.jsp")
			.forward(req, resp);
		}
	}
	
	
}
