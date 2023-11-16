package ramaCliente;

public abstract class Cliente {

	
	//Atributos
	private Orden orden; //Orden de importacion/exportacion del cliente.
	
	//CONSTRUCTOR 
	public Cliente(Orden orden) {
		this.orden = orden;
	}
	
	
	//Metodos
	public Orden getOrden() {
		return this.orden;
	}
	
	
	public abstract Chofer informarChoferDesignado();
	
	public abstract Camion informarCamionDesignado();
	
	
	
	
	
	
}
