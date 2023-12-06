package ramaFasesDelBuque;

import java.lang.Math;
import java.util.ArrayList;
import java.util.List;

import Terminal.TerminalNormal;
import ramaDeposito.Container;
import ramaNavieraCircuitos.Viaje;
	
	public class Buque {
	
	// ATRIBUTOS:
	private Fase estado;
	private Viaje viaje;
	private Coordenada posicion;
	private List<Container> containers;
	private TerminalNormal terminalGestionada;
	
	// CONSTRUCTOR:
	public Buque(Fase estado, Viaje viaje, Coordenada posicion,
				 List<Container> containers, TerminalNormal terminalGestionada) {
				 
		this.viaje = viaje;
		this.estado = estado;
		this.posicion = posicion;
		this.containers = containers;
		this.terminalGestionada = terminalGestionada;
	}
	
	// MÉTODOS:
	
	/*
	 * El método calcularDistancia utiliza la fórmula matemática para 
	 * calcular la distancia entre 2 puntos en el plano, el primer punto 
	 * es una instancia del buque, y el otro punto es la terminal de destino
	 * */
	public double calcularDistancia(Coordenada coordenada) {
		 
		   int coordenadaBuqueX = this.posicion.getValorX(); // X1
		   int coordenadaBuqueY = this.posicion.getValorY(); // Y1
		   // Punto (X1; Y1) coordenadas del buque
		   
		   int coordenadaDestinoX = coordenada.getValorX(); // X2		   
		   int coordenadaDestinoY = coordenada.getValorY(); // y2
		   // Punto (X2; Y2) coordenadas del destino del buque
		   
		   double distancia = Math.sqrt((Math.pow((coordenadaDestinoX - coordenadaBuqueX), 2) + Math.pow((coordenadaDestinoY - coordenadaBuqueY), 2))); 
		   
		    
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
	
	public void estadoActual() {
	
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
	
	public void setPosicion(Coordenada posicion) {
		this.posicion = posicion;
	}
	
	public List<Container> getContainers() {
		return this.containers;
	}

	public Fase getEstado() {
		return this.estado;
	}
	
	public void setEstado(Fase nuevoEstado) {
		this.estado = nuevoEstado;
	}
	
	public TerminalNormal getTerminalGestionada() {
		return this.terminalGestionada;
	}

	
}
