package be.steformations.java_data.comics.tests.dao;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.Calendar;

import org.junit.Test;

import be.steformations.java_data.comics.interfaces.dao.beans.Genre;
import be.steformations.java_data.comics.interfaces.dao.beans.Personnage;
import be.steformations.java_data.comics.interfaces.dao.managers.GenreManager;
import be.steformations.java_data.comics.interfaces.dao.managers.PersonnageManager;

public class _07_TestInsertPersonnage {

	@Test
	public void testInsertPersonnage() {
		try {
			PersonnageManager personnageManager = FabriqueTestsComicsDao.getFabriqueManagers().getPersonnageManager();
			assertNotNull(personnageManager);
			GenreManager genreManager = FabriqueTestsComicsDao.getFabriqueManagers().getGenreManager();
			assertNotNull(genreManager);

			Genre genre = genreManager.getGenre("Marvel");
			assertNotNull(genre);

			Calendar c = Calendar.getInstance();
			c.clear();
			c.set(1962, 2, 1);
			Date ddn = new Date(c.getTimeInMillis());

			long millis = System.currentTimeMillis();

			Personnage personnage = personnageManager.creerPersonnage("Bruce" + millis, "Banner", "Hulk", ddn, genre);
			assertNotNull(personnage);
			int id = personnage.getId();
			assertTrue(id > 0);

			personnage = personnageManager.getPersonnage(id);
			assertNotNull(personnage);
			assertEquals("Bruce" + millis, personnage.getPrenom());
			assertEquals("Banner", personnage.getNom());
			assertEquals("Hulk", personnage.getAka());
			assertEquals(ddn.getTime(), personnage.getDdn().getTime());
			assertEquals("Marvel", personnage.getGenre().getNom());
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

}
