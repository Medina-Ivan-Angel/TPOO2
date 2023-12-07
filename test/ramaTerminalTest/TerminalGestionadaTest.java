package ramaTerminalTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import Terminal.TerminalGestionada;
import Terminal.TerminalNormal;
import ramaCliente.Cliente;
import ramaCliente.Consignee;
import ramaCliente.Shipper;
import ramaDeposito.Container;
import ramaDeposito.Deposito;
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
				
		//Coordenadas de los buques
		c1 = new Coordenada(10,10);
		c2 = new Coordenada(20,10);
		c3 = new Coordenada(30,10);
		c4 = new Coordenada(40,10);
		c5 = new Coordenada(50,10);
		
		/*Fase estado,
		 * Viaje viaje, 
		 * Coordenada posicion,
		 * List<Container> containers,
		 * TerminalGestionada terminalGestionada
		*/
		buque1 = new Buque(new Outbound(),viaje1,c1,null, terminalGestionada);
		buque2 = new Buque(new Outbound(),viaje2,c2,null, terminalGestionada);
		buque3 = new Buque(new Outbound(),viaje3,c3,null, terminalGestionada);
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
		shipper2 = new Shipper();
		shipper3 = new Shipper();
		
		consignee1 = new Consignee(ordenImportacion1);
		consignee2 = new Consignee(ordenImportacion2);
		consignee3 = new Consignee(ordenImportacion3);
		
		//TODO: CREAR LAS ORDENES DE IMPORTACION, van a requerir de empresasdetransporte.
		
		
	}

	@Test
	void test() {
		fail("Not yet implemented");
	}

}
