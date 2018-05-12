package controlador;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class ControladorSegundoTest {
Controlador controlador = new Controlador();
	

	@Before
	public void iniciar() {
		try {
			controlador.agregarMina(0, "mina0", 0);
			controlador.agregarMina(1, "mina1", 0);
			controlador.agregarMina(2, "mina2", 0);
			controlador.agregarMina(3, "mina3", 0);
			controlador.agregarMina(4, "mina4", 0);
			controlador.agregarMina(5, "mina5", 0);
			controlador.agregarMina(6, "mina6", 0);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		controlador.agregarArista(controlador.getMina("mina0"), controlador.getMina("mina1"), 5);
		controlador.agregarArista(controlador.getMina("mina0"), controlador.getMina("mina2"), 16);
		controlador.agregarArista(controlador.getMina("mina0"), controlador.getMina("mina3"), 20);
		controlador.agregarArista(controlador.getMina("mina0"), controlador.getMina("mina4"), 3);
		controlador.agregarArista(controlador.getMina("mina0"), controlador.getMina("mina5"), 2);
		controlador.agregarArista(controlador.getMina("mina0"), controlador.getMina("mina6"), 1);
		
		controlador.agregarArista(controlador.getMina("mina1"), controlador.getMina("mina2"), 10);
		controlador.agregarArista(controlador.getMina("mina4"), controlador.getMina("mina5"), 2);
		controlador.agregarArista(controlador.getMina("mina5"), controlador.getMina("mina0"), 2);
		controlador.agregarArista(controlador.getMina("mina6"), controlador.getMina("mina3"), 3);
	}
	
	@Test
	public void recorrerTest(){
		String resultado = controlador.recorrer(0);
		System.out.println(resultado);
		assertTrue(resultado.equals(controlador.CAMINOS_SIN_CARBON));
	}
}
