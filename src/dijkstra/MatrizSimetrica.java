package dijkstra;

public class MatrizSimetrica {

	private boolean []vec;
	private int n;
	public MatrizSimetrica(int n) {
		this.n=n;
		int t=n*(n-1)/2;
		vec = new boolean[t];
	}
	//I = F * N + C � ( F 2 + 3 * F + 2) / 2
	private int  getIndex(int f, int c) {
		if(f>c){
			 int aux = f;
			 f=c;
			 c=aux;
		}
		return  (f*this.n) + c- ((f*f) + (f*3)+2)/2; 
	}
	public boolean get(int f, int c) throws MatrizSimetricaException {
		boolean aux;
		if(f==c)
			throw new MatrizSimetricaException("Filas y Columnas iguales"+ f + c );
		return vec[this.getIndex(f,c)] ;
		
	}
	public void  set(int f ,int c,boolean x) {
		 vec[this.getIndex(f,c)]=x ;
	}
	public int  getSize() {
		return this.n ;
		
	}

	public class MatrizSimetricaException extends Exception {
	    public MatrizSimetricaException(String msg) {
	        super(msg);
	    }
	}
	
	
	
}
