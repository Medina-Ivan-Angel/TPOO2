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
	
	
	/*
	 * Este método calcula el costo total de un viaje sumando los costos individuales 
	 * de todos los tramos que componen a un circuito. No se le pasa ningún parámetro, 
	 * porque Viaje conoce a la clase Circuito, por lo tanto puede acceder a su 
	 * lista de tramos por medio de su getter particular.
	 * */
	public double costoDelViaje() {
	
		List<Tramo> tramos = Circuito.getTramos();
		
		return tramos.stream()
					 .mapToDouble(Tramo::getCostoDelTramo)
					 .sum();
	}
	

}