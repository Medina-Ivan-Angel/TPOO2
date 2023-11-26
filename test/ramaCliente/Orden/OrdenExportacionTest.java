package ramaCliente.Orden;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import Terminal.TerminalNormal;
import ramaCliente.Shipper;
import ramaCliente.Servicios.AlmacenamientoExcedente;
import ramaCliente.Servicios.Electricidad;
import ramaCliente.Servicios.Lavado;
import ramaCliente.Servicios.Pesado;
import ramaCliente.Servicios.Servicio;
import ramaDeposito.Camion;
import ramaDeposito.Chofer;
import ramaDeposito.Container;

class OrdenExportacionTest {

	//Mocks
	@Mock TerminalNormal terminal;
	@Mock LocalDateTime fechaSalidaDeCarga;
	@Mock LocalDateTime fechaLlegadaADestino;
	@Mock Shipper cliente;
	@Mock Container container;
	@Mock Camion camion;
	@Mock Chofer chofer;
	
	OrdenExportacion ordenExportacion;
	
	//Servicios
	@Mock Electricidad electricidad;
	@Mock Lavado lavado;
	@Mock Pesado pesado;
	@Mock AlmacenamientoExcedente almacenamientoExcedente;
	
	//Mock para los metodos setChofer y setCamion
	@Mock Chofer choferReemplazo;
	@Mock Camion camionReemplazo;
	
	@BeforeEach
	void setUp() throws Exception {
		
		//Creamos los mocks (dummies)
		terminal 			 = mock(TerminalNormal.class);
		fechaSalidaDeCarga 	 = mock(LocalDateTime.class);
		fechaLlegadaADestino = mock(LocalDateTime.class);
		cliente 			 = mock(Shipper.class);
		container 			 = mock(Container.class);
		chofer   			 = mock(Chofer.class);
		camion   			 = mock(Camion.class);
		
		//Servicios
		electricidad 			= mock(Electricidad.class);
		lavado 		 			= mock(Lavado.class);
		pesado		 			= mock(Pesado.class);
		almacenamientoExcedente = mock(AlmacenamientoExcedente.class);
		
		//Reemplazos
		choferReemplazo	= mock(Chofer.class);
		camionReemplazo = mock(Camion.class);
		
		ordenExportacion = new OrdenExportacion(terminal,
												fechaSalidaDeCarga,
												fechaLlegadaADestino,
												cliente,
												container,
												camion,
												chofer);

		//Añadimos los servicios a la orden
		ordenExportacion.addServicio(electricidad);
		ordenExportacion.addServicio(lavado);
		ordenExportacion.addServicio(pesado);
		ordenExportacion.addServicio(almacenamientoExcedente);
		
	}

	@Test
	void testGetDestino() {
		assertEquals(terminal, ordenExportacion.getDestino());
	}
	
	@Test
	void testGetFechaSalidaDeCarga() {
		assertEquals(fechaSalidaDeCarga, ordenExportacion.getFechaSalidaDeCarga());
	}
	
	@Test
	void testGetFechaLlegadaADestino() {
		assertEquals(fechaLlegadaADestino, ordenExportacion.getFechaLlegadaADestino());
	}
	
	@Test
	void testGetCliente() {
		assertEquals(cliente, ordenExportacion.getCliente());
	}
	
	@Test
	void testGetChofer() {
		assertEquals(chofer, ordenExportacion.getChofer());
	}
	
	@Test
	void testGetCamion() {
		assertEquals(camion, ordenExportacion.getCamion());
	}
	
	@Test
	void testGetCarga() {
		assertEquals(container, ordenExportacion.getCarga());
	}

	
	@Test
	void testGetServicios() {
		
		List<Servicio> listaResultado = Arrays.asList(electricidad ,
													  lavado ,
													  pesado,
													  almacenamientoExcedente);
		
		assertEquals(listaResultado, ordenExportacion.getServicios());
	}
	
	@Test
	void testSetCamion() {
		
		ordenExportacion.setCamion(camionReemplazo);
		
		assertEquals(camionReemplazo, ordenExportacion.getCamion());
	}
	
	@Test
	void testSetChofer() {
		
		ordenExportacion.setChofer(choferReemplazo);
		
		assertEquals(choferReemplazo, ordenExportacion.getChofer());
	}
	
	
	
	
}
