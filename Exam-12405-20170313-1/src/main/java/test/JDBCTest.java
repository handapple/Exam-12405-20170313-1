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
		film.setTitle("����Σ��5");
		film.setDescription("�ƻá����Ƭ");
		film.setLanguage("US");
		System.out.println(new FilmService().addFilm(film));
	}
}
