package ramaCliente.Orden;

import java.time.LocalDateTime;

public class OrdenImportacion extends Orden {
	
	/*
	 *  Esta Orden De Importacion es asignada
	 *  al Consignee correspondiente. Los atributos "Camion" y "Chofer"
	 *  deben ser configurados por fuera del constructor (setters).
	 */
	
	//Atributos
	private TerminalPortuaria origen;			// Desde donde viene la carga
	private LocalDateTime fechaLlegadaDeCarga;	// Cuando (fecha) llega la carga
	private Buque buque; 						// TODO: A implementar por Ignacio
	
	//Constructor
	public OrdenImportacion(Cliente cliente, 
							Container carga,
							TerminalPortuaria origen,
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
		
	
	
	
	
	
	
	
}
