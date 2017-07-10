package be.steformations.laura.java_data.comics.dao.managers.jpa;

import be.steformations.java_data.comics.interfaces.dao.managers.FabriqueManagers;
import be.steformations.java_data.comics.interfaces.dao.managers.GenreManager;
import be.steformations.java_data.comics.interfaces.dao.managers.PersonnageManager;

public class JpaFabriqueManager implements FabriqueManagers {

	private PersonnageManager personnageManager;
	private GenreManager genreManager;
	
	public JpaFabriqueManager() {
		super();
		javax.persistence.EntityManager em = javax.persistence.Persistence.createEntityManagerFactory("postgresql_eclipselink").createEntityManager();
		this.personnageManager = new JpaDaoPersonnage(em);
		this.genreManager = new JpaDaoGenre(em);
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
