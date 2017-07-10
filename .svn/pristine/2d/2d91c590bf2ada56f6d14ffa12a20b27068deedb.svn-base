package be.steformations.pc.java_data.comics.dao.managers.spring_jdbc;

import be.steformations.java_data.comics.interfaces.dao.managers.FabriqueManagers;
import be.steformations.java_data.comics.interfaces.dao.managers.GenreManager;
import be.steformations.java_data.comics.interfaces.dao.managers.PersonnageManager;

public class SpringJdbcFabriqueManager implements FabriqueManagers {

	private GenreManager genreManager;
	private PersonnageManager personnageManager;
	
	public SpringJdbcFabriqueManager() {
		super();
		javax.sql.DataSource dataSource 
			= new org.springframework.jdbc.datasource.DriverManagerDataSource("jdbc:postgresql://localhost/comics-java", "postgres", "postgres");
		org.springframework.jdbc.core.JdbcTemplate jdbcTemplate
			= new org.springframework.jdbc.core.JdbcTemplate(dataSource);
		this.genreManager = new SpringJdbcDaoGenre(jdbcTemplate);
		this.personnageManager = new SpringJdbcDaoPersonnage(jdbcTemplate);
	}
	
	@Override
	public PersonnageManager getPersonnageManager() {
		return this.personnageManager;
	}

	@Override
	public GenreManager getGenreManager() {
		return this.genreManager;
	}

}
