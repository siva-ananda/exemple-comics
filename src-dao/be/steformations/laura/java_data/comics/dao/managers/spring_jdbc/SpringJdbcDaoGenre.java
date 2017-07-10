package be.steformations.laura.java_data.comics.dao.managers.spring_jdbc;

import java.util.List;

import be.steformations.java_data.comics.interfaces.dao.beans.Genre;
import be.steformations.java_data.comics.interfaces.dao.beans.Personnage;
import be.steformations.java_data.comics.interfaces.dao.managers.GenreManager;
import be.steformations.laura.java_data.comics.dao.beans.GenreImpl;

public class SpringJdbcDaoGenre implements GenreManager {

	private org.springframework.jdbc.core.JdbcTemplate jdbcTemplate;
	
	
	public SpringJdbcDaoGenre(org.springframework.jdbc.core.JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}


	@Override
	public Genre getGenre(String nom) {
		GenreImpl genre = null;
		
		if(nom != null){
			String sql = "select num, nom from genres where lower(nom) = lower(?)";
			try {
			java.util.Map<String, Object> map = this.jdbcTemplate.queryForMap(sql, nom);
				if (! map.isEmpty()){
					Integer id = (Integer) map.get("num");
					String name = (String) map.get("nom");
					genre = new GenreImpl();
					genre.setId(id);
					genre.setNom(name);
				}
			}catch(org.springframework.dao.EmptyResultDataAccessException e){
				
			}
		}
		return genre;
	}


	@Override
	public List<? extends Personnage> getPersonnages(String nom) {
		// TODO Auto-generated method stub
		return null;
	}
	
}

