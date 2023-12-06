package ramaCliente.Orden;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import Terminal.TerminalNormal;
import ramaCliente.Cliente;
import ramaCliente.Consignee;
import ramaDeposito.Container;
import ramaDeposito.EmpresaDeTransporte;
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

	//Constructor
	public OrdenImportacion(Consignee cliente, 
							Container carga,
							TerminalNormal origen,
							Buque buque, 
							EmpresaDeTransporte empresaDeTransporte) {
		
		super(cliente, carga, empresaDeTransporte, buque);
		this.origen = origen;
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
	
	
}
