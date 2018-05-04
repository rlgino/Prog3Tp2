package agm;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import estructura.ArbolConTiempo;

public class DijkstraTest {
	private ArbolConTiempo _grafo;

	@Before
	public void inicializar() {
		_grafo = new ArbolConTiempo(6);
		_grafo.agregarArista(0, 1, 4.0);
		_grafo.agregarArista(0, 5, 3.0);
		_grafo.agregarArista(0, 2, 8.0);
		_grafo.agregarArista(1, 2, 3.0);
		_grafo.agregarArista(1, 4, 1.0);
		_grafo.agregarArista(2, 4, 1.0);
		_grafo.agregarArista(2, 3, 1.0);
		_grafo.agregarArista(3, 4, 4.0);
		_grafo.agregarArista(4, 5, 3.0);
	}

	@Test
	public void dijkstraTest() {
		ArbolConTiempo agm = Dijkstra.resolver(_grafo, 0);

		assertTrue(agm.existeArista(0, 1));
		assertTrue(agm.existeArista(0, 5));
		assertTrue(agm.existeArista(1, 2));
		assertTrue(agm.existeArista(1, 4));
		assertTrue(agm.existeArista(2, 3));
		assertEquals(5, agm.aristas());
	}

	// @Test
	// public void menorCruzadaInicial()
	// {
	// boolean[] amarillos = new boolean[] { true, false, false, false, false };
	// Arista menor = Dijkstra.menorCruzada(_grafo, amarillos);
	//
	// assertEquals(0, menor.amarillo);
	// assertEquals(3, menor.negro);
	// }
	//
	// @Test
	// public void menorCruzadaRegular()
	// {
	// boolean[] amarillos = new boolean[] { true, false, false, true, false };
	// Arista menor = Dijkstra.menorCruzada(_grafo, amarillos);
	//
	// assertEquals(3, menor.amarillo);
	// assertEquals(1, menor.negro);
	// }
	//
	// @Test
	// public void menorCruzadaUltima()
	// {
	// boolean[] amarillos = new boolean[] { true, true, true, false, true };
	// Arista menor = Dijkstra.menorCruzada(_grafo, amarillos);
	//
	// assertEquals(1, menor.amarillo);
	// assertEquals(3, menor.negro);
	// }
	//
	// @Test
	// public void menorCruzadaSinAmarillos()
	// {
	// boolean[] amarillos = new boolean[5]; // Todos false
	// assertNull( Dijkstra.menorCruzada(_grafo, amarillos) );
	// }
	//
	// @Test
	// public void menorCruzadaTodosAmarillos()
	// {
	// boolean[] amarillos = new boolean[] { true, true, true, true, true };
	// assertNull( Dijkstra.menorCruzada(_grafo, amarillos) );
	// }

}
