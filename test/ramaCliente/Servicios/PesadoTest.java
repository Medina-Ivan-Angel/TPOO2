package ramaCliente.Servicios;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import ramaDeposito.Container;

class PesadoTest {

	//Mock (stub)
	@Mock Container container;
	
	//Servicio
	Pesado pesado;
	
	@BeforeEach
	void setUp() throws Exception {
		
		//Inicializamos el stub y su comportamiento
		container = mock(Container.class);
		
		when(container.getPeso()).thenReturn(1000.0);	//PESO = 1000.0
		
		//Servicio
		pesado = new Pesado(500, container);
		
	}

	@Test
	void testCostoTotal() {
		assertEquals(500, pesado.costoTotal());
	}
	
	@Test
	void testpesarContainer() {
		assertEquals(1000.0, pesado.pesarContainer());
	}

}
