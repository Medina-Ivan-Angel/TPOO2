package ramaCliente.Servicios;

public class AlmacenamientoExcedente implements Servicio {

	//ATRIBUTOS
	private double costoPorDia; // costo por cada dia de almacenamiento
	private double dias;        // dias de almacenamiento
	
	
	//CONSTRUCTOR
	
	public AlmacenamientoExcedente(double costoPorDia, double dias) {
		this.costoPorDia = costoPorDia;
		this.dias = dias;
	}


	//METODOS
	@Override
	public double costoTotal() {
		
		return this.dias * this.costoPorDia;
	}


	
}
