// Package de la clase.
package ramaDeposito;

import java.time.LocalDateTime;

import ramaCliente.Orden.Orden;
import ramaCliente.Orden.OrdenExportacion;

public abstract class Container {

	// Atributos.
	protected double ancho;
	protected double altura;
	protected double largo;
	protected double pesoTotal;
	
	// Metodos.
		// Getter.
	public double getPeso() {
		return(this.pesoTotal);
	}
	
	public double getAncho() {
		return(this.ancho);
	}
	
	public double getAltura() {
		return(this.altura);
	}
	
	public double getLargo(){
		return(this.largo);
	}
	
	public void aplicarElectricidad(OrdenExportacion orden,
			double precioPorKw, 
			LocalDateTime hra){
		
	}
	
}
