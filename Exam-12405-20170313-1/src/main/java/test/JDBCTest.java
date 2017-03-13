package test;

import java.util.List;

import domain.Film;
import service.FilmService;

public class JDBCTest {
	public static void main(String[] args) {
		/*List<Film> list = new FilmService().getResultList();
		for(Film f : list){
			System.out.println(f.getDescription());
		}*/
		Film film =new Film();
		film.setTitle("生化危机5");
		film.setDescription("科幻、惊悚片");
		film.setLanguage("US");
		System.out.println(new FilmService().addFilm(film));
	}
}
