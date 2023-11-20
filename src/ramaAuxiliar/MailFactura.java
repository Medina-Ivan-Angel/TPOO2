package ramaAuxiliar;

public class MailFactura implements Mail {

	//Atributos
	private Factura factura;


	//Constructor
	public MailFactura(Factura factura) {
		this.factura = factura;
	}
	
	
	//Metodos
	
	
	//Getters and Setters
	public Factura getFactura() {
		return this.factura;
	}
	
}
