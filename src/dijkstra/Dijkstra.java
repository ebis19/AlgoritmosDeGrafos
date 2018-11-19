package dijkstra;

import java.util.ArrayList;
import java.util.Iterator;


/*
 * 
 * En esta implementacion w no es necesario para la codificacion
 * solo para la logica 
 * ya que voy sacando de v los que pasan a w;
 * 
 * 
 * 
 * 
 * */


public class Dijkstra {
	
	//ArrayList<Integer> w;
	ArrayList<Integer> v;
	int nodo_inicial;
	int [] distancias;
	int [] camino;
	Grafo grafo;
	
	
	public Dijkstra(int nodo_inicial, Grafo grafo) {
		this.grafo = grafo;
		// genero el conjunto w
		//this.w = new ArrayList<Integer>();
		//this.w.add(nodo_inicial); // Agrego al nodo objetivo al conjunto w 
		
		
		// genero el conjunto v con todos los nodos restantes
		this.v = new ArrayList<Integer>();
		for (int i = 0; i < grafo.getCantN() ; i++) {
			if(i!=nodo_inicial)
				this.v.add(i);
		}
		this.distancias = new int[grafo.getCantN()];
		this.camino = new int[grafo.getCantN()];
		
	}
	
	public void  calculo() {
		
		
		// Distancias iniciales
		for (int i = 0; i < distancias.length; i++) {
				distancias[i]=grafo.getPeso(nodo_inicial,i);
		}
		// Camino Inicial
		for (int i = 0; i < distancias.length; i++) {
			camino[i]=nodo_inicial;
		}
		
		distancias[nodo_inicial]=0;
		int n,dis;
		while(!v.isEmpty()) {
			n = removerNconPesoMenor();
			for (int i = 0; i < grafo.getCantN() ; i++) {
				if(grafo.getPeso(n, i)!=Integer.MAX_VALUE){
					dis=distancias[n]+grafo.getPeso(n, i);
					if(dis<distancias[i])
						distancias[i]=dis;
				
				}
			}
		}
		
		
	
	}
	
	public int  removerNconPesoMenor() {
		int menor = v.get(0);
		for (int i : v) {
			if(distancias[i]<distancias[menor])	
				menor=i;
		}
		v.remove(v.indexOf(menor));
		return menor;
	
	}
	
		
		
		
	
	
	
	
	

}
