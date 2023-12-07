package ramaDeposito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ramaCliente.Orden.OrdenExportacion;
import ramaCliente.Orden.OrdenImportacion;

public class DepositoTestCase {

	private List<OrdenExportacion> ordenesExp = new ArrayList<OrdenExportacion>();
	private List<OrdenImportacion> ordenesImp = new ArrayList<OrdenImportacion>();
	private List<Container> containers = new ArrayList<Container>();
	
	private Camion mockCamionDescarga;
	private Camion mockCamionCarga;
	
	
	private Chofer mockChoferCarga;
	private Chofer mockChoferDescarga;
	
	
	private OrdenImportacion mockOrdenImp;
	private OrdenExportacion mockOrdenExp;

	
	private Tanque mockTanque;
	private Dry mockDry;
	
	
	private Deposito deposito;
	
	@BeforeEach
	public void setUp() throws Exception {
		// Creo todos los mocks.
		mockOrdenImp = mock(OrdenImportacion.class);
		mockOrdenExp = mock(OrdenExportacion.class);
		mockCamionDescarga = mock(Camion.class);
		mockCamionCarga = mock(Camion.class);
		mockChoferDescarga = mock(Chofer.class);
		mockChoferCarga = mock(Chofer.class);
		mockTanque = mock(Tanque.class);
		mockDry = mock(Dry.class);
		
		
		// Le doy comportamiento a los mocks.
			// Comportamiento para sacar a los conductores de los camiones.
		when(mockCamionDescarga.getConductor()).thenReturn(mockChoferDescarga);
		when(mockCamionCarga.getConductor()).thenReturn(mockChoferCarga);
		
			// Comportamiento para el metodo descargar.
        when(mockCamionDescarga.descargar()).thenReturn(mockTanque);
        
        	// Comportamiento para corroborar el metodo descargar.
        when(mockCamionDescarga.getHraDeLlegada()).thenReturn(LocalDateTime.now());
        when(mockOrdenExp.getFechaSalidaDeCarga()).thenReturn(LocalDateTime.now());

    	// Comportamiento para corroborar el metodo cargar.
        when(mockCamionCarga.getHraDeLlegada()).thenReturn(LocalDateTime.now());
        when(mockOrdenImp.getfechaLlegadaDeCarga()).thenReturn(LocalDateTime.now());

        
        	// Comportamiento para sacar los camiones de las ordenes.
        when(mockOrdenImp.getCamion()).thenReturn(mockCamionCarga);
        when(mockOrdenExp.getCamion()).thenReturn(mockCamionDescarga);
        
        	// Comportamiento para sacar a los choferes de las ordenes.
        when(mockOrdenImp.getChofer()).thenReturn(mockChoferCarga);
        when(mockOrdenExp.getChofer()).thenReturn(mockChoferDescarga);
        
        	// Comportamiento cuando se carga el camion.
        when(mockOrdenImp.getCarga()).thenReturn(mockDry);
		
		// Agrego las ordenes y container a sus listas.
		ordenesExp.add(mockOrdenExp);
		ordenesImp.add(mockOrdenImp);
		containers.add(mockDry);
		
		
		// Uso el constructor para crear un deposito con las instancias ya creadas.
		deposito = new Deposito(ordenesImp, ordenesExp, containers, 1000, 1000);
	}
	
	@Test
	public void testRegistrarCargaEnElPuerto() throws Exception {
		 deposito.registrarCargaEnElPuerto(mockCamionDescarga);

	     // Verificar que el container fue añadido a la lista.
		 assertEquals(2, deposito.getContainers().size());
	     assertEquals(mockTanque, deposito.getContainers().get(1));
	}
	
	@Test
	public void testCargarCamion() throws Exception {
		deposito.cargarCamion(mockCamionCarga);
		
		// Verificar que el container no esta en la lista de carga.
		assertEquals(0, deposito.getContainers().size());
	}
	
}
