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
			recibeSeñalDeTerminalEiniciaCargaYDescarga(); // TODO: BUSCAR METODO EN CODIGO DE IVAN
			buque.setEstado(this.proximoEstado);
		}
	}
}
	
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

