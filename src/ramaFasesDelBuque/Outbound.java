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
		if (distanciaALaTerminalMenorA50KM(buque)) {
			buque.setEstado(this.proximoEstado);
		}
	}
		
	public boolean distanciaALaTerminalMenorA50KM(Buque buque) {
		return (buque.calcularDistancia(terminalGestionadaEnLaListaDeTramosEs(buque).getPosicion()) < 50.0); 
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
