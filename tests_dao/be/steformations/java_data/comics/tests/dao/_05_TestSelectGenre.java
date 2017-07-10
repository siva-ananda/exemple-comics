package be.steformations.java_data.comics.tests.dao;

import static org.junit.Assert.*;

import org.junit.Test;

import be.steformations.java_data.comics.interfaces.dao.beans.Genre;
import be.steformations.java_data.comics.interfaces.dao.managers.GenreManager;

public class _05_TestSelectGenre {

	@Test
	public void testSelectGenre() {
		try {
			GenreManager manager = FabriqueTestsComicsDao.getFabriqueManagers().getGenreManager();
			assertNotNull(manager);

			Genre genre = manager.getGenre("DC Comics");

			assertNotNull(genre);
			assertEquals("DC Comics", genre.getNom());

			genre = manager.getGenre("Text Avery");
			assertNull(genre);
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

}
