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
	int cant_nodos;
	int [] distancias;
	int [] camino;
	int[][] grafo;
	
	
	public Dijkstra(int nodo_inicial, int[][] grafo,int cant_nodos) {
		this.grafo = grafo;
		// genero el conjunto w
		//this.w = new ArrayList<Integer>();
		//this.w.add(nodo_inicial); // Agrego al nodo objetivo al conjunto w 
		
		
		// genero el conjunto v con todos los nodos restantes
		this.v = new ArrayList<Integer>();
		for (int i = 0; i < cant_nodos ; i++) {
			if(i!=nodo_inicial)
				this.v.add(i);
		}
		this.distancias = new int[cant_nodos];
		this.camino = new int[cant_nodos];
		this.cant_nodos=cant_nodos;
		
	}
	
	public void  calculo() {
		
		
		// distancias iniciales
		for (int i = 0; i < distancias.length; i++) {
				distancias[i]=grafo[nodo_inicial][i];
		}
		distancias[nodo_inicial]=0;
		int n,dis;
		while(!v.isEmpty()) {
			n = removerNconPesoMenor();
			for (int i = 0; i < cant_nodos ; i++) {
				if(grafo[n][i]!=Integer.MAX_VALUE){
					dis=distancias[n]+grafo[n][i];
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
