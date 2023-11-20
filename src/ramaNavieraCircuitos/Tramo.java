package ramaNavieraCircuitos;
import java.time.LocalTime;	

public class Tramo {

	private Terminal origen;
	private Terminal destino;
	private double distanciaEntrePuertos; // lo calculo yo con la formula mepa
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
	
	// aca se tienen que ir agregando todos los getters y setters a medida que se necesiten
	
	public double getCostoDelTramo() {
	
		return this.costoDelTramo;
	
	}
	

}
