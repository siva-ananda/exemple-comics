package be.steformations.java_data.comics.tests.dao;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.Calendar;

import org.junit.Test;

import be.steformations.java_data.comics.interfaces.dao.beans.Personnage;
import be.steformations.java_data.comics.interfaces.dao.managers.PersonnageManager;

public class _01_TestSelectPersonnageAvecPrenomEtNom {

	@Test
	public void testSelectPersonnageStringString() {
		try {
			PersonnageManager manager = FabriqueTestsComicsDao.getFabriqueManagers().getPersonnageManager();
			assertNotNull(manager);
			
			Calendar c = Calendar.getInstance();
			c.clear();
			c.set(1938, 5, 1);
			Date ddn = new Date( c.getTimeInMillis() );
			
			Personnage personnage = null;
			personnage = manager.getPersonnage("Clark", "Kent");
	
			assertNotNull(personnage);
			assertEquals("Clark", personnage.getPrenom());
			assertEquals("Kent", personnage.getNom());
			assertEquals("Superman", personnage.getAka());
			
			assertEquals(ddn, personnage.getDdn());
			
			personnage = manager.getPersonnage("Bugs", "Bunny");
	
			assertNull(personnage);
		} catch(Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

}
