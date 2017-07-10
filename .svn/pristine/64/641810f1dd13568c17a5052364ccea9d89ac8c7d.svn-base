package be.steformations.java_data.comics.tests.jdbc;

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.Calendar;

import org.junit.Test;

import be.steformations.java_data.comics.interfaces.jdbc.ComicsJDBC;

public class _4_TestInsertPersonnage {

	@Test
	public void testInsertPersonnage() {
		try {
			ComicsJDBC db = FabriqueComicsJDBC.getComicsJDBC();
			assertNotNull(db);
	
			Calendar c = Calendar.getInstance();
			c.set(1962, 2, 1);
			long millis = c.getTimeInMillis();
			Date ddn = new Date( millis );
			
			int id = db.insertPersonnage("Bruce-" + millis, "Banner", "Hulk", ddn);
			assertTrue(id > 0);
			String aka = db.selectAka("Bruce-" + millis, "Banner");
			assertEquals("Hulk", aka);
			
			c.set(1934, 7, 9);
			millis = c.getTimeInMillis();
			ddn = new Date( millis );
			id = db.insertPersonnage("Donald-" + millis, "Duck", null, null);
			assertTrue(id > 0);
			aka = db.selectAka("Donald-" + millis, "Duck");
			assertNull(aka);
			
		} catch(Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

}
