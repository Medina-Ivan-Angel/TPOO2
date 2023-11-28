package ramaAuxiliar;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

class MailFacturaTest {

	//Mock (dummy)
	@Mock Factura factura;
	
	
	MailFactura mailFactura;
	
	@BeforeEach
	void setUp() throws Exception {
		
		mailFactura = new MailFactura(factura);
		
		
	}

	@Test
	void testGetFactura() {
		assertEquals(factura, mailFactura.getFactura());
	}

}
