package dijkstra;

public class Grafo {
	int[][] matriz;
	int cant_nodos;

	public Grafo(int cant_nodos) {
		matriz = new int[cant_nodos][cant_nodos];
		for (int i = 0; i < cant_nodos; i++) {
			for (int j = 0; j < cant_nodos; j++) {
				matriz[i][j] = Integer.MAX_VALUE;
			}

		}
		this.cant_nodos = cant_nodos; 
	
		

	}
	
	public int getPeso(int i,int j) {
		return matriz[i][j];
	}
	

	public int getCantN() {
		
		return cant_nodos;
	}

	public void setArista(int f, int c, int p) {
		matriz[f-1][c-1]=p;
		
	}
}
