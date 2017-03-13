package service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.Film;
import utils.JDBCUtils;

public class FilmService {

	public List<Film> getResultList() {
		JDBCUtils jdbcUtils = new JDBCUtils();
		List<Film> list = new ArrayList<Film>();
		String sql = "select f.film_id,f.title,f.description,l.language from film f,language l where l.code=f.language;";
		ResultSet res = jdbcUtils.get_ResultSet(sql, null);
		try {
			while(res.next()){
				list.add(new Film(res.getInt("film_id"),res.getString("title"),res.getString("description"),res.getString("language")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public boolean addFilm(Film film){
		boolean result = false;
		JDBCUtils jdbcUtils = new JDBCUtils();
		String sql = "insert into film(title,description,language) values(?,?,?)";
		Object []obj = {film.getTitle(),film.getDescription(),film.getLanguage()};
		if(jdbcUtils.Update(sql, obj) >=1 ){
			result = true;
		}
		return result;
	}
	
	public boolean updateFilm(Film film){
		boolean result = false;
		JDBCUtils jdbcUtils = new JDBCUtils();
		String sql = "update film set title=?,description=?,language=? where film_id=?;";
		Object []obj = {film.getTitle(),film.getDescription(),film.getLanguage(),film.getFilm_id()};
		if(jdbcUtils.Update(sql, obj) >=1 ){
			result = true;
		}
		return result;
	}
	
	public boolean deleteFilm(Film film){
		boolean result = false;
		JDBCUtils jdbcUtils = new JDBCUtils();
		String sql = "delete from film where film_id=?;";
		Object []obj = {film.getFilm_id()};
		if(jdbcUtils.Update(sql, obj) >=1 ){
			result = true;
		}
		return result;
	}
	
	public Film queryFilm(int film_id){
		Film film = new Film();
		JDBCUtils jdbcUtils = new JDBCUtils();
		String sql = "delete from film where film_id=?;";
		Object []obj = {film_id};
		ResultSet res = jdbcUtils.get_ResultSet(sql, obj);
		try {
			if(res.next()){
				film.setFilm_id(res.getInt("film_id"));
				film.setTitle(res.getString("title"));
				film.setDescription(res.getString("description"));
				film.setLanguage(res.getString("language"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return film;
	}
}
