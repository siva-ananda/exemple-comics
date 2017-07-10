package be.steformations.java_data.comics.tests.dao;

import static org.junit.Assert.*;

import org.junit.Test;

import be.steformations.java_data.comics.interfaces.dao.beans.Personnage;
import be.steformations.java_data.comics.interfaces.dao.managers.PersonnageManager;

public class _08_TestUpdatePersonnage {

	@Test
	public void testUpdatePersonnage() {
		try {
			PersonnageManager manager = FabriqueTestsComicsDao.getFabriqueManagers().getPersonnageManager();
			assertNotNull(manager);

			int id = 0;
			Personnage personnage = manager.getPersonnage("Bruce", "Wayne");
			id = personnage.getId();
			manager.modifierPersonnage(id, "namtaB");
			personnage = null;
			personnage = manager.getPersonnage(id);

			assertNotNull(personnage);
			assertEquals("namtaB", personnage.getAka());
			manager.modifierPersonnage(id, "Batman");
			personnage = manager.getPersonnage(id);
			assertNotNull(personnage);
			assertEquals("Batman", personnage.getAka());
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}

	}

}
