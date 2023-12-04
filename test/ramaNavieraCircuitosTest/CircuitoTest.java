package ramaNavieraCircuitosTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import ramaNavieraCircuitos.Circuito;
import ramaNavieraCircuitos.Tramo;

import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

class CircuitoTest {

	@Mock Tramo primerTramo;
	@Mock Tramo segundoTramo;
	@Mock Tramo tercerTramo;
	@Mock Tramo cuartoTramo;
	
	Circuito circuito;

	@BeforeEach
	void setUp() throws Exception {
	
	primerTramo = mock(Tramo.class);
	segundoTramo = mock(Tramo.class);
	tercerTramo = mock(Tramo.class);
	cuartoTramo = mock(Tramo.class);
	
	List<Tramo> tramos = Arrays.asList(primerTramo, segundoTramo, tercerTramo);
	
	circuito = new Circuito(tramos);
	
	
	}

	@Test
	void testGetTramos() {
	
		List<Tramo> tramosEsperados = Arrays.asList(primerTramo, segundoTramo, tercerTramo);
		
		assertEquals(tramosEsperados, circuito.getTramos());
	}
	
	@Test
	void testSetTramos() {
	
		List<Tramo> tramosEsperados = Arrays.asList(primerTramo, segundoTramo, tercerTramo, cuartoTramo);
		
		circuito.setTramos(tramosEsperados);
		
		assertEquals(tramosEsperados, circuito.getTramos());
	}
	
	@Test
	void testAgregarTramo() {
		
		List<Tramo> tramosEsperados = Arrays.asList(primerTramo, segundoTramo, tercerTramo);
		
		circuito.setTramos(tramosEsperados);
		
		circuito.agregarTramo(cuartoTramo);
		
		assertEquals(tramosEsperados, circuito.getTramos());
	}
}
