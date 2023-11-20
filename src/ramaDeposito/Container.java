package ramaDeposito;

public abstract class Container {

	// Atributos.
	private double ancho;
	private double altura;
	private double largo;
	private double pesoTotal;
	
	// Constructor.
	public Container(double ancho, double altura, double largo, double pesoTotal) {
		this.altura = altura;
		this.ancho = ancho;
		this.largo = largo;
		this.pesoTotal = pesoTotal;
	}
	
}
