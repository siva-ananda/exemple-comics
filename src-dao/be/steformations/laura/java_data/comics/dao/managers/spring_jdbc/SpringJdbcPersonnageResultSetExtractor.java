package be.steformations.laura.java_data.comics.dao.managers.spring_jdbc;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;

import be.steformations.laura.java_data.comics.dao.beans.GenreImpl;
import be.steformations.laura.java_data.comics.dao.beans.PersonnageImpl;

public class SpringJdbcPersonnageResultSetExtractor implements org.springframework.jdbc.core.ResultSetExtractor<PersonnageImpl>{

	@Override
	public PersonnageImpl extractData(ResultSet rs) throws SQLException, DataAccessException {
		PersonnageImpl personnage = null;
		
		if(rs.next()){ //ou while si on a besoin de plusieurs lignes
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
		
		}
		
		return personnage;
	}

}
