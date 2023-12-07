package ramaNavieraCircuitosTest;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import Terminal.TerminalNormal;
import ramaNavieraCircuitos.Circuito;
import ramaNavieraCircuitos.Tramo;
import ramaNavieraCircuitos.Viaje;

import static org.mockito.Mockito.*;

class ViajeTest {

	LocalDateTime fechaDeSalida = LocalDateTime.of(2023, Month.DECEMBER, 8, 0, 0);
	
	// Mock Stub:
	@Mock LocalDateTime fechaDeLlegada;
	@Mock LocalDateTime fechaDeLlegadaADestino;
	// Mock Fake objects:
	
	@Mock Circuito circuitoARecorrer;
	@Mock TerminalNormal terminalDestino;
	
	Viaje viaje;

	@BeforeEach
	void setUp() throws Exception {
	
		// Inicializo Mock Stub:
		
		fechaDeSalida = mock(LocalDateTime.class);
		fechaDeLlegada = mock(LocalDateTime.class);
		fechaDeLlegadaADestino = mock(LocalDateTime.class);
		
	    // Crear tramos con un costo total de 1510.0
	    Tramo tramo1 = mock(Tramo.class);
	    when(tramo1.getCostoDelTramo()).thenReturn(755.0);

	    Tramo tramo2 = mock(Tramo.class);
	    when(tramo2.getCostoDelTramo()).thenReturn(755.0);
		
		
		// Inicializo Fake objects:	
		circuitoARecorrer = mock(Circuito.class);
		terminalDestino = mock(TerminalNormal.class);
		
		// Configurar circuitoARecorrer para devolver los tramos
	    when(circuitoARecorrer.getTramos()).thenReturn(Arrays.asList(tramo1, tramo2));
		
		/*
		 * LocalDateTime fechaDeSalida,
		 * Circuito circuitoARecorrer, 
		   TerminalNormal terminalDestino,
		   LocalDateTime fechaLlegadaADestino
		 */
		viaje = new Viaje(fechaDeSalida, circuitoARecorrer, terminalDestino, fechaDeLlegadaADestino);
	
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
