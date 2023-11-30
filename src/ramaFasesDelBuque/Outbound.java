package ramaFasesDelBuque;

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
		return (buque.calcularDistancia(buque.getViaje().getTerminalDestino().getPosicion()) < 50);
	}
	// TODO: Se implementará getTerminalDestino() con la TerminalGestionada.
}
