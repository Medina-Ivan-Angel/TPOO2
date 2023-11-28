package ramaCliente.Servicios;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import java.time.Duration;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import ramaDeposito.Reefer;

class ElectricidadTest {

	Reefer reefer;			   // reefer que recibe el servicio
	Duration duration; 	   	   // Duracion del servicio
	Electricidad electricidad; // Servicio
	
	
	@BeforeEach
	void setUp() throws Exception {
		
		//Inicializo el reefer que recibira el servicio
		reefer = new Reefer(10, 10, 30, 1000, 10);
		
		// Crear una Duration de 120 minutos (120/60 = 2 hs)
		duration = Duration.ofMinutes(120);
		
		//Precio por Kw
		double precioPorKw = 100;
		
		//Servicio
		electricidad = new Electricidad(reefer, precioPorKw, duration); 
	}

	@Test
	void testCostoTotal() {
		
		assertEquals(2000, electricidad.costoTotal());
	}

}
