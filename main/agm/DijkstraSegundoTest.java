package agm;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import estructura.ArbolConTiempo;

public class DijkstraSegundoTest {
	private ArbolConTiempo _grafo;

	@Before
	public void inicializar() {
		_grafo = new ArbolConTiempo(6);
		_grafo.agregarArista(0, 1, 4.0);
		_grafo.agregarArista(1, 2, 5.0);
		_grafo.agregarArista(2, 3, 6.0);
		_grafo.agregarArista(4, 3, 2.0);
		_grafo.agregarArista(4, 5, 10.0);
		_grafo.agregarArista(0, 5, 2.0);
		_grafo.agregarArista(5, 2, 8.0);
		_grafo.agregarArista(5, 1, 1.0);
		_grafo.agregarArista(2, 4, 2.0);
	}

	@Test
	public void dijkstraTest() {
		ArbolConTiempo agm = Dijkstra.resolver(_grafo, 0);
		assertTrue(agm.existeArista(0, 5));
		assertTrue(agm.existeArista(5, 1));
		assertTrue(agm.existeArista(1, 2));
		assertTrue(agm.existeArista(2, 4));
		assertTrue(agm.existeArista(4, 3));
		assertEquals(5, agm.aristas());
	}
}
