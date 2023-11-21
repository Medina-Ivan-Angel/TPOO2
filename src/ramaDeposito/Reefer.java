// Package de la clase.
package ramaDeposito;

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
	

}
