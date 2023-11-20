package ramaFasesDelBuque;

public class Departing implements Fases {

	public Departing() {}
	
	
	/*
	 * En esta funcion, cuando el buque se aleja a mas de 1 km de la terminal 
	 * cuando se vá, enseguida le notifica a la terminal, no sé si esa notificación
	 * tiene que ser un nuevo metodo para el buque, o si puedo repetir de nuevo 
	 * el metodo darPreaviso(). Además, en seguida tiene que cambiar de fase, 
	 * por eso hice los 2 en el mismo bloque de código.
	 * */
	
	@Override
	public void accion(Buque buque) {
		if (distanciaDelBuqueALaTerminal > 1) {
			 buque.darPreaviso();
 			 return buque.setEstado(Outbound);
		}			
			

}
