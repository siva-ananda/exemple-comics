package be.steformations.java_data.comics.tests.jdbc;

import be.steformations.java_data.comics.interfaces.jdbc.ComicsJDBC;

public class FabriqueComicsJDBC {

	public static ComicsJDBC getComicsJDBC() {
		//return new be.steformations.laura.java_data.comics.ComicsJdbcImpl(); 
		//return new be.steformations.laura.java_data.comics.ComicsSpringJdbcImpl("jdbc:postgresql://localhost:5432/comics-java", "postgres", "postgres"); 
		return (ComicsJDBC) new be.steformations.laura.java_data.comics.dao.managers.jpa.JpaFabriqueManager(); 
	}
}
