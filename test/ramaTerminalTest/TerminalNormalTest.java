package ramaTerminalTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Terminal.TerminalNormal;
import ramaFasesDelBuque.Coordenada;

class TerminalNormalTest {

	
	TerminalNormal terminalNormal;
	Coordenada posicion;
	
	
	@BeforeEach
	void setUp() throws Exception {
		
		posicion = new Coordenada(100,100);
		
		terminalNormal = new TerminalNormal(posicion);
		
		
	}

	@Test
	void testGetPosicion() {
		Coordenada posicionEsperada = posicion;
		assertEquals(posicionEsperada, terminalNormal.getPosicion());
	}

}
