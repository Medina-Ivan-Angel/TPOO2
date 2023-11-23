import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ramaCliente.Cliente;
import ramaCliente.Consignee;


class BorrameTestNuevo {
	
	Cliente cliente;
	
	Consignee consignee = mock(Consignee.class);
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void test() {
		verify(consignee).getFechaYHoraDeLlegada();
	}

}
