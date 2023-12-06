package ramaFasesDelBuque;

import java.util.List;

import Terminal.TerminalNormal;
import ramaNavieraCircuitos.Tramo;

public class Outbound implements Fase {

	/*
	 * Esta Fase representa la fase inicial, indica que el buque se encuentra a más de 
	 * 50 KM de la terminal de destino.
	 */

	// ATRIBUTOS:	
	private Fase proximoEstado = new Inbound();
	
	// CONSTRUCTOR:	
	public Outbound() {}

	// MÉTODOS:
	
	@Override
	public void accion(Buque buque) {
		if (distanciaALaTerminalMenorA50KM(buque, buque.getTerminalGestionada())) {
			buque.setEstado(this.proximoEstado);
		}
	}
		
	public boolean distanciaALaTerminalMenorA50KM(Buque buque, TerminalNormal terminalGestionada) {
		return (buque.calcularDistancia(terminalGestionadaEnLaListaDeTramosEs(buque, terminalGestionada).getPosicion()) < 50.0); 
	}
	
	public TerminalNormal terminalGestionadaEnLaListaDeTramosEs(Buque buque, TerminalNormal terminalGestionada) {
	
		/*
		 * 1) comprobamos si existe la terminal gestionada
		 * 2) en caso de que exista, devolvemos esa terminal, sino lanzamos una 
		 * excepción.
		 * */
	
		List<Tramo> tramosDelBuque = buque.getViaje().getCircuitoARecorrer().getTramos();
		Boolean hayTerminal = tramosDelBuque.stream()
										    .anyMatch(tramo -> tramo.getDestino().equals(terminalGestionada));
	
		if (hayTerminal) {
		
        	return terminalGestionada;
        	
    	} else {
    		
        	throw new RuntimeException("No se encontró la Terminal Gestionada");
        	
    	}		
	}
}
