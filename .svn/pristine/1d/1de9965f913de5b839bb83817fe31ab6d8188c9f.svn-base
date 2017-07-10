package be.steformations.java_data.comics.tests.jdbc;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import be.steformations.java_data.comics.interfaces.jdbc.ComicsJDBC;

public class _3_TestSelectPrenoms {

	@Test
	public void testSelectPersonnages() {
		try {
			ComicsJDBC db = FabriqueComicsJDBC.getComicsJDBC();
			assertNotNull(db);
			
			List<String> personnages = db.selectPrenoms("Disney");
			assertNotNull(personnages);
			assertEquals(2, personnages.size());
			assertTrue( personnages.contains("Mickey") );
			assertTrue( personnages.contains("Minerva") );
			
			personnages = db.selectPrenoms("Marvel");
			assertNotNull(personnages);
			assertEquals(0, personnages.size());
			
			personnages = db.selectPrenoms("Tex Avery");
			assertNotNull(personnages);
			assertEquals(0, personnages.size());
			
			personnages = db.selectPrenoms(null);
			assertNotNull(personnages);
			assertEquals(0, personnages.size());
			
		} catch(Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

}
