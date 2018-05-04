package estructura;

import estructura.Grafo;

public class ArbolConTiempo extends Grafo {
	// Matriz de pesos
	private double _tiempos[][];
	
	public ArbolConTiempo(int vertices)
	{
		super(vertices);
		_tiempos = new double[vertices][vertices];
	}
	
	public void agregarArista(int i, int j, double tiempo)
	{
		isVecino(i, j);
		super.agregarArista(i, j);

		_tiempos[i][j] = tiempo;
		_tiempos[j][i] = tiempo;
	}
	
	public double peso(int i, int j)
	{
		isVecino(i, j);
		return _tiempos[i][j];
	}

	public int vertices() {
		return super.getCantidadVertices();
	}

	public boolean existeArista(int i, int j) {
		return super.isVecino(i, j);
	}
}