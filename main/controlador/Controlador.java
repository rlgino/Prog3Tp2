package controlador;

import java.util.ArrayList;
import java.util.List;

import agm.Dijkstra;
import agm.Prim;
import estructura.ArbolConTiempo;
import modelo.PuntoInteres;

public class Controlador {
	private ArbolConTiempo arbol;
	private List<PuntoInteres> listaMinas;

	public Controlador() {
		listaMinas = new ArrayList<PuntoInteres>();
	}

	public void agregarArista(PuntoInteres minaA, PuntoInteres minaB, int tiempo) {
		if (arbol == null)
			arbol = new ArbolConTiempo(listaMinas.size());

		arbol.agregarArista(minaA.getId(), minaB.getId(), tiempo);
	}

	public void agregarMina(int id, String nombre, double cantCarbon) {
		PuntoInteres pi = new PuntoInteres(id, nombre, cantCarbon);
		listaMinas.add(pi);
	}

	public PuntoInteres getMina(String nombre) {
		for (int x = 0; x < listaMinas.size(); x++)
			if (listaMinas.get(x).getNombre().equals(nombre))
				return listaMinas.get(x);
		return null;
	}

	public String getListaMinas() {
		StringBuilder sb = new StringBuilder();
		for (PuntoInteres pi : listaMinas)
			sb.append(pi.getId() + " - " + pi.getNombre() + "\n");

		return sb.toString();
	}

	public void agregarArista(String minaA, String minaB, int tiempo) {
		PuntoInteres puntoInteresA = getMina(minaA);
		PuntoInteres puntoInteresB = getMina(minaB);
		agregarArista(puntoInteresA, puntoInteresB, tiempo);

	}
	
	public String recorrer(int ini){
		ArbolConTiempo agm = Dijkstra.resolver(arbol, ini);
		StringBuilder sb = new StringBuilder();
		for(int x = 0; x<agm.aristas() ; x++)
			for(int y = 0; y<agm.aristas() ; y++)
				if(agm.existeArista(x, y))
					sb.append(x).append("---").append(agm.peso(x, y)).append("--->").append(y);
		return (sb.toString());
	}

}
