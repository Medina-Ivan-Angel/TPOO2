package ramaFasesDelBuqueTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import ramaFasesDelBuque.Coordenada;

class CoordenadaTest {

	// Mocks Stub:
	
	@Mock int valorX;
	@Mock int valorY;
	
	Coordenada posicion;

	@BeforeEach
	void setUp() throws Exception {
	
	// inicializo los stubs:
	
		posicion = new Coordenada(valorX, valorY);
		
	}

	@Test
	void testGetValorX() {
	
		assertEquals(valorX, posicion.getValorX());
		
	}
	
	@Test
	void testGetValorY() {
		assertEquals(valorY, posicion.getValorY());
	}
	
	@Test
	void testSetValorX() {
	
		int nuevoValorX = 70;
		
		posicion.setValorX(nuevoValorX);
		
		assertEquals(nuevoValorX, posicion.getValorX());
	}
	
	@Test
	void testSetValorY() {
		
		int nuevoValorY = 80;
		
		posicion.setValorY(nuevoValorY);
		
		assertEquals(nuevoValorY, posicion.getValorY());
		
	}
}
