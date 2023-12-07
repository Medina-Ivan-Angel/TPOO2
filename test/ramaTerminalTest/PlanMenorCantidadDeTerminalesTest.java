package ramaTerminalTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import Terminal.PlanMenorCantidadDeTerminales;
import Terminal.PlanMenorTiempo;
import Terminal.TerminalNormal;
import ramaNavieraCircuitos.Circuito;
import ramaNavieraCircuitos.Tramo;

class PlanMenorCantidadDeTerminalesTest {

	Circuito circuitoMasCorto;
	Circuito circuitoMedio;
	Circuito circuitoLargo;
	
	Tramo primerTramo;
	Tramo segundoTramo;
	Tramo tercerTramo;
	Tramo cuartoTramo;
	Tramo quintoTramo;
	Tramo sextoTramo;
	
	PlanMenorCantidadDeTerminales planMenorCantidadDeTerminales;
	
	
	List<Tramo> listaCorta;
	List<Tramo> listaMedia;
	List<Tramo> listaLarga;
	
	List<Circuito> circuitos;
	
	//Mocks (dummies)
	@Mock TerminalNormal BuenosAires;
	@Mock TerminalNormal SanPablo;
	@Mock TerminalNormal Marsella;
	@Mock TerminalNormal Cadiz;
	@Mock TerminalNormal Venecia;
	@Mock TerminalNormal Estambul;
	@Mock TerminalNormal Oslo;
	
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
		
		
		//Inicializamos los tramos
		//Parametros: Origen, Destino, distanciaEntrePuertos,duracionDelTramo,costoDelTramo
		primerTramo  = new Tramo(BuenosAires, SanPablo, 100, 100, 1000); 
		segundoTramo = new Tramo(SanPablo,Marsella, 200, 200, 2000);
		tercerTramo	 = new Tramo(Marsella, Cadiz, 300, 300, 3000);
		cuartoTramo  = new Tramo(Cadiz, Venecia, 400, 400, 4000);
		quintoTramo  = new Tramo(Venecia,Estambul, 500, 500, 5000);
		sextoTramo   = new Tramo(Estambul, Oslo, 600, 600, 6000);
		
		//Listas de tramos para los circuitos
		listaCorta = Arrays.asList(primerTramo, segundoTramo);
		listaMedia = Arrays.asList(primerTramo,segundoTramo,tercerTramo,cuartoTramo);
		listaLarga = Arrays.asList(primerTramo,segundoTramo,tercerTramo,cuartoTramo, quintoTramo, sextoTramo);
		
		//Inicializamos los circuitos con las listas de tramos
		circuitoMasCorto = new Circuito(listaCorta);
		circuitoMedio	 = new Circuito(listaMedia);
		circuitoLargo    = new Circuito(listaLarga);
		
		//Creamos la lista de circuitos para el plan
		circuitos = Arrays.asList(circuitoMasCorto, circuitoMedio,circuitoLargo);
		
		//Instanciamos el Plan
		planMenorCantidadDeTerminales = new PlanMenorCantidadDeTerminales();
	
	}

	@Test
	void testOperacionCorto() {
		assertEquals(circuitoMasCorto, planMenorCantidadDeTerminales.operacion(BuenosAires, Marsella, circuitos));
	}
	
	@Test
	void testOperacionMedio() {
		assertEquals(circuitoMedio, planMenorCantidadDeTerminales.operacion(BuenosAires, Venecia, circuitos));
	}
	
	
}
