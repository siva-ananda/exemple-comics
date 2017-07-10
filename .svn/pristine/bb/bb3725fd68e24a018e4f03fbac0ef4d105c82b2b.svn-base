package be.steformations.pc.java_data.comics.dao.managers.spring_jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import be.steformations.pc.java_data.comics.dao.beans.AventureImpl;

public class SpringJdbcAventureRowMapper 
	implements org.springframework.jdbc.core.RowMapper<AventureImpl>{

	@Override
	public AventureImpl mapRow(ResultSet rs, int rownum) throws SQLException {
		AventureImpl aventure = null;
		
		Integer id = rs.getInt("id");
		String titre = rs.getString("titre");
		
		aventure = new AventureImpl();
		aventure.setId(id);
		aventure.setTitre(titre);
		
		return aventure;
	}

}
