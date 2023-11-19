package ramaAuxiliar;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import ramaCliente.Cliente;
import ramaCliente.Servicios.Servicio;

public abstract class Factura {

	/*
	 * Esta clase es parte del patron Template method
	 * aqui se define el algoritmo principal y metodo hook.
	 */
	
	//Atributos
	private LocalDateTime fecha;
	private Cliente cliente;
	
	//CONSTRUCTOR
	public Factura(LocalDateTime fecha, Cliente cliente) {
		this.fecha = fecha;
		this.cliente = cliente;
	}
	
	
	
	//Metodos
	
	// TEMPLATE METHOD
	public String desgloce() {
		
		this.imprimirFecha();				//PASO 1
		this.imprimirServiciosYCostos();	//PASO 2
		this.imprimirCostosTramos();		//PASO 3 (hook method)
		this.imprimirCostoTotal();			//PASO 4 (hook method)
	}
	
	

	public String imprimirFecha() {
		
		return "Fecha " + this.fecha.toString() + "\n";
		
	}
	
	public String imprimirServiciosYCostos() {
		
		String salida = "";
		
		for(Servicio servicio : cliente.getOrden().getServicios() ){
			
			/* "servicio aplicado : costo del servicio"
			* Por ejemplo : 
			*"Lavado : 200$
			* Pesado : 100$
			* etc.
			*/
			salida = salida + servicio.getClass().getName() + " : " + servicio.costoTotal() + "\n";
			
		}
		
		return salida;
	}
	
	public abstract String imprimirCostosTramos(); // hook method
	
	
	public abstract String imprimirCostoTotal();   // hook method
	
	// Metodo auxiliar 
	public double costoTotalServicios() {
		
		double sumaCostoTotal = 0; // acumulador del costo de cada servicio.
		
		List<Servicio> serviciosDelCliente = this.getCliente().getOrden().getServicios();
		
		//Recorremos todos los servicios y acumulamos el costototal de cada uno.
		for(Servicio servicio : serviciosDelCliente ){
			
			sumaCostoTotal += servicio.costoTotal();
			
		}
		
		return sumaCostoTotal;
	}
	
	
	//Getters and Setters
	public Cliente getCliente() {
		return this.cliente;
	}
	
}
