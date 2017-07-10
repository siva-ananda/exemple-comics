package be.steformations.java_data.comics.tests.dao;

import be.steformations.java_data.comics.interfaces.dao.managers.FabriqueManagers;

public class FabriqueTestsComicsDao {

	
	public static FabriqueManagers getFabriqueManagers() {
	//	return new be.steformations.laura.java_data.comics.dao.managers.jdbc.JdbcFabriqueManager();
		//return new be.steformations.laura.java_data.comics.dao.managers.spring_jdbc.SpringJdbcFabriqueManager();
		return new be.steformations.laura.java_data.comics.dao.managers.jpa.JpaFabriqueManager();
	}
}
