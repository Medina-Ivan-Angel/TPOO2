package ramaFasesDelBuqueTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import Terminal.TerminalNormal;
import Terminal.TerminalGestionada;
import ramaFasesDelBuque.Arrived;
import ramaFasesDelBuque.Buque;
import ramaFasesDelBuque.Coordenada;
import ramaFasesDelBuque.Inbound;

class InboundTest {

	// Mocks Fake objects:
	
	@Mock Arrived proximoEstado;
	Inbound inbound;
	@Mock Buque buqueMock;
	@Mock TerminalNormal terminalGestionada;
	
	@BeforeEach
	void setUp() throws Exception {
	
		// inicializo los mocks fake objects:

		proximoEstado = mock(Arrived.class);
		inbound = mock(Inbound.class);
		buqueMock = mock(Buque.class);
		
	}

	@Test
	void testElBuqueArrivo() {
		
		assertEquals(false, inbound.elBuqueArrivo(buqueMock));
	
	}
	
	@Test
	void testTerminalGestionadaEnLaListaDeTramosEs() {
	
		assertEquals(terminalGestionada, inbound.terminalGestionadaEnLaListaDeTramosEs(buqueMock));
		
	}

}
	