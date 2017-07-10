package be.steformations.laura.java_data.comics.dao.managers.jdbc;

import be.steformations.java_data.comics.interfaces.dao.managers.FabriqueManagers;
import be.steformations.java_data.comics.interfaces.dao.managers.GenreManager;
import be.steformations.java_data.comics.interfaces.dao.managers.PersonnageManager;

public class JdbcFabriqueManager implements FabriqueManagers {

	
	private String url = "jdbc:postgresql://localhost/comics-java";
	public String login = "postgres";
	public String pwd = "postgres";
	
	private PersonnageManager personnageManager;
	private GenreManager genreManager;
	
	public JdbcFabriqueManager() {
		super();
		this.genreManager = new JdbcDaoGenre(url, login, pwd);
		JdbcPersonnageDaoHelper helper = new JdbcPersonnageDaoHelper (url, login, pwd);
		this.personnageManager = new JdbcDaoPersonnage(helper);
		
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
