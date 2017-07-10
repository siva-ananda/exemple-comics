package be.steformations.java_data.comics.tests.dao;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

import be.steformations.java_data.comics.interfaces.dao.beans.Personnage;
import be.steformations.java_data.comics.interfaces.dao.managers.PersonnageManager;

public class _02_TestSelectPersonnageAvecID {

	@Test
	public void testSelectPersonnageInt() {
		try {
			PersonnageManager manager = FabriqueTestsComicsDao.getFabriqueManagers().getPersonnageManager();
			assertNotNull(manager);

			int id = 0;
			Personnage personnage = null;
			Calendar c = Calendar.getInstance();
			c.clear();
			c.set(1938, 5, 1);
			Date ddn = new Date( c.getTimeInMillis() );

			id = manager.getPersonnage("Clark", "Kent").getId();
			personnage = manager.getPersonnage(id);

			assertNotNull(personnage);
			assertEquals("Clark", personnage.getPrenom());
			assertEquals("Kent", personnage.getNom());
			assertEquals("Superman", personnage.getAka());
			assertEquals(ddn, personnage.getDdn());

			personnage = manager.getPersonnage(0);
			assertNull(personnage);
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}

	}

}
