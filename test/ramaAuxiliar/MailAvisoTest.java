package ramaAuxiliar;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MailAvisoTest {

	
	MailAviso mailA;
	
	@BeforeEach
	void setUp() throws Exception {
		
		String mensaje = "Mensaje de prueba";
		
		mailA = new MailAviso(mensaje);
		
	}

	@Test
	void testGetMensaje() {
		
		String mensaje = "Mensaje de prueba";
		
		assertEquals(mensaje, mailA.getMensaje());
	}

}
