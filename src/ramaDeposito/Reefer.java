// Package de la clase.
package ramaDeposito;

import java.time.Duration;
import java.time.LocalDateTime;

import ramaCliente.Orden.Orden;
import ramaCliente.Orden.OrdenExportacion;
import ramaCliente.Servicios.Electricidad;

public class Reefer extends Container{

	// Atributos.
	private double consumo;
	
	
	// Constructor
	public Reefer(double ancho, double altura, double largo, double pesoTotal, double consumo) {
		this.altura = altura;
		this.ancho = ancho;
		this.largo = largo;
		this.pesoTotal = pesoTotal;
		this.consumo = consumo;
	}
	
	
	// Metodos.
		// Getter.
	public double getConsumo() {
		return(this.consumo);
	}
	
	public double calcularConsumo(double tiempo) {
		return(this.consumo * tiempo);
	}
	
	@Override
	public void aplicarElectricidad(OrdenExportacion orden, 
			double precioPorKw, LocalDateTime hra) {
		
		Duration duracion = Duration.between(
				hra, orden.getFechaSalidaDeCarga());
	
		orden.addServicio(new Electricidad(
				this, precioPorKw, duracion));
	}

}
