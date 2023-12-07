package ramaTerminalTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import Terminal.TerminalGestionada;
import Terminal.TerminalNormal;
import ramaAuxiliar.Mail;
import ramaAuxiliar.MailFecha;
import ramaCliente.Cliente;
import ramaCliente.Consignee;
import ramaCliente.Shipper;
import ramaCliente.Orden.OrdenExportacion;
import ramaCliente.Orden.OrdenImportacion;
import ramaDeposito.Camion;
import ramaDeposito.Chofer;
import ramaDeposito.Container;
import ramaDeposito.Deposito;
import ramaDeposito.Dry;
import ramaDeposito.EmpresaDeTransporte;
import ramaDeposito.Reefer;
import ramaDeposito.Tanque;
import ramaFasesDelBuque.Buque;
import ramaFasesDelBuque.Coordenada;
import ramaFasesDelBuque.Fase;
import ramaFasesDelBuque.Outbound;
import ramaNavieraCircuitos.Circuito;
import ramaNavieraCircuitos.Naviera;
import ramaNavieraCircuitos.Tramo;
import ramaNavieraCircuitos.Viaje;

class TerminalGestionadaTest {

	//Coordenadas de los buques

	Coordenada c1;
	Coordenada c2;
	Coordenada c3;
	Coordenada c4;
	Coordenada c5;

	
	//Buques
	Buque buque1;
	Buque buque2;
	Buque buque3;
	Buque buque4;
	Buque buque5;
	
	//Lista de buques para la naviera
	List<Buque> buques1;
	List<Buque> buques2;
	
	//Viajes
	Viaje viaje1;
	Viaje viaje2;
	Viaje viaje3;
	Viaje viaje4;
	Viaje viaje5;
	
	
	//Mocks fechaDeSalida de los viajes
	@Mock LocalDateTime fecha1;
	@Mock LocalDateTime fecha2;
	@Mock LocalDateTime fecha3;
	@Mock LocalDateTime fecha4;
	@Mock LocalDateTime fecha5;
	
	//Mocks fechaDeLlegada de los viajes
	@Mock LocalDateTime fechaL1;
	@Mock LocalDateTime fechaL2;
	@Mock LocalDateTime fechaL3;
	@Mock LocalDateTime fechaL4;
	@Mock LocalDateTime fechaL5;
	
	
	//Circuitos y Tramos 
	
	Circuito circuito1;
	Circuito circuito2;
	Circuito circuito3;
	Circuito circuito4;
	Circuito circuito5;
	
	//Listas de circuitos para las navieras
	List<Circuito> circuitos1;
	List<Circuito> circuitos2;
	
	Tramo tramo1;
	Tramo tramo2;
	Tramo tramo3;
	Tramo tramo4;
	Tramo tramo5;
	Tramo tramo6;
	Tramo tramo7;
	Tramo tramo8;
	Tramo tramo9;
	Tramo tramo10;
	
	//Listas de tramos para los circuitos
	List<Tramo> tramos1;
	List<Tramo> tramos2;
	List<Tramo> tramos3;
	List<Tramo> tramos4;
	List<Tramo> tramos5;
	
	//Navieras
	Naviera naviera1;
	Naviera naviera2;
	
	//Clientes (Shipper y Consignee)
	
	Shipper shipper1;
	Shipper shipper2;
	Shipper shipper3;
	
	Consignee consignee1;
	Consignee consignee2;
	Consignee consignee3;
	

	TerminalGestionada terminalGestionada;
	
	//Parametros del constructor de la terminalGestionada
	Coordenada posicionTerminal;
	List<Naviera> navieras;
	List<Cliente> clientes;
	
	//Mock
	@Mock Deposito depositoMock;
	
	//Mocks (dummies)
	@Mock TerminalNormal BuenosAires;
	@Mock TerminalNormal SanPablo;
	@Mock TerminalNormal Marsella;
	@Mock TerminalNormal Cadiz;
	@Mock TerminalNormal Venecia;
	@Mock TerminalNormal Estambul;
	@Mock TerminalNormal Oslo;
	@Mock TerminalNormal Peru;
	@Mock TerminalNormal Japon;
	@Mock TerminalNormal Sudafrica;
	@Mock TerminalNormal China;
	
	//Empresas de Transporte para las ordenes
	@Mock EmpresaDeTransporte emp1;
	@Mock EmpresaDeTransporte emp2;
	@Mock EmpresaDeTransporte emp3;
	
	@Mock Camion camion1;
	@Mock Camion camion2;
	@Mock Camion camion3;
	
	@Mock Chofer chofer1;
	@Mock Chofer chofer2;
	@Mock Chofer chofer3;
	
	//Containers para las ordenes de exp/imp
	Reefer reefer;
	Dry dry;
	Tanque tanque;
	
	
	//Ordenes de Importacion
	OrdenImportacion ordenI1;
	OrdenImportacion ordenI2;
	OrdenImportacion ordenI3;
	
	OrdenExportacion ordenE1;
	OrdenExportacion ordenE2;
	OrdenExportacion ordenE3;
	
	
	
	
	@BeforeEach
	void setUp() throws Exception {
		
		//Inicializamos los mocks
		BuenosAires = mock(TerminalNormal.class);
		SanPablo	= mock(TerminalNormal.class);
		Marsella	= mock(TerminalNormal.class);
		Cadiz		= mock(TerminalNormal.class);
		Venecia		= mock(TerminalNormal.class);
		Estambul	= mock(TerminalNormal.class);
		Oslo		= mock(TerminalNormal.class);
		Peru		= mock(TerminalNormal.class);
		Japon		= mock(TerminalNormal.class);
		Sudafrica	= mock(TerminalNormal.class);
		China		= mock(TerminalNormal.class);
		
		//Fechas de salida de los viajes
		fecha1		= mock(LocalDateTime.class);
		fecha2		= mock(LocalDateTime.class);
		fecha3		= mock(LocalDateTime.class);
		fecha4		= mock(LocalDateTime.class);
		fecha5		= mock(LocalDateTime.class);
		
		//Fechas de Llegada de los viajes
		fechaL1		= mock(LocalDateTime.class);
		fechaL2		= mock(LocalDateTime.class);
		fechaL3		= mock(LocalDateTime.class);
		fechaL4		= mock(LocalDateTime.class);
		fechaL5		= mock(LocalDateTime.class);
		
		//Empresas de transporte para las ordenes
		emp1 = mock(EmpresaDeTransporte.class);
		emp2 = mock(EmpresaDeTransporte.class);
		emp3 = mock(EmpresaDeTransporte.class);
		
		//Camiones y choferes
		camion1 = mock(Camion.class);
		camion2 = mock(Camion.class);
		camion3 = mock(Camion.class);
		
		chofer1 = mock(Chofer.class);
		chofer2 = mock(Chofer.class);
		chofer3 = mock(Chofer.class);
		//Containers para las ordenes
		reefer = new Reefer(10, 10, 20, 1000, 50);
		dry	   = new Dry(10, 20, 30, 1000);
		tanque = new Tanque(10, 30, 30, 1000);
		
		//Coordenadas de los buques
		c1				 = new Coordenada(1000,10);
		c2 				 = new Coordenada(2000,10);
		c3 				 = new Coordenada(3000,10);
		c4 				 = new Coordenada(4000,10);
		c5 				 = new Coordenada(5000,10);
		posicionTerminal = new Coordenada(0,0);
		

		//Creamos las listas de containers que son la carga de los buques
		List<Container> cargaReefer = Arrays.asList(reefer);
		List<Container> cargaDry = Arrays.asList(dry);
		List<Container> cargaTanque = Arrays.asList(tanque);
		
		/*Fase estado,
		 * Viaje viaje, 
		 * Coordenada posicion,
		 * List<Container> containers,
		 * TerminalGestionada terminalGestionada
		*/
	
		buque1 = new Buque(new Outbound(),viaje1,c1,cargaReefer, terminalGestionada);
		buque2 = new Buque(new Outbound(),viaje2,c2,cargaDry, terminalGestionada);
		buque3 = new Buque(new Outbound(),viaje3,c3,cargaTanque, terminalGestionada);
		buque4 = new Buque(new Outbound(),viaje4,c4,null, terminalGestionada);
		buque5 = new Buque(new Outbound(),viaje5,c5,null, terminalGestionada);
		
		//Lista de buques para la naviera
		buques1 = Arrays.asList(buque1, buque2);
		buques2 = Arrays.asList(buque3, buque4, buque5);
		
		/*
		 * TerminalNormal origen, 
		 * TerminalNormal destino, 
		 * double distanciaEntrePuertos,
		 * double duracionDelTramo, 
		   double costoDelTramo
		 */
		
		tramo1  = new Tramo(BuenosAires, SanPablo, 10, 10, 10);
		tramo2  = new Tramo(SanPablo, Marsella, 20, 20, 20);
		tramo3  = new Tramo(Marsella, Cadiz, 30, 30, 30);
		tramo4  = new Tramo(Cadiz, Venecia, 40, 40, 40);
		tramo5  = new Tramo(Venecia, Estambul, 50, 50, 50);
		tramo6  = new Tramo(Estambul, Oslo, 60, 60, 60);
		tramo7  = new Tramo(Oslo, Peru, 70, 70, 70);
		tramo8  = new Tramo(Peru, Japon, 80, 80, 80);
		tramo9  = new Tramo(Japon, Sudafrica, 90, 90, 90);
		tramo10 = new Tramo(Sudafrica, China, 100, 100, 100);
		
		//Listas de tramos para los circuitos
		tramos1 = Arrays.asList(tramo1, tramo2);
		tramos2 = Arrays.asList(tramo1, tramo2, tramo3);
		tramos3 = Arrays.asList(tramo1, tramo2, tramo3, tramo4, tramo5);
		tramos4 = Arrays.asList(tramo1, tramo2, tramo3, tramo4, tramo5, tramo6, tramo7);
		tramos5 = Arrays.asList(tramo1, tramo2, tramo3, tramo4, tramo5, tramo6, tramo7, tramo8, tramo9, tramo10);
		
		
		circuito1 = new Circuito(tramos1);
		circuito2 = new Circuito(tramos2);
		circuito3 = new Circuito(tramos3);
		circuito4 = new Circuito(tramos4);
		circuito5 = new Circuito(tramos5);
		
		//Listas de circuitos para las navieras
		circuitos1 = Arrays.asList(circuito1,circuito2);
		circuitos2 = Arrays.asList(circuito3,circuito4,circuito5);
		
		
		/*
		 * LocalDateTime fechaDeSalida,
		 * Circuito circuitoARecorrer,
		 * TerminalNormal terminalDestino,
		 * LocalDateTime fechaLlegadaADestino
		 */
		viaje1 = new Viaje(fecha1,circuito1, Marsella,fechaL1);
		viaje2 = new Viaje(fecha2,circuito2, Cadiz, fechaL2);
		viaje3 = new Viaje(fecha3,circuito3, Estambul, fechaL3);
		viaje4 = new Viaje(fecha4,circuito4, Peru, fechaL4);
		viaje5 = new Viaje(fecha5,circuito5, China, fechaL5);
		
		//Navieras de la terminalGestionada
		/*
		 * List<Buque> flota, List<Circuito> circuitosMaritimos
		 */
		naviera1 = new Naviera(buques1, circuitos1);
		naviera2 = new Naviera(buques2, circuitos2);
		
		navieras = Arrays.asList(naviera1,naviera2); // Para la terminal gestionada
		
		//Clientes
		shipper1 = new Shipper();
		shipper1.setOrden(ordenE1); //Asignamos la orden al shipper
		
		shipper2 = new Shipper();
		shipper2.setOrden(ordenE2); //Asignamos la orden al shipper
		
		shipper3 = new Shipper();
		shipper3.setOrden(ordenE3); //Asignamos la orden al shipper
		
		consignee1 = new Consignee(ordenI1);
		consignee2 = new Consignee(ordenI2);
		consignee3 = new Consignee(ordenI3);
		
		//Instanciamos y Asignamos las ordenes
		
		/*
		 * Consignee cliente, 
		   Container carga,
		   TerminalNormal origen,
		   Buque buque, 
		   EmpresaDeTransporte empresaDeTransporte
		 */
		
		ordenI1 = new OrdenImportacion(consignee1, reefer, BuenosAires, buque1, emp1);
		ordenI2 = new OrdenImportacion(consignee2, dry, BuenosAires, buque2, emp2);
		ordenI3 = new OrdenImportacion(consignee3, tanque, BuenosAires, buque3, emp3);
		
		/*
		 * TerminalNormal destino,
			LocalDateTime fechaSalidaDeCarga,
			LocalDateTime fechaLlegadaADestino,
			Shipper cliente,
			Container carga,
		    Camion camion,
			Chofer chofer,
			EmpresaDeTransporte empresaDeTransporte,
			Buque buque
		 */
		
		ordenE1 = new OrdenExportacion(Cadiz, fecha1, fechaL1, shipper1, reefer,camion1,chofer1, emp1, buque1);
		ordenE2 = new OrdenExportacion(Marsella, fecha2, fechaL2, shipper2, dry, camion2,chofer2, emp2, buque2);
		ordenE3 = new OrdenExportacion(China, fecha3, fechaL3, shipper3, tanque, camion3,chofer3,emp3, buque3);
		
		//Instanciamos la terminal Gestionada
		/*
		 * Coordenada posicion, 
		   List<Naviera> navieras,
		   List<Cliente> clientes,
		   Deposito deposito,
		   double costo
		 * 
		 */
		terminalGestionada = new TerminalGestionada(posicionTerminal, navieras,clientes,depositoMock, 100);
	
		//Stub depositoMock. Establecemos el comportamiento
		doNothing().when(depositoMock).addOrdenImportacion(ordenI1);
		doNothing().when(depositoMock).addOrdenImportacion(ordenI2);
		doNothing().when(depositoMock).addOrdenImportacion(ordenI3);
		
		doNothing().when(depositoMock).addOrdenExportacion(ordenE1);
		doNothing().when(depositoMock).addOrdenExportacion(ordenE2);
		doNothing().when(depositoMock).addOrdenExportacion(ordenE3);
	
	}

	@Test
	void testImportacion() {
		
		/*
		 * El consignee1 hace realiza un operacion de importacion en la terminal
		 * 1) debe recibir un mail con la fecha de llegada del buque
		 */
		
		terminalGestionada.importacion(consignee1); 
		
		
		MailFecha mailFecha = new MailFecha(consignee1.getOrden().getfechaLlegadaDeCarga());
		List<Mail> listaEsperada = Arrays.asList(mailFecha);
		
		assertEquals(listaEsperada,consignee1.getBuzon());
	}

}
