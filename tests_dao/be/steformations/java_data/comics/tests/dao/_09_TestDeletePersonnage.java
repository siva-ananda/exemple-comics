package be.steformations.java_data.comics.tests.dao;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.Calendar;

import org.junit.Test;

import be.steformations.java_data.comics.interfaces.dao.beans.Personnage;
import be.steformations.java_data.comics.interfaces.dao.managers.PersonnageManager;

public class _09_TestDeletePersonnage {

	@Test
	public void testDeletePersonnage() {
		try {
			PersonnageManager manager = FabriqueTestsComicsDao.getFabriqueManagers().getPersonnageManager();

			Calendar c = Calendar.getInstance();
			c.clear();
			c.set(1962, 2, 1);
			Date ddn = new Date(c.getTimeInMillis());

			long millis = System.currentTimeMillis();

			Personnage personnage = manager.creerPersonnage("Bruce" + millis, "Banner", "Hulk", ddn, null);
			assertNotNull(personnage);
			manager.supprimerPersonnage(personnage.getId());
			personnage = manager.getPersonnage("Bruce" + millis, "Banner");
			assertNull(personnage);
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

}
