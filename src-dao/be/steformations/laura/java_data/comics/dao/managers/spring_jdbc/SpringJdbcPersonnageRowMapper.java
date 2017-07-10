package be.steformations.laura.java_data.comics.dao.managers.spring_jdbc;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import be.steformations.laura.java_data.comics.dao.beans.GenreImpl;
import be.steformations.laura.java_data.comics.dao.beans.PersonnageImpl;

public class SpringJdbcPersonnageRowMapper implements org.springframework.jdbc.core.RowMapper<PersonnageImpl>{

	@Override
	public PersonnageImpl mapRow(ResultSet rs, int rownum) throws SQLException {
		PersonnageImpl personnage = null;
		GenreImpl genre = null;
		
		int id = rs.getInt(1);
		String prenom = rs.getString(2);
		String nom = rs.getString(3);
		String aka = rs.getString(4);
		Date ddn = rs.getDate(5);
		int numGenre = rs.getInt(6);
		if(! rs.wasNull()){
			String nomGenre = rs.getString(7);
			genre = new GenreImpl();
			genre.setId(numGenre);
			genre.setNom(nomGenre);
		}
		personnage = new PersonnageImpl();
		personnage.setId(id);
		personnage.setPrenom(prenom);
		personnage.setNom(nom);
		personnage.setAka(aka);
		personnage.setDdn(ddn);
		personnage.setGenre(genre);
		
		return personnage;
	}
	
}
