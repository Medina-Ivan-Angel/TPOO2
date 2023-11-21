package ramaFasesDelBuque;

public class Inbound implements Fases {
	private int borrame;
	public Inbound() {}
	
	/*
	 * hace tal cual la consigna, acá dice menor, asique pongo menor estricto, 
	 * el mayor o igual lo dejé para el outbound. 
	 * en todas estas fases hay que ver que efectivamente el buque cambie 
	 * adecuadamente de fase en la rama del else.
	 * 
	 * */
	
	@Override
	int coordenadasDeLaTerminalDestino = TerminalDestino.getCoordenada();
	public void accion(Buque buque) {
		if (laDistanciaEntreElBuqueYLaTerminalDestinoEsMenorA50KM(Buque buque)) {
			return buque.darPreaviso();
			else {
			buque.setEstado(Inbound);
		}
		
	public boolean laDistanciaEntreElBuqueYLaTerminalDestinoEsMenorA50KM(Buque buque) {
		
		return (buque.calcularDistancia(coordenadasDeLaTerminalDestino) < 50);
	}
		
		

}
