package floyd;

import grafos.Grafo;

public class Floyd {

	// MatrizFloyd m;
	private int[][] mf;

	public Floyd(Grafo grafo) throws CloneNotSupportedException {
		mf = grafo.getMatriz().clone();

		for (int i = 0; i < grafo.getCantN(); i++) {
			mf[i][i] = 0;
		}
		int nuevopeso;
		for (int k = 0; k < grafo.getCantN(); k++) {
			for (int i = 0; i < grafo.getCantN(); i++) {
				for (int j = 0; j < grafo.getCantN(); j++) {
					if (mf[i][k] != Integer.MAX_VALUE && mf[k][j] != Integer.MAX_VALUE) {
						nuevopeso = mf[i][k] + mf[k][j];
						if (nuevopeso < grafo.getPeso(i, j)) {
							mf[i][j] = nuevopeso;
						}
					}
				}
			}
		}

	}

	public int[][] getCostosminimos() {
		return mf;
	}
	
	
	
	
	

}
