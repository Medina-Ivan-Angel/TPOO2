package ramaCliente.Servicios;

import java.time.Duration;

import ramaDeposito.Reefer;

public class Electricidad implements Servicio {

	//ATRIBUTOS
	private Reefer reefer; 		// TODO: A implementar por victor
	private double precioPorKw;	// Precio por kw consumido
	private Duration duracion;  // Tiempo de consumo
	
	
	
	//CONSTRUCTOR
	public Electricidad(Reefer reefer, double precioPorKw, Duration duracion) {
		this.reefer = reefer;
		this.precioPorKw = precioPorKw;
		this.duracion = duracion;
	}
	
	
	//METODOS
	@Override
	public double costoTotal() {
		
		long tiempoDeConsumo = duracion.toHours(); //Obtengo el tiempo de consumo en horas
		
		return this.reefer.calcularConsumo(tiempoDeConsumo) * this.precioPorKw; //Segun cuanto haya consumido el reefer en el tiempo dado, se le cobra el precioPorKw consumido
	}

	//GETTERS AND SETTERS
	
}
