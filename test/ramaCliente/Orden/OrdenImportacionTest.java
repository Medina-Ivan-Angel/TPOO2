package ramaCliente.Orden;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import Terminal.TerminalNormal;
import ramaCliente.Consignee;
import ramaDeposito.Camion;
import ramaDeposito.Chofer;
import ramaDeposito.Container;
import ramaDeposito.EmpresaDeTransporte;
import ramaFasesDelBuque.Buque;

class OrdenImportacionTest {

	//Mocks
	@Mock TerminalNormal terminalOrigen;
	@Mock LocalDateTime fechaLlegadaDeCarga; // settear
	@Mock Camion camion; 					 // settear
	@Mock Chofer chofer; 					 // settear
	@Mock Buque buque;
	@Mock Consignee cliente;
	@Mock Container carga;
	
	OrdenImportacion ordenImportacion;
	
	//Para probar los setters
	@Mock LocalDateTime fechaLlegadaDeCargaReemplazo;
	@Mock Camion camionReemplazo; 
	@Mock Chofer choferReemplazo;
	@Mock EmpresaDeTransporte emp1;
	
	@BeforeEach
	void setUp() throws Exception {
		
		//Creamos los mocks (dummies)
		terminalOrigen		= mock(TerminalNormal.class);
		fechaLlegadaDeCarga	= mock(LocalDateTime.class);
		camion				= mock(Camion.class);
		chofer				= mock(Chofer.class);
		buque				= mock(Buque.class);
		cliente				= mock(Consignee.class);
		carga				= mock(Container.class);
		
		emp1 				= mock(EmpresaDeTransporte.class);
		
		//Instaciamos la orden de Importacion
		ordenImportacion = new OrdenImportacion(cliente, carga, terminalOrigen, buque, emp1);
		
		//Seteamos los valores que deberian configurarse en la terminal
		ordenImportacion.setFechaLlegadaDeCarga(fechaLlegadaDeCarga);
		ordenImportacion.setCamion(camion);
		ordenImportacion.setChofer(chofer);
		
	}

	@Test
	void testSetFechaLlegadaDeCarga() {
	
		ordenImportacion.setFechaLlegadaDeCarga(fechaLlegadaDeCargaReemplazo);
		assertEquals(fechaLlegadaDeCargaReemplazo,ordenImportacion.getfechaLlegadaDeCarga());
	}
	
	@Test
	void testGetfechaLlegadaDeCarga() {
		
		assertEquals(fechaLlegadaDeCarga,ordenImportacion.getfechaLlegadaDeCarga());
	}
	
	@Test
	void testGetOrigen() {
		assertEquals(terminalOrigen,ordenImportacion.getOrigen());
	}
	
	@Test
	void testGetBuque() {
		assertEquals(buque,ordenImportacion.getBuque());
	}
	
	@Test
	void testGetChofer() {
		assertEquals(chofer, ordenImportacion.getChofer());
	}
	
	@Test
	void testGetCamion() {
		assertEquals(camion, ordenImportacion.getCamion());
	}
	
}
