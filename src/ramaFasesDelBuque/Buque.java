package ramaFasesDelBuque;

import java.lang.Math;
import java.util.ArrayList;
import java.util.List;
import ramaDeposito.Container;
import ramaNavieraCircuitos.Viaje;
	
	public class Buque {
	
	// ATRIBUTOS:
	private Fase estado;
	private Viaje viaje;
	private Coordenada posicion;
	private List<Container> containers;
	
	// CONSTRUCTOR:
	public Buque(Fase estado, Viaje viaje, Coordenada posicion, Container containers) {
		this.viaje = viaje;
		this.estado = estado;
		this.posicion = posicion;
		this.containers = new ArrayList<Container>();
	}
	
	// MÉTODOS:
	
	/*
	 * El método calcularDistancia utiliza la fórmula matemática para 
	 * calcular la distancia entre 2 puntos en el plano, el primer punto 
	 * es una instancia del buque, y el otro punto es la terminal de destino
	 * */
	public double calcularDistancia(Coordenada coordenada) {
	
		// TODO: lo trato de implementar más adelante a medida que voy avanzando
		
		/*
		 * 
		 
		  
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
		 
		   int coordenadaBuqueX = coordenada.getValorX(); // X1
		   int coordenadaBuqueY = coordenada.getValorY(); // Y1
		   // Punto (X1; Y1) coordenadas del buque
		   
		   int coordenadaTerminalX = viaje.getTerminalDestino().getPosicion().getValorX(); // X2		   
		   int coordenadaTerminalY = viaje.getTerminalDestino().getPosicion().getValorY(); // y2
		   // Punto (X2; Y2) coordenadas de la terminal
		   
		   double distancia = Math.sqrt((Math.pow((coordenadaTerminalX - coordenadaBuqueX), 2) + Math.pow((coordenadaTerminalY - coordenadaBuqueY), 2))); 
		   
		    
		 return distancia;
		
	}
	
	public void darPreaviso() {
		/* TODO: enviar un mail de preaviso con un buque a la Terminal 
		 para que informe a los consignees */
		 
		 this.viaje.getTerminalDestino().recibirPreaviso(this);
	}
	
	public void darPostAviso() {
		/*
		 * TODO: enviar un mail a la terminal que le diga que el buque se está yendo.
		 * 
		 * */
		 this.viaje.getTerminalDestino().recibirPostAviso(this);
	}
		
	
	public void setEstado(Fase nuevoEstado) {
		this.estado = nuevoEstado;
	}
	
	public void estadoActual() {
	
		// TODO: ver que hacer acá, y ver de agregar el metodo para setearle cualquier coordenada al buque
	
		this.estado.accion(this);
		
	}
	
	// Esto lo envía como orden de salida la terminal.
	public void depart() {
		this.estado.accion(this);
	}
	
	 // El proceso de carga y descarga no será contemplado.
	 
	public void iniciarCargaYDescarga() {} 
		
	// GETTERS AND SETTERS:
	
	public Viaje getViaje() {
		return this.viaje;
	}
	
	public Coordenada getPosicion() {
		return this.posicion;
	}
	
	public List<Container> getContainers() {
		return this.containers;
	}

	
}
