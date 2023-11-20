package ramaFasesDelBuque;

public class Outbound implements Fases {

	public Outbound() {
	}
	
	/*
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
	
	@Override
	int coordenadasDeLaTerminalDestino = TerminalDestino.getCoordenada();
	public void accion(Buque buque) {
		if (laDistanciaEntreElBuqueYLaTerminalDestinoEsMayorA50KM(Buque buque)) {
			return true o ("todavía estoy muy lejos de la terminal");
			else {
			buque.setEstado(Inbound);
		}
		
	public boolean laDistanciaEntreElBuqueYLaTerminalDestinoEsMayorA50KM(Buque buque) {
		
		return (buque.calcularDistancia(coordenadasDeLaTerminalDestino) >= 50);
	}

}
