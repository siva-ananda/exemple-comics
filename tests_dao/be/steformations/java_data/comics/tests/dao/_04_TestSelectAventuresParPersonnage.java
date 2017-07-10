package be.steformations.java_data.comics.tests.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import be.steformations.java_data.comics.interfaces.dao.beans.Aventure;
import be.steformations.java_data.comics.interfaces.dao.beans.Personnage;
import be.steformations.java_data.comics.interfaces.dao.managers.PersonnageManager;

public class _04_TestSelectAventuresParPersonnage {

	@Test
	public void testSelectAventures() {
		try {
			PersonnageManager manager = FabriqueTestsComicsDao.getFabriqueManagers().getPersonnageManager();
			assertNotNull(manager);

			Personnage personnage = null;
			List<? extends Aventure> aventures = null;
			personnage = manager.getPersonnage("Clark", "Kent");
			aventures = manager.getAventures(personnage.getId());

			assertNotNull(aventures);
			assertEquals(2, aventures.size());
			for (Aventure aventure : aventures) {
				String titre = aventure.getTitre();
				assertTrue(
						titre.equals("The Mightiest Team in the World") || titre.equals("Justice League Adventures"));
			}

			aventures = null;
			aventures = manager.getAventures(0);
			assertNotNull(aventures);
			assertEquals(0, aventures.size());
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

}
