package dijkstra;

public class Main {

	public static void main(String[] args) {
		
		//int[][] grafo = new int[5][5];
		int i=Integer.MAX_VALUE;
		int[][]  grafo= {{i,4,i,1,6},
						 {i,i,1,i,i},
						 {i,i,i,i,2},
						 {i,i,2,i,7},
						 {i,i,i,0,i}};
		Dijkstra d =new Dijkstra(0, grafo, 5);
				d.calculo();;
				
		System.out.println("------------");
		for (int j = 0; j < d.distancias.length; j++) {
			if(j!=0)
				System.out.println(d.distancias[j]+"");
}
		} 
					

	}


