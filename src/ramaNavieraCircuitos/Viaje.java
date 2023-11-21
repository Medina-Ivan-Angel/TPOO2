package ramaNavieraCircuitos;

import java.time.LocalDate;
import java.util.List;

public class Viaje {
	
	private LocalDate fechaDeSalida;
	private Circuito circuitoARecorrer;
	private Terminal terminalDestino;
	
	
	public Viaje(LocalDate fechaDeSalida, Circuito circuitoARecorrer, 
			     Terminal terminalDestino) {
			     
		this.fechaDeSalida = fechaDeSalida;
		this.circuitoARecorrer = circuitoARecorrer;
		this.terminalDestino = terminalDestino;
	}
	
	public double costoDelViaje(List<Tramo> tramos) {
	
		return tramos.stream()
					 .mapToDouble(Tramo::getCostoDelTramo)
					 .sum();
	}
	
	// GETTERS Y SETTERS:
	
	public Terminal getTerminalDestino() {
		return this.terminalDestino;
	}
	

}
