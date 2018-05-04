package agm;

import java.util.ArrayList;
import java.util.List;

import estructura.ArbolConTiempo;

public class Dijkstra {

	public static ArbolConTiempo resolver(ArbolConTiempo grafo, int comienzo) {
		int n = grafo.vertices();
		ArbolConTiempo agmRet = new ArbolConTiempo(n);
		Double[] distancias = new Double[n];
		List<Integer> visitados = new ArrayList<Integer>();

		for (int i = 0; i < n; i++) {
			if (grafo.existeArista(comienzo, n)) {
				distancias[i] = grafo.peso(comienzo, n);
			} else {
				distancias[i] = Double.MAX_VALUE;
			}
		}
		distancias[comienzo] = (double) 0;
		visitados.add(comienzo);

		while (visitados.size() < grafo.getCantidadVertices()) {
			Arista aristaMinima = obtenerMinimoVisitado(visitados, distancias, grafo);
			visitados.add(aristaMinima.y);
			distancias[aristaMinima.y] = aristaMinima.peso;
			agmRet.agregarArista(aristaMinima.x, aristaMinima.y,aristaMinima.peso);
		}

		return agmRet;
	}

	private static Arista obtenerMinimoVisitado(List<Integer> visitados, Double[] distancias, ArbolConTiempo grafo) {
		double min = Double.MAX_VALUE;
		Arista ret = new Arista();
		for (int x : visitados){
			for (int y = 0; y < grafo.vertices(); y++) if (!visitados.contains(y) && grafo.existeArista(x, y))
				if (distancias[x] + grafo.peso(x, y) < min) {
					min = distancias[x] + grafo.peso(x, y);
					ret.x = x;
					ret.y = y;
					ret.peso = min;
			}
		}
		return ret;
	}
	
	static class Arista{
		int x;
		int y;
		double peso;
	}

}
