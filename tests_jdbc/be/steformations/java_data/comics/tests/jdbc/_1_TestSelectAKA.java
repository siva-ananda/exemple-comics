package be.steformations.java_data.comics.tests.jdbc;

import static org.junit.Assert.*;

import org.junit.Test;

import be.steformations.java_data.comics.interfaces.jdbc.ComicsJDBC;

public class _1_TestSelectAKA {

	@Test
	public void testSelectAka() {
		try {
			ComicsJDBC db = FabriqueComicsJDBC.getComicsJDBC();
			assertNotNull(db);
			
			String aka = db.selectAka("Clark", "Kent");
			assertNotNull(aka);
			assertEquals("Superman", aka);
			
			aka = db.selectAka("Mickey", "Mouse");
			assertNull(aka);
			
			aka = db.selectAka("X", "X");
			assertNull(aka);
			
			aka = db.selectAka("Clark", null);
			assertNull(aka);
			
			aka = db.selectAka(null, "Kent");
			assertNull(aka);			
			
		} catch(Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

}
