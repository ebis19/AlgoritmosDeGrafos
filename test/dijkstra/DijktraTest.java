package dijkstra;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import grafos.Grafo;

public class DijktraTest {

	@Test
	public void grafoCarpeta() {

		int i = Integer.MAX_VALUE;
		Grafo grafo = new Grafo(5);
		grafo.setArista(1, 2, 4);// f c p
		grafo.setArista(1, 4, 1);
		grafo.setArista(1, 5, 6);
		grafo.setArista(2, 3, 1);
		grafo.setArista(3, 5, 2);
		grafo.setArista(4, 3, 2);
		grafo.setArista(4, 5, 7);
		Dijkstra d = new Dijkstra(0, grafo);
		d.calculo();
		int[] dis = { 0, 4, 3, 1, 5 };
		int[] camino = { 1, 1, 4, 1, 3 };

		Assert.assertArrayEquals(dis, d.getDistancias());
		Assert.assertArrayEquals(camino, d.getCamino());
	}

	public void grafoUnsoloelemento() {

		int i = Integer.MAX_VALUE;
		Grafo grafo = new Grafo(1);
		Dijkstra d = new Dijkstra(0, grafo);
		d.calculo();
		int[] dis = { 0 };

		Assert.assertArrayEquals(dis, d.getDistancias());
	}

	public void grafoVacio() {

		int i = Integer.MAX_VALUE;
		Grafo grafo = new Grafo(0);
		Dijkstra d = new Dijkstra(0, grafo);
		d.calculo();
		int[] dis = {};

		Assert.assertArrayEquals(dis, d.getDistancias());
	}

}
