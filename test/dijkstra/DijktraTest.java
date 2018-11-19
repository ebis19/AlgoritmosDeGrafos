package dijkstra;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class DijktraTest {

	
	@Test
	public void grafoCarpeta() {
		
		int i=Integer.MAX_VALUE;
		Grafo grafo = new Grafo(5); 
		grafo.setArista(1,2,4);//f c p 
		grafo.setArista(1,4,1);
		grafo.setArista(1,5,6);
		grafo.setArista(2,3,1);
		grafo.setArista(3,5,2);
		grafo.setArista(4,3,2);
		grafo.setArista(4,5,7);
		Dijkstra d =new Dijkstra(0, grafo);
				d.calculo();
		int [] dis ={0,4,3,1,5};
		
		Assert.assertArrayEquals(dis, d.distancias);
		} 

}
