package ramaCliente.Orden;

import java.time.LocalDateTime;

import Terminal.TerminalNormal;
import ramaCliente.Cliente;
import ramaDeposito.Camion;
import ramaDeposito.Chofer;
import ramaDeposito.Container;

public class OrdenExportacion extends Orden {
	
	/*
	 *  Esta Orden De Exportacion es asignada
	 *  al Shipper correspondiente
	 */
	
	
	
	//Atributos
	private TerminalNormal destino;				// Hacia donde va la carga
	private LocalDateTime fechaSalidaDeCarga;	// Cuando (fecha) sale la carga
	private LocalDateTime fechaLlegadaADestino;	// Cuando (fecha) llega la carga
	
	//Constructor
	public OrdenExportacion(TerminalNormal destino,
							LocalDateTime fechaSalidaDeCarga,
							LocalDateTime fechaLlegadaADestino,
							Cliente cliente,
							Container carga,
							Camion camion,
							Chofer chofer) {
		
		super(cliente, carga, camion, chofer);
		this.destino 			  = destino;
		this.fechaSalidaDeCarga   = fechaSalidaDeCarga;
		this.fechaLlegadaADestino = fechaLlegadaADestino;
		
		
	}
	
	//Metodos
	
	
	//Getters and Setters
	public TerminalNormal getDestino() {
		return this.destino;
	}
	
	public LocalDateTime getFechaSalidaDeCarga() {
		return this.fechaSalidaDeCarga;
	}
	
	public LocalDateTime getFechaLlegadaADestino() {
		return this.fechaLlegadaADestino;
	}
	
	
	
	
	
	
}
