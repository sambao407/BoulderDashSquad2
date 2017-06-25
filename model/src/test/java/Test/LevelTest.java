package Test.Orla;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class LevelTest {
	private int levelsize;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		levelsize = 25;
	}

	@Test
	public void testSetLevelsize() {
		fail("Not yet implemented");
	}

	@Test
	public int testGetLevelsize() {
		return levelsize = 1000;
	}

}
