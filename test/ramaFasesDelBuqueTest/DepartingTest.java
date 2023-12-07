package ramaFasesDelBuqueTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import org.mockito.Mock;

import Terminal.TerminalNormal;
import ramaFasesDelBuque.Buque;
import ramaFasesDelBuque.Departing;
import ramaFasesDelBuque.Outbound;

class DepartingTest {

	@Mock Outbound proximoEstado;
	Departing departing;
	@Mock Buque buqueMock;
	@Mock TerminalNormal terminalGestionada;
	
	@BeforeEach
	void setUp() throws Exception {
	
		// inicializo fake objects:
	
		proximoEstado = mock(Outbound.class);
		buqueMock = mock(Buque.class);
		departing = mock(Departing.class);
	
	}

	@Test
	void testDistanciaALaTerminalMayorA1KM() {
	
		assertEquals(false, departing.distanciaALaTerminalMayorA1KM(buqueMock));
		
	}
	
	@Test
	void testTerminalGestionadaEnLaListaDeTramosEs() {
		
		assertEquals(terminalGestionada, departing.terminalGestionadaEnLaListaDeTramosEs(buqueMock));
		
	}

}
