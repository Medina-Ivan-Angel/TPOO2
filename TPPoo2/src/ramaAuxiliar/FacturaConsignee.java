package ramaAuxiliar;

import java.time.LocalDateTime;

import ramaCliente.Cliente;

public class FacturaConsignee extends Factura {

	

	//Atributos
	
	
	//Constructor
	public FacturaConsignee(LocalDateTime fecha, Cliente cliente) {
		super(fecha, cliente);
	}
	
	//Metodos
	@Override
	public String imprimirCostosTramos() {
		
		return "Costo Total por tramos realizados: " + this.costoTotalTramos() + "\n";
	}

	@Override
	public String imprimirCostoTotal() {
		
		// sumamos el costo de los servicios y los tramos recorridos 
		double costoTotal =  this.costoTotalServicios() + this.costoTotalTramos();
		
		return "Monto Total : " + costoTotal + "\n";;
	}
	
	public double costoTotalTramos() {
		
		// Accedo a cliente.OrdenImportacion.buque.viajes.circuito.tramos y de ahi debo 
		// calcular el costo total de los tramos recorridos por el buque. TODO: Implementar Ignacio.
		return 0;
	}
	
	//Getters and Setters

}
