package ramaNavieraCircuitos;

public class Tramo {

	private Terminal origen;
	private Terminal destino;
	private double distanciaEntrePuertos; 
	private LocalTime duracionDelTramo;
	private double costoDelTramo;

	public Tramo(Terminal origen, Terminal destino, double distanciaEntrePuertos, LocalTime duracionDelTramo, 
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
	
	public double getCostoDelTramo() {
	
		return this.costoDelTramo;
	}

	public Terminal getOrigen() {
		return origen;
	}

	public Terminal getDestino() {
		return destino;
	}

	public double getDistanciaEntrePuertos() {
		return distanciaEntrePuertos;
	}

	public LocalTime getDuracionDelTramo() {
		return duracionDelTramo;
	}
	

}
