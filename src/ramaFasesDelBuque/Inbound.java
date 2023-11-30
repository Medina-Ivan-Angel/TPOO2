package ramaFasesDelBuque;

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
		
		return (buque.getPosicion().equals(buque.getViaje().getTerminalDestino().getPosicion()));
	}
		
}
