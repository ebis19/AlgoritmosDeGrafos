package floyd;

import grafos.Grafo;

public class MatrizFloyd extends Grafo {

	public MatrizFloyd(int cant_nodos) {
		super(cant_nodos);
		for (int i = 0; i < cant_nodos; i++) {
			super.setArista(i, i, 0);
		}
	}

}
