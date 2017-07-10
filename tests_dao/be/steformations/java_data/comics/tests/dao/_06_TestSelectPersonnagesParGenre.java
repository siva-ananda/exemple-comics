package be.steformations.java_data.comics.tests.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import be.steformations.java_data.comics.interfaces.dao.beans.Personnage;
import be.steformations.java_data.comics.interfaces.dao.managers.GenreManager;

public class _06_TestSelectPersonnagesParGenre {

	@Test
	public void testGetPersonnages() {
		try {
			GenreManager manager = FabriqueTestsComicsDao.getFabriqueManagers().getGenreManager();
			assertNotNull(manager);

			List<? extends Personnage> personnages = manager.getPersonnages("DC Comics");

			assertNotNull(personnages);
			assertEquals(2, personnages.size());
			for (Personnage personnage : personnages) {
				String aka = personnage.getAka();
				assertTrue(aka.equals("Superman") || aka.equals("Batman"));
			}

			personnages = manager.getPersonnages("Tex Avery");
			assertNotNull(personnages);
			assertEquals(0, personnages.size());
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

}
