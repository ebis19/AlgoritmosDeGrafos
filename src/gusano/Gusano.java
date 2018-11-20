package gusano;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import floyd.Floyd;
import grafos.Grafo;

public class Gusano {

	Grafo mapa_red;

	ArrayList<CInfectada> cinfectadas;

	public Gusano(String a) throws IOException {
		Scanner in = new Scanner(new File(a));
		int cant_nodos = in.nextInt();
		mapa_red = new Grafo(cant_nodos);
		for (int i = 0; i < cant_nodos; i++) {
			mapa_red.setArista(in.nextInt(), in.nextInt(), in.nextInt());
		}
		int cant_c = in.nextInt();

		for (int i = 0; i < cant_c; i++) {
			cinfectadas.add(new CInfectada(in.nextInt(), in.nextInt()));
		}
		in.close();
	}

	public String encontrarPcs() {

		String computadoras = "";

		Floyd f = new Floyd(mapa_red);
		int[][] costos_min = f.getCostosminimos();
		CInfectada c;
		Iterator<CInfectada> it;
		boolean aux;
		for (int i = 0; i < mapa_red.getCantN(); i++) {
			it = cinfectadas.iterator();
			aux = true;
			while (it.hasNext() && aux) {
				c = it.next();
				if (costos_min[i][c.getN() - 1] == c.getT())
					aux = false;
			}
			if (aux)
				computadoras += i;
		}
		return computadoras;
	}

	public String encontrarPcs2() {

		String computadoras = "";

		Floyd f = new Floyd(mapa_red);
		int[][] costos_min = f.getCostosminimos();
		CInfectada c;
		Iterator<CInfectada> it;
		for (int i = 0; i < mapa_red.getCantN(); i++) {
			it = cinfectadas.iterator();
			c = it.next();
			while (it.hasNext() && costos_min[i][c.getN()] == c.getT()) {
				c = it.next();
			}
			if (!it.hasNext())
				computadoras += i;
		}

		return computadoras;
	}

}
