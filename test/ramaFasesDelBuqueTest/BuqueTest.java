package ramaFasesDelBuqueTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import Terminal.TerminalNormal;
import ramaAuxiliar.Mail;
import ramaAuxiliar.MailAviso;

import static org.mockito.Mockito.*;

import ramaDeposito.Container;
import ramaFasesDelBuque.Buque;
import ramaFasesDelBuque.Coordenada;
import ramaFasesDelBuque.Outbound;
import ramaFasesDelBuque.Inbound;
import ramaFasesDelBuque.Arrived;
import ramaFasesDelBuque.Working;
import ramaFasesDelBuque.Departing;



import ramaNavieraCircuitos.Viaje;

class BuqueTest {

	// Mocks Dummy objects:
	
	@Mock Mail dummyMail;
	@Mock MailAviso dummyMailAviso;
	
	// Mocks Fake Objects:
	
	@Mock Outbound  outbound;
	@Mock Inbound   inbound;
	@Mock Arrived   arrived;
	@Mock Working   working;
	@Mock Departing departing;
	@Mock TerminalNormal terminalGestionada;
	
	
	@Mock Viaje viaje;
	      List<Container> containers;
	@Mock Container primerContainer;
	@Mock Container segundoContainer;
	@Mock Container tercerContainer;
	Buque buque;
	
	// Stub de coordenada:
	
	@Mock Coordenada posicion;	

	@BeforeEach
	void setUp() throws Exception {
	
		outbound = mock(Outbound.class);
		inbound = mock(Inbound.class);
		arrived = mock(Arrived.class);
		working = mock(Working.class);
		departing = mock(Departing.class);
		
		
		viaje = mock(Viaje.class);
		posicion = mock(Coordenada.class);
		
		primerContainer = mock(Container.class);
		segundoContainer = mock(Container.class);
		tercerContainer = mock(Container.class);
		
		containers = Arrays.asList(primerContainer, segundoContainer, tercerContainer);
		
		terminalGestionada = mock(TerminalNormal.class);
		
		buque = new Buque(inbound, viaje, posicion, containers, terminalGestionada);	
		
		// le asigno comportamiento a los stub:
		
		
		when(posicion.getValorX()).thenReturn(10);
		when(posicion.getValorY()).thenReturn(80);
	}

	@Test
	void testCalcularDistancia() {
	
		assertEquals(0.0, buque.calcularDistancia(posicion));
		
	}
		
	@Test
	void testEstadoActual() {
	
		buque.setEstado(working);
		
		assertEquals(working, buque.getEstado());
		
	}
	
	@Test
	void testGetViaje() {
	
		assertEquals(viaje, buque.getViaje());
		
	}
	
	@Test
	void testGetPosicion() {
	
		assertEquals(posicion, buque.getPosicion());
		
	}
	
	@Test
	void testSetPosicion() {
	
		Coordenada posicion = new Coordenada(10,10);
		buque.setPosicion(posicion);
	
		assertEquals(posicion, buque.getPosicion());
		
	}
	
	@Test
	void testGetContainers() {
		
		assertEquals(containers, buque.getContainers());
		
	}
	
	@Test
	void testGetEstado() {
	
		assertEquals(inbound, buque.getEstado());
		
	}
	
	@Test
	void testSetEstado() {
	
		buque.setEstado(departing);
		
		assertEquals(departing, buque.getEstado());
		
	}

} 
