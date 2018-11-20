package recostruyendolapelicula;

public class Segmento {
	
	int nodo;
	int ei;
	int ef;
	public Segmento(int nodo, int ei, int ef) {
		super();
		this.nodo = nodo;
		this.ei = ei;
		this.ef = ef;
	}
	public boolean contiene(Segmento s2) {
		
		if(this.ei < s2.ei && this.ef < s2.ei)
			return false;
		if(s2.ei < this.ei && s2.ef < this.ei)
			return false;
		return true;
	}
	public int calcularPeso(Segmento s2) {
		int ini=(ei>s2.ei)?ei:s2.ei;
		int fin=(ef<s2.ef)?ef:s2.ef;
		return 1+fin-ini;
	}
	

}
