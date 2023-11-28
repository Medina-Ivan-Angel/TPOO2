package ramaCliente.Servicios;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import ramaDeposito.Container;

class LavadoTest {

	//Mock (stub)
	@Mock Container containerChico;		//Volumen < 70
	@Mock Container containerGrande;	//Volumen > 70 
	
	//Servicio
	Lavado lavado;
	
	@BeforeEach
	void setUp() throws Exception {
		
		//Establecemos los stub y sus comportamientos predefinidos
		containerChico = mock(Container.class);
		
		when(containerChico.getAncho()).thenReturn(2.0); 	//Ancho
		when(containerChico.getLargo()).thenReturn(3.0);	//Largo
		when(containerChico.getAltura()).thenReturn(5.0);	//Altura
															//Volumen = 30
		
		containerGrande = mock(Container.class);
		
		when(containerGrande.getAncho()).thenReturn(10.0); 	//Ancho
		when(containerGrande.getLargo()).thenReturn(20.0);	//Largo
		when(containerGrande.getAltura()).thenReturn(10.0);	//Altura
															//Volumen = 2000
		
		
	}

	@Test
	void testCostoTotalMenor() {

		//Inicializamos el servicio
		lavado = new Lavado(containerChico, 100, 500);
		
		assertEquals(100, lavado.costoTotal());
	}
	
	@Test
	void testCostoTotalMayor() {
		
		//Establecemos el containerGrande para el servicio
		lavado = new Lavado(containerGrande, 100, 500);
		
		assertEquals(500, lavado.costoTotal());
	}

}
