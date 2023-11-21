package ramaFasesDelBuque;

public class Outbound implements Fases {
	// ATRIBUTOS:
	private Fases proximoEstado = new Inbound();
	// CONSTRUCTOR:	
	public Outbound() {}

	/*
	 * TODO: REEMPLAZAR ESTE POR LO QUE DICE EL OBJETIVO DE LA CONSIGNA
	 * Este override específico para este estado concreto del buque, lo que intento 
	 * hacer en este codigo es:
	 * 1) pedirle a la terminal de destino, es decir, a la que el buque esté 
	 * llegando, sus coordenadas, es decir, su posición en el plano, el punto (x,y),
	 * (se me ocurre que pueden devolver una tupla),
	 * entonces, calculo, que si esa distancia es mayor o igual a 50 km, 
	 * entonces el buque avisa que todavía está muy lejos de la terminal.
	 * y si eso es falso, simplemente pasa al siguiente estado que es Inbound.
	 * Además saqué al booleano a una subtarea
	 * */
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
