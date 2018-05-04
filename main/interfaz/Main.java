package interfaz;

import java.util.Scanner;

import controlador.Controlador;

public class Main {
	private static Controlador controlador;

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		System.out.println("Ingrese puntos de interes");
		String resp = "s";
		int cont = 0;
		controlador = new Controlador();
		while (!resp.equals("n")) {
			System.out.println("Ingrese nombre del punto:\n");
			String nombre = new Scanner(System.in).nextLine();
			System.out.println("Ingrese cantidad de carbon: \n");
			String carbon = new Scanner(System.in).nextLine();
			int cantCarbon = Integer.parseInt(carbon);
			controlador.agregarMina(cont++, nombre, cantCarbon);
			System.out.println("Desea ingresar otra mina?:\n");
			resp = new Scanner(System.in).nextLine();

		}

		resp = "s";

		while (!resp.equals("n")) {
			System.out.println(controlador.getListaMinas());
			System.out.println("Ingrese el punto A del camino:\n");
			String minaA = new Scanner(System.in).nextLine();
			System.out.println("Ingrese el punto B del camino: \n");
			String minaB = new Scanner(System.in).nextLine();
			System.out.println("Ingrese tiempo del camino:\n");
			String tiempoStr = new Scanner(System.in).nextLine();

			controlador.agregarArista(minaA, minaB, Integer.parseInt(tiempoStr));

			System.out.println("Desea ingresar otro camino?:\n");
			resp = new Scanner(System.in).nextLine();
		}
		

		System.out.println("Ingrese el punto A del camino:\n");
		String minaA = new Scanner(System.in).nextLine();
		System.out.println(controlador.recorrer(controlador.getMina(minaA).getId()));
	}

}
