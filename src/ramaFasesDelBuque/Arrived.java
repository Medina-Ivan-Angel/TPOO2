package ramaFasesDelBuque;

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
		Coordenada coordenadaBuque = new Coordenada(4, 5);
		if (buque.calcularDistancia(coordenadaBuque) == 0) {
			buque.getTerminalGestionada().iniciarCargaDescarga(buque); //La terminal envia la señal para iniciar la carga/descarga
			buque.setEstado(this.proximoEstado);
		}
	}
}
	
