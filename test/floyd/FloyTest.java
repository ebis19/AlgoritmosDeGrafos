package floyd;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

//import static org.junit.Assert.*;

import org.junit.Test;

import dijkstra.Grafo;

public class FloyTest {
	@Test
	public void floydTest() throws CloneNotSupportedException{

		Grafo g = new Grafo(3);
		g.setArista(1, 3, 8);
		g.setArista(2, 1, 5);
		g.setArista(3, 2, 3);
		int [][] fg= new Floyd(g).getCostosminimos();
		assertNotNull(fg);
		Grafo fgresultado = new Grafo(3);
		fgresultado.setArista(1, 1, 0);
		fgresultado.setArista(1, 2, 11);
		fgresultado.setArista(1, 3, 8);

		fgresultado.setArista(2, 1, 5);
		fgresultado.setArista(2, 2, 0);
		fgresultado.setArista(2, 3, 13);

		fgresultado.setArista(3, 1, 8);
		fgresultado.setArista(3, 2, 3);
		fgresultado.setArista(3, 3, 0);
	
		
		
		for (int i = 0; i < fgresultado.getCantN(); i++) {
			for (int j = 0; j < fgresultado.getCantN(); j++) {
				assertEquals(fgresultado.getPeso(i, j),fg[i][j] );
			}
		}
		
		//assertEquals(, actual);
	}
	
	

}
