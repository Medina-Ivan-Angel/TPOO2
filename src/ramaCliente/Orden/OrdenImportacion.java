package ramaCliente.Orden;

import java.time.LocalDateTime;

import Terminal.TerminalNormal;
import ramaCliente.Cliente;
import ramaDeposito.Container;
import ramaFasesDelBuque.Buque;

public class OrdenImportacion extends Orden {
	
	/*
	 *  Esta Orden De Importacion es asignada
	 *  al Consignee correspondiente. Los atributos "Camion", "Chofer" y "fechaLlegadaDeCarga"
	 *  deben ser configurados por fuera del constructor (setters).
	 */
	
	//Atributos
	private TerminalNormal origen;				// Desde donde viene la carga
	private LocalDateTime fechaLlegadaDeCarga;	// Cuando (fecha) llega la carga
	private Buque buque; 						
	
	//Constructor
	public OrdenImportacion(Cliente cliente, 
							Container carga,
							TerminalNormal origen,
							Buque buque) {
		
		super(cliente, carga);
		this.origen = origen;
		this.buque  = buque;
	}
		
	//Metodos
		
		
	
	
	//Getters and Setters
	public void setFechaLlegadaDeCarga(LocalDateTime fechaLlegadaDeCarga) {
		this.fechaLlegadaDeCarga = fechaLlegadaDeCarga;
	}
		
	
	public LocalDateTime getfechaLlegadaDeCarga() {
		return this.fechaLlegadaDeCarga;
	}

	public TerminalNormal getOrigen() {
		return this.origen;
	}

	public Buque getBuque() {
		return this.buque;
	}
	
	
	
	
	
}
