import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import ramaCliente.Cliente;
import ramaCliente.Consignee;
import ramaDeposito.Dry;


class BorrameTestNuevo {
	
	
	
	Cliente cliente;
	
	@Mock
	Dry mockDry = mock(Dry.class);
	
	@BeforeEach
	void setUp() throws Exception {
		
		
		
	}
	
	

	@Test
	void test() {
		
		when(mockDry.getAltura()).thenReturn(10.0);
		
		double alturaObtenida = mockDry.getAltura();
		
		verify(mockDry).getAltura();
		
		assertEquals(10.0, alturaObtenida);
	}

}
