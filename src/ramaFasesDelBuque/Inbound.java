package ramaFasesDelBuque;

import java.util.List;

import Terminal.TerminalNormal;
import ramaNavieraCircuitos.Tramo;

public class Inbound implements Fase {
	
	/*
	 * En esta Fase, el buque se encuentra a menos de 50 KM de la terminal de destino, 
	 * cuando entra en esta fase, da aviso a la terminal de su inminente arrivo. 
	 */
	
	// ATRIBUTOS:
	
	private Fase proximoEstado = new Arrived();
	
	// CONSTRUCTOR:
	
	public Inbound() {}
	
	// MÉTODOS:
	
	@Override
	public void accion(Buque buque) {
		buque.darPreaviso();
		if (elBuqueArrivo(buque)) {
			buque.setEstado(this.proximoEstado);
		}
	}
		
	public boolean elBuqueArrivo(Buque buque) {
		
		return (buque.calcularDistancia(posicionDeLaTerminalGestionadaEnLaListaDeTramosEs(buque)) == 0.0); 	
	}
	
	
	public Coordenada posicionDeLaTerminalGestionadaEnLaListaDeTramosEs(Buque buque) {
	
		List<Tramo> tramosDelBuque = buque.getViaje().getCircuitoARecorrer().getTramos();
		Boolean hayTerminal = tramosDelBuque.stream()
										    .anyMatch(tramo -> tramo.getDestino().equals(buque.getTerminalGestionada()));
	
		if (hayTerminal) {
		
        	return buque.getTerminalGestionada().getPosicion();
        	
    	} else {
    		
        	throw new RuntimeException("No se encontró la Terminal Gestionada");
        	
    	}		
	}
}
