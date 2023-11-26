package ramaCliente;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import ramaCliente.Orden.OrdenExportacion;
import ramaDeposito.Camion;
import ramaDeposito.Chofer;

class ShipperTest {
		
		//Mocks
		@Mock OrdenExportacion ordenExportacion;
		@Mock Chofer chofer;
		@Mock Camion camion;
		
		Shipper shipper;
		
		@BeforeEach
		void setUp() throws Exception {
			
			//Creamos los mocks (dummies)
			chofer = mock(Chofer.class);
			camion = mock(Camion.class);
			
			// Crear el stub con la Orden de Exportacion
			ordenExportacion = mock(OrdenExportacion.class);

	        // Configurar el comportamiento del stub
	        when(ordenExportacion.getChofer()).thenReturn(chofer);
	        when(ordenExportacion.getCamion()).thenReturn(camion);
	        
	        //Instaciamos el Shipper
	        shipper = new Shipper(ordenExportacion);
			
		}

		@Test
		void testInformarCamionDesignado() {
			assertEquals(camion, shipper.informarCamionDesignado());
		}
		
		@Test
		void testInformarChoferDesignado() {
			assertEquals(chofer, shipper.informarChoferDesignado());
		}


}
