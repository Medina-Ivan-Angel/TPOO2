package ramaFasesDelBuque;

import java.util.List;

import Terminal.TerminalNormal;
import ramaNavieraCircuitos.Tramo;

public class Departing implements Fase {

	/*
	 * En esta Fase el buque se encuentra saliendo de la terminal,
	 * cuando su distancia con respecto a la terminal es mayor a 
	 * 1 KM, le avisa a la terminal, y luego, el buque pasa
	 * nuevamente a la Fase inicial de Outbound.
	 * */
	
	// ATRIBUTOS:
	
	private Fase proximoEstado = new Outbound();

	// CONSTRUCTOR:
	
	public Departing() {}
		
	// MÉTODOS:
	
	@Override
	public void accion(Buque buque) {
		if (distanciaALaTerminalMayorA1KM(buque)) {
			 buque.darPostAviso();
 			 buque.setEstado(this.proximoEstado);
		}
	}				
	
	public boolean distanciaALaTerminalMayorA1KM(Buque buque) {
		return (buque.calcularDistancia(terminalGestionadaEnLaListaDeTramosEs(buque).getPosicion()) > 1.0); 
	}
	
	public TerminalNormal terminalGestionadaEnLaListaDeTramosEs(Buque buque) {
	
		/*
		 * 1) comprobamos si existe la terminal gestionada
		 * 2) en caso de que exista, devolvemos esa terminal, sino lanzamos una 
		 * excepción.
		 * */
	
		List<Tramo> tramosDelBuque = buque.getViaje().getCircuitoARecorrer().getTramos();
		Boolean hayTerminal = tramosDelBuque.stream()
										    .anyMatch(tramo -> tramo.getDestino().equals(buque.getTerminalGestionada()));
	
		if (hayTerminal) {
		
        	return buque.getTerminalGestionada();
        	
    	} else {
    		
        	throw new RuntimeException("No se encontró la Terminal Gestionada");
        	
    	}		
	}
}
