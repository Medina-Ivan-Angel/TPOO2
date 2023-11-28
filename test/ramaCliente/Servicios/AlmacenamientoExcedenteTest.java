package ramaCliente.Servicios;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AlmacenamientoExcedenteTest {

	
	
	AlmacenamientoExcedente almExc;
	
	
	
	@BeforeEach
	void setUp() throws Exception {
		
		almExc = new AlmacenamientoExcedente(10, 5);
	}

	@Test
	void testCostoTotal() {
		assertEquals(50, almExc.costoTotal());
	}

}
