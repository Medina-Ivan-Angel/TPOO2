package ramaNavieraCircuitosTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import Terminal.TerminalNormal;
import ramaNavieraCircuitos.Tramo;

import static org.mockito.Mockito.*;


class TramoTest {

	// Mocks Fake objects:
	
	@Mock TerminalNormal origen;
	@Mock TerminalNormal destino;
	
	Tramo tramo;

	@BeforeEach
	void setUp() throws Exception {
	
		// Inicializo los Fake Objects:
		origen = mock(TerminalNormal.class);
		destino = mock(TerminalNormal.class);
		
		// Inicializo mocks stubs:
		
		double distanciaEntrePuertos = 500.0;
		double duracionDelTramo = 10.0;
		double costoDelTramo = 1000.0;
		
		tramo = new Tramo(origen, destino, distanciaEntrePuertos, 
						  duracionDelTramo, costoDelTramo);
		
	}

	@Test
	void testGetCostoDelTramo() {
		
		assertEquals(1000.0, tramo.getCostoDelTramo());
		
	}
	
	@Test
	void testGetDistanciaEntrePuertos() {
		
		assertEquals(500.0, tramo.getDistanciaEntrePuertos());
		
	}
	
	@Test
	void testGetDuracionDelTramo() {
		
		assertEquals(10.0, tramo.getDuracionDelTramo());
		
	}
	
	@Test
	void testGetOrigen() {
		
		assertEquals(origen, tramo.getOrigen());
		
	}
	
	@Test
	void testGetDestino() {
		
		assertEquals(destino, tramo.getDestino());
		
	}

}
