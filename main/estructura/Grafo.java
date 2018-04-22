package estructura;

import java.util.ArrayList;
import java.util.HashSet;

public class Grafo {
	private int _cantidadVertices;
	private ArrayList<HashSet<Integer>> vecinos;

	public Grafo(int cantVecinos) {
		super();
		this.setCantidadVertices(_cantidadVertices);
		for (int x = 0; x < cantVecinos; x++)
			vecinos.add(new HashSet<Integer>());
	}

	public int getCantidadVertices() {
		return _cantidadVertices;
	}

	public void setCantidadVertices(int _cantidadVertices) {
		this._cantidadVertices = _cantidadVertices;
	}

	public ArrayList<HashSet<Integer>> getVecinos() {
		return vecinos;
	}

	public void setVecinos(ArrayList<HashSet<Integer>> vecinos) {
		this.vecinos = vecinos;
	}

}
