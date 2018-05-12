package controlador;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;

import agm.Dijkstra;

public class ControladorTest {

	Controlador controlador = new Controlador();
	

	@Before
	public void iniciar() {
		try {
			controlador.agregarMina(0, "mina0", 0);
			controlador.agregarMina(1, "mina1", 0);
			controlador.agregarMina(2, "mina2", 1);
			controlador.agregarMina(3, "mina3", 0);
			controlador.agregarMina(4, "mina4", 0);
			controlador.agregarMina(5, "mina5", 0);
			controlador.agregarMina(6, "mina6", 5);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		controlador.agregarArista(controlador.getMina("mina0"), controlador.getMina("mina1"), 1);
		controlador.agregarArista(controlador.getMina("mina1"), controlador.getMina("mina2"), 5);
		controlador.agregarArista(controlador.getMina("mina2"), controlador.getMina("mina3"), 2);
		controlador.agregarArista(controlador.getMina("mina0"), controlador.getMina("mina4"), 3);
		controlador.agregarArista(controlador.getMina("mina4"), controlador.getMina("mina5"), 2);
		controlador.agregarArista(controlador.getMina("mina5"), controlador.getMina("mina6"), 3);
	}
	
	@Test(expected = RuntimeException.class)
	public void agregarCarbonNegativoTest(){
		try {
			controlador.agregarMina(7, "mina7", -1);
		} catch (Throwable e) {
			throw new RuntimeException();
		}		
	}
	
	@Test
	public void buscarMina(){
		assertNotNull(controlador.getMina("mina0"));
		assertNull(controlador.getMina("mina7"));
	}
	
	@Test(expected = RuntimeException.class)
	public void agregarTiempoNegativoTest(){
		controlador.agregarArista(controlador.getMina("mina0"), controlador.getMina("mina5"), -10);
	}
	
	@Test
	public void recorrerTest(){
		System.out.println(controlador.recorrer(controlador.getMina("mina0").getId()));
		assertFalse(controlador.recorrer(controlador.getMina("mina0").getId()).equals(controlador.CAMINOS_SIN_CARBON));
		
		Dijkstra.resolver(controlador.arbol, 5);
	}
}
