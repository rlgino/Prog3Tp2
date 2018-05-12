package controlador;

import java.util.ArrayList;
import java.util.List;

import agm.Dijkstra;
import estructura.ArbolConTiempo;
import modelo.PuntoInteres;

public class Controlador {
	ArbolConTiempo arbol;
	private List<PuntoInteres> listaMinas;
	
	public String CAMINOS_SIN_CARBON = "No existen caminos con carbon";

	public Controlador() {
		listaMinas = new ArrayList<PuntoInteres>();
	}

	public void agregarArista(PuntoInteres minaA, PuntoInteres minaB, int tiempo) {
		if (tiempo < 0)
			throw new RuntimeException("El tiempo no puede ser negativo.");
		if (arbol == null)// Aca ya que no se sabe cuantas minas se ingresaran
			arbol = new ArbolConTiempo(listaMinas.size());

		arbol.agregarArista(minaA.getId(), minaB.getId(), tiempo);
	}

	public void agregarMina(int id, String nombre, double cantCarbon) throws Throwable {
		if (cantCarbon < 0)
			throw new RuntimeException("No se puede agregar Carbon Negativo");
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

	public void agregarArista(String minaA, String minaB, int tiempo) throws Throwable {
		PuntoInteres puntoInteresA = getMina(minaA);
		if (puntoInteresA == null)
			throw new RuntimeException("La mina " + minaA + " no existe.");
		PuntoInteres puntoInteresB = getMina(minaB);
		if (puntoInteresB == null)
			throw new RuntimeException("La mina " + minaB + " no existe.");
		if (tiempo < 0)
			throw new RuntimeException("El tiempo ingresado es incorrecto");
		agregarArista(puntoInteresA, puntoInteresB, tiempo);
	}

	StringBuilder sb;
	public String recorrer(int ini) {
		ArbolConTiempo agm = Dijkstra.resolver(arbol, ini);
		String ret = "";
		double mejorRecorrido = Double.MAX_VALUE;
		for (int x = 0; x < agm.getCantidadVertices(); x++){
			sb = new StringBuilder();
			sb.append(ini).append("--").append(agm.peso(ini, x)).append("-->").append(x);;
			if (agm.existeArista(ini, x)) {
				double p = buscarMejorRecorrido(agm, ini, x);
				if (p < mejorRecorrido) {
					mejorRecorrido = p;
					ret = sb.toString();
				}
			}
		}
		return ret.equals("") ? CAMINOS_SIN_CARBON : ret;
	}

	private double buscarMejorRecorrido(ArbolConTiempo agm, int ini, int x) {
		int actual = x;
		if (listaMinas.get(x).getCantCarbon() > 0)
			return agm.peso(ini, x);
		for (int y = 0; y < agm.getCantidadVertices(); y++) {
			if (agm.existeArista(actual, y)) {
				sb.append("--").append(agm.peso(actual, y)).append("-->").append(y);
				if (listaMinas.get(y).getCantCarbon() > 0)
					return agm.peso(actual, y);
				actual = y;
			}
		}
		return Double.MAX_VALUE;
	}
}
