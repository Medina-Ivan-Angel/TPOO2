package ramaNavieraCircuitosTest;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import Terminal.TerminalNormal;
import ramaNavieraCircuitos.Circuito;
import ramaNavieraCircuitos.Viaje;

import static org.mockito.Mockito.*;

class ViajeTest {


	// Mock Stub:
	@Mock LocalDate fechaDeSalida;
	@Mock LocalDateTime fechaDeLlegada;
	// Mock Fake objects:
	
	@Mock Circuito circuitoARecorrer;
	@Mock TerminalNormal terminalDestino;
	
	Viaje viaje;

	@BeforeEach
	void setUp() throws Exception {
	
		// Inicializo Mock Stub:
		
		fechaDeSalida = mock(LocalDate.class);
		fechaDeLlegada = mock(LocalDateTime.class);
		
		// establezco comportamiento de este stub:
		
		when(fechaDeSalida).thenReturn(LocalDate.of(2023, 12, 8));
	
		// Inicializo Fake objects:
		
		circuitoARecorrer = mock(Circuito.class);
		terminalDestino = mock(TerminalNormal.class);
		/*
		 * LocalDateTime fechaDeSalida,
		 * Circuito circuitoARecorrer, 
		   TerminalNormal terminalDestino,
		   LocalDateTime fechaLlegadaADestino
		 */
		viaje = new Viaje(fechaDeSalida, circuitoARecorrer, terminalDestino);
	
	}

	@Test
	void testCostoDelViaje() {
		
		assertEquals(1510.0, viaje.costoDelViaje());
		
	}
	
	@Test
	void testGetTerminalDestino() {
		
		assertEquals(terminalDestino, viaje.getTerminalDestino());
		
	}
	
	@Test
	void testGetFechaDeSalida() {
		
		assertEquals(fechaDeSalida, viaje.getFechaDeSalida());

	}
}
