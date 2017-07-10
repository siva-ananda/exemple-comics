package be.steformations.java_data.comics.tests.jdbc;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import be.steformations.java_data.comics.interfaces.jdbc.ComicsJDBC;

public class _0_TestPing {

	@Test
	public void testPing() {
		try {
			ComicsJDBC db = FabriqueComicsJDBC.getComicsJDBC();
			assertNotNull(db);
			assertTrue(db.ping());
		} catch(Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

}
