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

import ramaCliente.Shipper;
import ramaCliente.Orden.OrdenExportacion;
import ramaCliente.Servicios.Electricidad;
import ramaCliente.Servicios.Lavado;
import ramaCliente.Servicios.Servicio;

class FacturaShipperTest {

	//Mock (stub)
	@Mock Shipper shipper;
	@Mock OrdenExportacion ordenExportacion;
	@Mock Lavado lavado;
	@Mock Electricidad electricidad;
		
	//Parametros de la facturaShipper
	LocalDateTime fecha;
	
	//Factura
	FacturaShipper facturaS;

	
	
	@BeforeEach
	void setUp() throws Exception {
		
		//Inicializando los Stub 
		shipper			 = mock(Shipper.class);
		ordenExportacion = mock(OrdenExportacion.class);
		lavado		     = mock(Lavado.class);
		electricidad     = mock(Electricidad.class);
		
		//Establecemos sus comportamientos
		
		when(shipper.getOrden()).thenReturn(ordenExportacion); //El consignee tiene una orden de importacion
				
		List<Servicio> servicios = Arrays.asList(lavado, electricidad); //Lista de servicios para la orden de importacion
		when(ordenExportacion.getServicios()).thenReturn(servicios);
				
		when(lavado.costoTotal()).thenReturn(1000.0);		//Costo de lavado: 1000
		when(electricidad.costoTotal()).thenReturn(5000.0); //Costo de electricidad: 5000
				
		//Parametro
		fecha = LocalDateTime.of(2023, 11, 28, 15, 30, 0); // año, mes, día, hora, minuto y segundo
		
		//Factura
		facturaS = new FacturaShipper(fecha, shipper);
	}

	
	@Test
	void testDesgloce() {
		
		String desgloce = "Fecha: 2023-11-28T15:30\n"
						  + "Lavado : 1000.0$\n"
						  + "Electricidad : 5000.0$\n"
						  + "" 
						  + "Monto Total : 6000.0$\n"; 
		
		assertEquals(desgloce,facturaS.desgloce());
	}
	
	@Test
	void testImprimirCostoTotal() {
		
		String costoTotal = "Monto Total : 6000.0$\n"; 
		
		assertEquals(costoTotal,facturaS.imprimirCostoTotal());
	}

}
