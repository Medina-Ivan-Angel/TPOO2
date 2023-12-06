package ramaFasesDelBuqueTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import Terminal.TerminalNormal;
import ramaFasesDelBuque.Buque;
import ramaFasesDelBuque.Inbound;
import ramaFasesDelBuque.Outbound;

class OutboundTest {

	@Mock Inbound proximoEstado;
	Outbound outbound;
	@Mock Buque buqueMock;
	@Mock TerminalNormal terminalGestionada;
	 
	

	@BeforeEach
	void setUp() throws Exception {
	
		// inicializo los Fake objects:
		
		outbound = mock(Outbound.class);
		proximoEstado = mock(Inbound.class);
		buqueMock = mock(Buque.class);
	
	}

	@Test
	void testDistanciaALaTerminalMenorA50KM() {
	
		assertEquals(false, outbound.distanciaALaTerminalMenorA50KM(buqueMock, terminalGestionada));
		
	}
	
	@Test
	void testTerminalGestionadaEnLaListaDeTramosEs() {
		
		assertEquals(terminalGestionada, outbound.terminalGestionadaEnLaListaDeTramosEs(buqueMock, terminalGestionada));
		
	}

}
