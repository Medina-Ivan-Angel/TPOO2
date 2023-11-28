package ramaAuxiliar;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import ramaCliente.Consignee;
import ramaCliente.Orden.OrdenImportacion;
import ramaCliente.Servicios.Electricidad;
import ramaCliente.Servicios.Lavado;
import ramaCliente.Servicios.Servicio;

class FacturaConsigneeTest {

	//Mock (stub)
	@Mock Consignee consignee;
	@Mock OrdenImportacion ordenImportacion;
	@Mock Lavado lavado;
	@Mock Electricidad electricidad;
	
	//Parametros de la facturaConsignee
	LocalDateTime fecha;
	
	//FacturaConsignee
	FacturaConsignee facturaC;
	
	@BeforeEach
	void setUp() throws Exception {
		
		//Inicializando los Stub 
		consignee 		 = mock(Consignee.class);
		ordenImportacion = mock(OrdenImportacion.class);
		lavado		     = mock(Lavado.class);
		electricidad     = mock(Electricidad.class);
		
		//Establecemos sus comportamientos
		
		when(consignee.getOrden()).thenReturn(ordenImportacion); //El consignee tiene una orden de importacion
		
		List<Servicio> servicios = Arrays.asList(lavado, electricidad); //Lista de servicios para la orden de importacion
		when(ordenImportacion.getServicios()).thenReturn(servicios);
		
		when(lavado.costoTotal()).thenReturn(1000.0);		//Costo de lavado: 1000
		when(electricidad.costoTotal()).thenReturn(5000.0); //Costo de electricidad: 5000
		
		//Parametro
		fecha = LocalDateTime.of(2023, 11, 28, 15, 30, 0); // año, mes, día, hora, minuto y segundo
		
		//Factura
		facturaC = new FacturaConsignee(fecha, consignee);
		
	}

	@Test
	void testDesgloce() {
		
		String desgloce = "Fecha: 2023-11-28T15:30\n"
						  + "Lavado : 1000.0$\n"
						  + "Electricidad : 5000.0$\n"
						  + "Costo Total por tramos realizados: 0.0\n" //TODO: Cuando cuente con la implementacion de Ignacio corregir este valor
						  + "Monto Total : 6000.0$\n"; 
		
		assertEquals(desgloce,facturaC.desgloce());
	}
	

	@Test
	void testImprimirFecha() {
		
		String fechaEsperada = "Fecha: 2023-11-28T15:30\n"; 
		
		assertEquals(fechaEsperada,facturaC.imprimirFecha());
	}
	
	@Test
	void testImprimirServiciosYCostos() {
		
		String serviciosYCostos = "Lavado : 1000.0$\n"
				  			   + "Electricidad : 5000.0$\n"; 
		
		assertEquals(serviciosYCostos,facturaC.imprimirServiciosYCostos());
	}
	
	@Test
	void testImprimirCostosTramos() {
		//TODO: Este test va a fallar una vez implementado el metodo (ya no da 0). Implementacion Ignacio.
		
		String costosTramos = "Costo Total por tramos realizados: 0.0\n";
		
		assertEquals(costosTramos ,facturaC.imprimirCostosTramos());
	}
	
	@Test
	void testImprimirCostoTotal() {

		String costoTotal = "Monto Total : 6000.0$\n";
		
		assertEquals(costoTotal ,facturaC.imprimirCostoTotal());
	}
	
	@Test
	void testGetCliente() {
		assertEquals(consignee ,facturaC.getCliente());
	}
	
}
