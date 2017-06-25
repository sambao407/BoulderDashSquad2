package Test.Orla;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class EntityTest {
	 private int spritesize = 25;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		spritesize = 0;
	}

	@Test
	public void testGetSpritesize() {
		spritesize = - 100;
	}

}
