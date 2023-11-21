package ramaFasesDelBuque;

public class Inbound implements Fases {
	
	/*
	 * hace tal cual la consigna, acá dice menor, asique pongo menor estricto, 
	 * el mayor o igual lo dejé para el outbound. 
	 * en todas estas fases hay que ver que efectivamente el buque cambie 
	 * adecuadamente de fase en la rama del else.
	 * 
	 * */
	
	public Inbound() {}
	
	@Override
	public void accion(Buque buque) {
		if (distanciaALaTerminalMenorA50KM(Buque buque)) {
			return buque.darPreaviso();
			else {
			buque.setEstado(Inbound);
		}
		
	public boolean distanciaALaTerminalMenorA50KM(Buque buque) {
		
		return (buque.calcularDistancia(coordenadasDeLaTerminalDestino) < 50);
	}
		
		

}
