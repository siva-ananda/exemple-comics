package be.steformations.laura.java_data.comics.dao.managers.spring_jdbc;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import be.steformations.laura.java_data.comics.dao.beans.AventureImpl;
import be.steformations.laura.java_data.comics.dao.beans.GenreImpl;
import be.steformations.laura.java_data.comics.dao.beans.PersonnageImpl;

public class SpringJdbcAventureRowMapper implements org.springframework.jdbc.core.RowMapper<AventureImpl>{

	@Override
	public AventureImpl mapRow(ResultSet rs, int rownum) throws SQLException {
		AventureImpl aventure = null;
		
		int id = rs.getInt("id");
		String titre = rs.getString("titre");
		
		aventure = new AventureImpl();
		aventure.setId(id);
		aventure.setTitre(titre);
		
		return aventure;
	}

}
