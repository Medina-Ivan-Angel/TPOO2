package ramaFasesDelBuque;

public class Buque {
	
	private Fases estado;

	public Buque(Fases estado) {

		this.estado = estado;
	}
	
	public int calcularDistancia(Coordenada coordenada) {
	
		// TODO: lo trato de implementar más adelante a medida que voy avanzando
		
		/*
		 * 
		 * double coordenadaX = coordenada.getValorX();
		   double coordenadaY = coordenada.getValorY(); 
		  
		   voy a utilizar la formula de distancia entre puntos de una funcion lineal, 
		   tomamos a la terminal gestionada como el origen, el punto (0,0) 
		   del eje cartesiano, despues, el buque se va a mover según nosotros 
		   necesitemos, según el estado actual del mismo, y finalmente, 
		   voy a calcular la distancia entre el punto A que es el Buque una vez que 
		   zarpó, y la terminal Destino, qu sería el punto B, y listo. 
		   además después vamos a agregar el metodo al buque para setearle las 
		   coordenadas que precisemos.
		   ahora mergeo
		   
		 * */
		 
		 return 0;
		
	}
	
	public String darPreaviso() {
		// TODO: todavía no sé bien que hace
	}
	
		
	
	public void setEstado(Fases nuevoEstado) {
		this.estado = nuevoEstado;
	}
	
	public void estadoActual() {
	
		// TODO: ver que hacer acá, y ver de agregar el metodo para setearle cualquier coordenada al buque
	
		this.estado.accion(this);
		
	}
		
}
