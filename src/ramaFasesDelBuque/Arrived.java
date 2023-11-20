package ramaFasesDelBuque;

public class Arrived implements Fases {

	public Arrived() {}
	
	
	/*
	 * No sé como modelar el hecho de que el buque reciba una señal, puede ser 
	 * un mail esa señal? que le llegue desde la terminal? 
	 * ambas coordenadas van a coincidir cuando el valor final de la coordenada 
	 * del buque sea la misma que el valor de la coordenada de la terminal de 
	 * destino, la cual, la coordenada de la terminal de destino siempre es la 
	 * misma, es decir, es constante, porque lo único que se mueve es el buque,
	 * la terminal se queda quieta en su lugar, además, la distancia entre puntos
	 * sería igual a cero (0).
	 * 
	 * */
	
	@Override 
	public void accion(buque Buque) {
		if (coordenadasDelBuqueYLaTerminalCoinciden()) {
			return recibeSeñalDeTerminalEiniciaCargaYDescarga();
		} else {
			return buque.setEstado(Working);
	}

}
