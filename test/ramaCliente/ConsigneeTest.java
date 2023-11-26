package ramaCliente;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import ramaCliente.Orden.OrdenImportacion;
import ramaDeposito.Camion;
import ramaDeposito.Chofer;

class ConsigneeTest {

	//Mocks
	@Mock OrdenImportacion ordenImportacion;
	@Mock Chofer chofer;
	@Mock Camion camion;
	
	Consignee consignee;
	
	@BeforeEach
	void setUp() throws Exception {
		
		//Creamos los mocks (dummies)
		chofer = mock(Chofer.class);
		camion = mock(Camion.class);
		
		// Crear el stub con la Orden de Importacion
		ordenImportacion = mock(OrdenImportacion.class);

        // Configurar el comportamiento del stub
        when(ordenImportacion.getChofer()).thenReturn(chofer);
        when(ordenImportacion.getCamion()).thenReturn(camion);
        
        //Instaciamos el consignee
        consignee = new Consignee(ordenImportacion);
		
	}

	@Test
	void testInformarCamionDesignado() {
		assertEquals(camion, consignee.informarCamionDesignado());
	}
	
	@Test
	void testInformarChoferDesignado() {
		assertEquals(chofer, consignee.informarChoferDesignado());
	}

}
