package ramaFasesDelBuque;

public class Departing implements Fase {

	/*
	 * En esta Fase el buque se encuentra saliendo de la terminal,
	 * cuando su distancia con respecto a la terminal es mayor a 
	 * 1 KM, le avisa a la terminal, y luego, el buque pasa
	 * nuevamente a la Fase inicial de Outbound.
	 * */
	
	// ATRIBUTOS:
	
	private Fase proximoEstado = new Outbound();

	// CONSTRUCTOR:
	
	public Departing() {}
		
	// MÉTODOS:
	
	@Override
	public void accion(Buque buque) {
		Coordenada coordenadaBuque = new Coordenada(4, 5);
		if (buque.calcularDistancia(coordenadaBuque) > 1) {
			 buque.darPostAviso();
 			 buque.setEstado(this.proximoEstado);
		}
	}				
}
