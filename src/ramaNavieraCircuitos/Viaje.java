package ramaNavieraCircuitos;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import Terminal.TerminalNormal;

public class Viaje {
	
	private LocalDateTime fechaDeSalida;
	private Circuito circuitoARecorrer;
	private TerminalNormal terminalDestino;
	private TerminalNormal terminalOrigen;
	

	private LocalDateTime fechaLlegadaADestino;
	
	public Viaje(LocalDateTime fechaDeSalida, Circuito circuitoARecorrer, 
			     TerminalNormal terminalDestino, LocalDateTime fechaLlegadaADestino) {
			     
		this.fechaDeSalida        = fechaDeSalida;
		this.circuitoARecorrer    = circuitoARecorrer;
		this.terminalDestino 	  = terminalDestino;
		this.fechaLlegadaADestino = fechaLlegadaADestino;
	}
	
	
	/*
	 * Este método calcula el costo total de un viaje sumando los costos individuales 
	 * de todos los tramos que componen a un circuito. No se le pasa ningún parámetro, 
	 * porque Viaje conoce a la clase Circuito, por lo tanto puede acceder a su 
	 * lista de tramos por medio de su getter particular.
	 * */
	public double costoDelViaje() {
	
		List<Tramo> tramos = circuitoARecorrer.getTramos();
		
		return tramos.stream()
					 .mapToDouble(Tramo::getCostoDelTramo)
					 .sum();
	}
	
	// GETTERS Y SETTERS:
	
	public TerminalNormal getTerminalDestino() {
		return this.terminalDestino;
	}
	
	public LocalDateTime getFechaDeSalida() {
	
		return this.fechaDeSalida;
			
	}
	
	public Circuito getCircuitoARecorrer() {
		return this.circuitoARecorrer;
	}


	public LocalDateTime getFechaLlegadaADestino() {
		return fechaLlegadaADestino;
	}
	
	public TerminalNormal getTerminalOrigen() {
		return terminalOrigen;
	}

}
