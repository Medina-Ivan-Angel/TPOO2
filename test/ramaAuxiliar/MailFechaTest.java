package ramaAuxiliar;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MailFechaTest {

	MailFecha mailF;
	
	
	@BeforeEach
	void setUp() throws Exception {
		
		LocalDateTime fecha = LocalDateTime.of(2023, 11, 28, 15, 30, 0); // año, mes, día, hora, minuto y segundo
		
		mailF = new MailFecha(fecha);
	}

	@Test
	void testGetFecha() {
		
		LocalDateTime fecha = LocalDateTime.of(2023, 11, 28, 15, 30, 0); 
		
		assertEquals(fecha, mailF.getFecha());
	}

}
