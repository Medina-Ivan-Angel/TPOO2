package ramaFasesDelBuqueTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import org.mockito.Mock;

import Terminal.TerminalNormal;
import ramaFasesDelBuque.Arrived;
import ramaFasesDelBuque.Buque;
import ramaFasesDelBuque.Working;

class ArrivedTest {

	@Mock Working proximoEstado;
	Arrived arrived;
	@Mock Buque buqueMock;
	@Mock TerminalNormal terminalGestionada;


	@BeforeEach
	void setUp() throws Exception {
	
		// inicializo fake objects:
	
		proximoEstado = mock(Working.class);
		buqueMock = mock(Buque.class);
		arrived = mock(Arrived.class);
	
	}

	@Test
	void testDistanciaALaTerminalIgualACero() {
	
		assertEquals(false, arrived.distanciaALaTerminalIgualACero(buqueMock));
		
	}
	
	@Test
	void testTerminalGestionadaEnLaListaDeTramosEs() {
		
		assertEquals(terminalGestionada, arrived.terminalGestionadaEnLaListaDeTramosEs(buqueMock));
		
	}

}
