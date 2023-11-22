package ramaCliente.Servicios;

import ramaDeposito.Container;

public class Lavado implements Servicio {

	//ATRIBUTOS
	private Container container;
	private double costoInferior;
	private double costoSuperior;
	
	//CONSTRUCTOR
	public Lavado(Container container, double costoInferior, double costoSuperior) {
		
		this.container 	   = container;
		this.costoInferior = costoInferior;
		this.costoSuperior = costoSuperior;

	}
	
	//METODOS
	@Override
	public double costoTotal() {
		
		if(this.calcularVolumen() > 70) {
			return this.costoSuperior;
		}else {
			return this.costoInferior;
		}
		
	}
	
	

	public double calcularVolumen() {
		
		return this.container.getAncho() * this.container.getLargo() * this.container.getAltura();
		
	}
	
	//Getters and Setters
	
}
