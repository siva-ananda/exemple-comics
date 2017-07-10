package be.steformations.java_data.comics.tests.jdbc;

import static org.junit.Assert.*;

import org.junit.Test;

import be.steformations.java_data.comics.interfaces.jdbc.ComicsJDBC;

public class _5_TestUpdateAKA {

	@Test
	public void testUpdatePersonnage() {
		try {
			ComicsJDBC db = FabriqueComicsJDBC.getComicsJDBC();
			assertNotNull(db);
			
			db.updateAka("Clark", "Kent", "Zuperman");
			String aka = db.selectAka("Clark", "Kent");
			assertNotNull(aka);
			assertEquals("Zuperman", aka);
			
			db.updateAka("Clark", "Kent", null);
			aka = db.selectAka("Clark", "Kent");
			assertNull(aka);
			
			db.updateAka("Clark", "Kent", "Superman");
			aka = db.selectAka("Clark", "Kent");
			assertNotNull(aka);
			assertEquals("Superman", aka);
			
		} catch(Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
		
	}

}
