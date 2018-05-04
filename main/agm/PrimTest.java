package agm;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import agm.Prim.Arista;
import estructura.ArbolConTiempo;

public class PrimTest
{
	private ArbolConTiempo _grafo;
	
	@Before
	public void inicializar()
	{
		_grafo = new ArbolConTiempo(5);
		_grafo.agregarArista(0, 1, 3.0);
		_grafo.agregarArista(0, 3, 2.0);
		_grafo.agregarArista(1, 3, 1.0);
		_grafo.agregarArista(1, 2, 4.0);
		_grafo.agregarArista(3, 4, 2.0);
		_grafo.agregarArista(2, 4, 4.0);
	}
	
	@Test
	public void menorCruzadaInicial()
	{
		boolean[] amarillos = new boolean[] { true, false, false, false, false };
		Arista menor = Prim.menorCruzada(_grafo, amarillos);
		
		assertEquals(0, menor.amarillo);
		assertEquals(3, menor.negro);
	}
	
	@Test
	public void menorCruzadaRegular()
	{
		boolean[] amarillos = new boolean[] { true, false, false, true, false };
		Arista menor = Prim.menorCruzada(_grafo, amarillos);
		
		assertEquals(3, menor.amarillo);
		assertEquals(1, menor.negro);
	}
	
	@Test
	public void menorCruzadaUltima()
	{
		boolean[] amarillos = new boolean[] { true, true, true, false, true };
		Arista menor = Prim.menorCruzada(_grafo, amarillos);
		
		assertEquals(1, menor.amarillo);
		assertEquals(3, menor.negro);
	}
	
	@Test
	public void menorCruzadaSinAmarillos()
	{
		boolean[] amarillos = new boolean[5]; // Todos false
		assertNull( Prim.menorCruzada(_grafo, amarillos) );
	}
	
	@Test
	public void menorCruzadaTodosAmarillos()
	{
		boolean[] amarillos = new boolean[] { true, true, true, true, true };
		assertNull( Prim.menorCruzada(_grafo, amarillos) );
	}
	
	@Test
	public void primTest()
	{
		ArbolConTiempo agm = Prim.resolver(_grafo);
		
		assertTrue(agm.existeArista(1, 3));
		assertTrue(agm.existeArista(0, 3));
		assertTrue(agm.existeArista(3, 4));
		assertTrue(agm.existeArista(1, 2) || agm.existeArista(2, 4));
//		assertEquals(4, agm.aristas());		
	}
}




