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

	public void agregarArista(int key, int val) {
		verificarIndice(key);
		verificarIndice(val);
		if (!isVecino(key, val))
			vecinos.get(key).add(val);
	}

	public boolean isVecino(int key, int val) {
		verificarIndice(key);
		verificarIndice(val);
		return vecinos.get(key).contains(val);
	}

	private boolean verificarIndice(int val) {
		if (val < 0)
			throw new RuntimeException("El valor " + val + " no puede ser negativo");
		if (val < _cantidadVertices)
			throw new RuntimeException("El valor " + val + " no puede ser mayor a la cantidad de vertices");
		return true;
	}
}
