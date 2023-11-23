// Package de la clase.
package ramaDeposito;

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
	
}
