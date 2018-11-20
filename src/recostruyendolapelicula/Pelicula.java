package recostruyendolapelicula;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import dijkstra.Dijkstra;
import grafos.Grafo;

/*
 * 
 * Author : Biscaia Elias
 * Complejidad O(N^2)
 * 
 */
public class Pelicula {

	ArrayList<Segmento> segmentos;
	Grafo grafo;
	int escenafinal;
	int cant_seg;
	ArrayList<Integer> nodosFinales;
	ArrayList<Integer> camino;

	public Pelicula(String archivo) throws FileNotFoundException {
		Scanner s = new Scanner(new File(archivo));
		nodosFinales = new ArrayList<Integer>();
		this.segmentos = new ArrayList<Segmento>();
		this.cant_seg = s.nextInt();
		this.escenafinal = s.nextInt();
		camino = new ArrayList<Integer>();
		for (int i = 0; i < this.cant_seg; i++) {
			this.segmentos.add(new Segmento(s.nextInt(), s.nextInt(), s.nextInt()));
		}

		s.close();
		generarGrafo();
		buscarNodosFinales();
	}

	public void generarGrafo() {
		this.grafo = new Grafo(segmentos.size());
		for (Segmento s1 : segmentos) {
			for (Segmento s2 : segmentos) {
				if (s1.contiene(s2))
					grafo.setArista(s1.nodo, s2.nodo, s1.calcularPeso(s2));
			}
		}
	}

	public void buscarNodosFinales() {

		for (Segmento s : segmentos) {
			if (escenafinal == s.ef)
				nodosFinales.add(s.nodo);
		}
	}

	public boolean encontrarCamino() {

		Dijkstra d = new Dijkstra(0, grafo);
		int[] c = d.getCamino();
		d.calculo();
		int[] dis = d.getDistancias();
		int menor = nodosFinales.get(0);
		for (Integer i : nodosFinales) {
			if (dis[i - 1] < dis[menor])
				menor = i;
		}
		if (dis[menor - 1] == Integer.MAX_VALUE)
			return false;

		while (menor != 1) {
			camino.add(0, menor);
			menor = c[menor - 1];
		}
		camino.add(0, 1);
		return true;

	}

	public String exportarSegmentos(String archivo) throws IOException {

		PrintWriter p = new PrintWriter(new File(archivo));
		String resultado = "NO ES POSIBLE";
		if (encontrarCamino()) {
			resultado = "";
			for (Integer i : camino) {
				resultado += i + " ";
			}
		}
		p.println(resultado);
		return resultado;
	}

}
