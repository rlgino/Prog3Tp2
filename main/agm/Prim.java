package agm;

import estructura.ArbolConTiempo;;

public class Prim 
{
	public static ArbolConTiempo resolver(ArbolConTiempo grafo)
	{
		int n = grafo.vertices();
		ArbolConTiempo agm = new ArbolConTiempo(n);

		boolean[] amarillos = new boolean[n];
		amarillos[0] = true;
		
		for(int i=0; i<n-1; ++i)
		{
			Arista arista = menorCruzada(grafo, amarillos);

			amarillos[arista.negro] = true;
			agm.agregarArista(arista.amarillo, arista.negro, grafo.peso(arista.amarillo, arista.negro));
		}
		
		return agm;
	}
	
	static class Arista
	{
		public int amarillo;
		public int negro;
		
		public Arista(int a, int n)
		{
			amarillo = a;
			negro = n;
		}
	}
	
	// Package-private para los tests
	static Arista menorCruzada(ArbolConTiempo grafo, boolean[] amarillos)
	{
		int n = grafo.vertices();
		double menorPeso = Double.MAX_VALUE;
		Arista ret = null;
		
		for(int i=0; i<n; ++i) if( amarillos[i] == true )
		for(int j=0; j<n; ++j) if( amarillos[j] == false && grafo.existeArista(i, j))
		{
			double pesoActual = grafo.peso(i, j);
			if( pesoActual < menorPeso )
			{
				menorPeso = pesoActual;
				ret = new Arista(i, j);
			}
		}
		
		return ret; 
	}
}



















