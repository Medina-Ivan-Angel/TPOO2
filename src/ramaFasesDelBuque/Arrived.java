package ramaFasesDelBuque;

import java.util.List;

import Terminal.TerminalNormal;
import ramaNavieraCircuitos.Tramo;

public class Arrived implements Fase {
	
	/*
	 * Esta Fase indica que el buque llegó a la terminal, se entra en esta fase
	 * cuando las coordenadas del buque y la terminal son las mismas.
	 * */

	// ATRIBUTOS:
	private Fase proximoEstado = new Working();
	
	// CONSTRUCTOR:
	
	public Arrived() {}
	
	// MÉTODOS:
	
	@Override 
	public void accion(Buque buque) {
		if (distanciaALaTerminalIgualACero(buque)) {
			buque.iniciarCargaYDescarga(); 
			buque.setEstado(this.proximoEstado);
		}
	}
	
	public boolean distanciaALaTerminalIgualACero(Buque buque) {
		return (buque.calcularDistancia(terminalGestionadaEnLaListaDeTramosEs(buque).getPosicion()) == 0.0); 
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
	
