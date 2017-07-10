package be.steformations.java_data.comics.tests.jdbc;

import static org.junit.Assert.*;

import org.junit.Test;

import be.steformations.java_data.comics.interfaces.jdbc.ComicsJDBC;

public class _2_TestSelectGenre {

	@Test
	public void testSelectGenre() {
		try {
			ComicsJDBC db = FabriqueComicsJDBC.getComicsJDBC();
			assertNotNull(db);
		
			String genre = db.selectGenre("Clark", "Kent");
			assertNotNull(genre);
			assertEquals("DC Comics", genre);
		
			genre = db.selectGenre("Betty", "Boop");
			assertNull(genre);
			
			genre = db.selectGenre("X", "X");
			assertNull(genre);
			
			genre = db.selectGenre("Clark", null);
			assertNull(genre);
			
			genre = db.selectGenre(null, "Kent");
			assertNull(genre);			
			
		} catch(Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

}
