package ramaNavieraCircuitos;

import Terminal.TerminalNormal;

public class Tramo {

	private TerminalNormal origen;
	private TerminalNormal destino;
	private double distanciaEntrePuertos; 
	private double duracionDelTramo;
	private double costoDelTramo;

	public Tramo(TerminalNormal origen, TerminalNormal destino, double distanciaEntrePuertos, double duracionDelTramo, 
				 double costoDelTramo) {
		this.origen = origen;
		this.destino = destino;
		this.distanciaEntrePuertos = distanciaEntrePuertos;
		this.duracionDelTramo = duracionDelTramo;
		this.costoDelTramo = costoDelTramo;
	}
	
	/*
	 * Se crearon sólamente los getters de todos los atributos de esta clase porque 
	 * van a ser utilizados con frecuencia por otras clases relacionadas.
	 * Los setters no se generaron porque las instancias de Tramo se crean, y se 
	 * les asignan valores constantes.
	 * */

	public TerminalNormal getOrigen() {
		return origen;
	}

	public TerminalNormal getDestino() {
		return destino;
	}
	
	public double getCostoDelTramo() {
	
		return this.costoDelTramo;
	}

	public double getDistanciaEntrePuertos() {
		return distanciaEntrePuertos;
	}

	public double getDuracionDelTramo() {
		return duracionDelTramo;
	}
	
}
