package gusano;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class GusanoTest {

	@Test
	public void atest() throws IOException {
		Gusano g = new Gusano("gusano.in");
		 assertNotNull(g);
		assertEquals("5", g.encontrarPcs());
	}

}
