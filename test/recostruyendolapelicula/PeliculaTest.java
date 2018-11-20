package recostruyendolapelicula;


import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;




public class PeliculaTest {
	
	@Test
	public void caso0() throws IOException {
		Pelicula p = new Pelicula("pelicula.in");
		int [] nf = {7,9};
	
		assertEquals("1 3 4 6 9 ",p.exportarSegmentos("pelicula.out"));
		
	}

}
