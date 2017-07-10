package be.steformations.pc.java_data.comics.dao.managers.spring_jdbc;

import java.util.List;

import be.steformations.java_data.comics.interfaces.dao.beans.Genre;
import be.steformations.java_data.comics.interfaces.dao.beans.Personnage;
import be.steformations.java_data.comics.interfaces.dao.managers.GenreManager;
import be.steformations.pc.java_data.comics.dao.beans.GenreImpl;
import be.steformations.pc.java_data.comics.dao.beans.PersonnageImpl;

public class SpringJdbcDaoGenre implements GenreManager {

	private org.springframework.jdbc.core.JdbcTemplate jdbcTemplate;
	
	public SpringJdbcDaoGenre(org.springframework.jdbc.core.JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public Genre getGenre(String nom) {
		GenreImpl genre = null;
		
		if (nom != null) {
			String sql = "select num, nom from genres where lower(nom) = lower(?)";
			try {
				java.util.Map<String, Object> map = this.jdbcTemplate.queryForMap(sql, nom);
				if (! map.isEmpty()) {
					Integer id = (Integer) map.get("num");
					String name = (String) map.get("nom");
					genre = new GenreImpl();
					genre.setId(id);
					genre.setNom(name);
				}
			} catch(org.springframework.dao.EmptyResultDataAccessException e) {
				// pas de resultat
			}
		}
		
		return genre;
	}

	@Override
	public List<? extends Personnage> getPersonnages(String nom) {
		List<PersonnageImpl> liste = null;
		
		if (nom != null) {
			String sql = "select p.pk, p.prenom, p.nom, p.aka, p.ddn, g.num, g.nom "
					   + "from personnages as p left join genres as g on g.num = p.fk_genre "
					   + "where g.nom = ?";
			SpringJdbcPersonnageRowMapper mapper = new SpringJdbcPersonnageRowMapper();
			liste = this.jdbcTemplate.query(sql, mapper, nom);
		} else {
			liste = java.util.Collections.emptyList();
		}
		
		return liste;
	}

}
