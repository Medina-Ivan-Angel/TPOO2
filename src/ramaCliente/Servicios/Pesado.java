package ramaCliente.Servicios;

public class Pesado implements Servicio {

	//ATRIBUTOS
	private double costoFijo;
	private Container container;
	
	//CONSTRUCTOR
	public Pesado(double costoFijo, Container container) {
		this.costoFijo = costoFijo;
		this.container = container;
	}
	
	
	//METODOS
	@Override
	public double costoTotal() {
		
		return this.costoFijo;
	}

	//Este metodo sera utilizado por la terminal para registrar el peso del container.
	public double pesarContainer() {
		return this.container.getPesoTotal();
	}
	
	
	
	//GETTERS AND SETTERS

}
