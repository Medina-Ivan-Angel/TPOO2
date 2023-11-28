package ramaAuxiliar;

import java.time.LocalDateTime;


import ramaCliente.Cliente;
import ramaCliente.Servicios.Servicio;

public class FacturaShipper extends Factura {

	//Atributos
	
	
	//Constructor
	public FacturaShipper(LocalDateTime fecha, Cliente cliente) {
		super(fecha, cliente);
	}
	
	//Metodos
	@Override
	public String imprimirCostosTramos() {
		/*Retornamos un string vacio porque el Shipper
		* envia carga en un buque que ya esta en puerto.
		* Por ende no se necesitan calcular costos de viaje.
		*/
		return ""; 
	}

	@Override
	public String imprimirCostoTotal() {
		
		return "Monto Total : " + this.costoTotalServicios() + "$\n";
		
	}
	
	
	
	//Getters and Setters

}
