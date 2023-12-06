package ramaNavieraCircuitosTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import ramaFasesDelBuque.Buque;
import ramaNavieraCircuitos.Circuito;
import ramaNavieraCircuitos.Naviera;

class NavieraTest {

	// Mocks Fake objects: 
	
	@Mock Buque primerBuque;
	@Mock Buque segundoBuque;
	@Mock Buque tercerBuque;
	@Mock Buque cuartoBuque;
	
	@Mock Circuito primerCircuito;
	@Mock Circuito segundoCircuito;
	@Mock Circuito tercerCircuito;
	@Mock Circuito cuartoCircuito;
	
	Naviera naviera;
 
	
	@BeforeEach
	void setUp() throws Exception {
	
		// Inicializo los Fake Objects:
		primerBuque = mock(Buque.class);
		segundoBuque = mock(Buque.class);
		tercerBuque = mock(Buque.class);
		cuartoBuque = mock(Buque.class);
		
		primerCircuito = mock(Circuito.class);
		segundoCircuito = mock(Circuito.class);
		tercerCircuito = mock(Circuito.class);
		cuartoCircuito = mock(Circuito.class);
		
		List<Buque> buques = Arrays.asList(primerBuque, segundoBuque, tercerBuque);
		List<Circuito> circuitos = Arrays.asList(primerCircuito, segundoCircuito, tercerCircuito);
		
		naviera = new Naviera(buques, circuitos);
	
	}

	@Test
	void testGetFlota() {
	
		List<Buque> flotaEsperada = Arrays.asList(primerBuque, segundoBuque, tercerBuque);	
	
		assertEquals(flotaEsperada, naviera.getFlota());
	}
	
	@Test
	void testSetFlota() {
	
		List<Buque> flotaEsperada = Arrays.asList(primerBuque, segundoBuque, tercerBuque, cuartoBuque);
		
		naviera.setFlota(flotaEsperada);
		
		assertEquals(flotaEsperada, naviera.getFlota());
	}
	
	
	@Test
	void testGetCircuitosMaritimos() {
	
		List<Circuito> circuitosEsperados = Arrays.asList(primerCircuito, segundoCircuito, tercerCircuito);
	
		assertEquals(circuitosEsperados, naviera.getCircuitosMaritimos());
	}
	
	@Test
	void testSetCircuitosMaritimos() {
	
		List<Circuito> circuitosEsperados = Arrays.asList(primerCircuito, segundoCircuito, tercerCircuito);
		
		naviera.setCircuitosMaritimos(circuitosEsperados);
		
		assertEquals(circuitosEsperados, naviera.getCircuitosMaritimos());
	}
	
	@Test
	void testAgregarBuque() {
	
		List<Buque> flotaEsperada = Arrays.asList(primerBuque, segundoBuque, tercerBuque, cuartoBuque);
	
		naviera.agregarBuque(cuartoBuque);
	
		assertEquals(flotaEsperada, naviera.getFlota());
	}
	
	@Test
	void testAgregarCircuito() {
	
		List<Circuito> circuitosEsperados = Arrays.asList(primerCircuito, segundoCircuito, tercerCircuito, cuartoCircuito);
	
		naviera.agregarCircuito(cuartoCircuito);
		
		assertEquals(circuitosEsperados, naviera.getCircuitosMaritimos());
	}

}
