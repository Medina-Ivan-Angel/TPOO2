package ramaFasesDelBuque;

public class Inbound implements Fase {

	private Fase proximoEstado = new Arrived();
	
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
		buque.darPreaviso();
		if (elBuqueArrivo(buque)) {
			buque.setEstado(this.proximoEstado);
		}
		
	public boolean elBuqueArrivo(Buque buque) {
		
		return (buque.getPosicion().equals(buque.getViaje().getTerminalDestino().getPosicion()));
	}
		
}
