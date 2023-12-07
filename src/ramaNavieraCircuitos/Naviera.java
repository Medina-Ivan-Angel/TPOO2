package ramaNavieraCircuitos;
import java.util.List;
import java.util.ArrayList;

import ramaFasesDelBuque.*;



public class Naviera {

	private List<Buque> flota;
	private List<Circuito> circuitosMaritimos;
	

	public Naviera(List<Buque> flota, List<Circuito> circuitosMaritimos) {
		this.flota = new ArrayList<Buque>();
		this.circuitosMaritimos = new ArrayList<Circuito>();
	}
	
	/*
	 * Se crearon los getters y setters para ambos atributos de esta clase, 
	 * porque se van a utilizar al momento de realizar los tests.
	 * Además, por la manera en la que se inicializaron las listas, 
	 * se va a agregar cada elemento de forma individual a cada una de ellas, 
	 * en el apartado setUp de cada uno de los tests en las que se utilicen.
	 * */
	
	
	public List<Buque> getFlota() {
		return this.flota;
	}
	
	public void setFlota(List<Buque> flota) {
		this.flota = flota;
	}
	
	public List<Circuito> getCircuitosMaritimos() {
		return this.circuitosMaritimos;
	}
	
	public void setCircuitosMaritimos(List<Circuito> circuitosMaritimos) {
		this.circuitosMaritimos = circuitosMaritimos;
	}
	
	public void agregarBuque(Buque buque) {
		this.flota.add(buque);
	}
	
	public void agregarCircuito(Circuito circuito) {
		this.circuitosMaritimos.add(circuito);
	}
}
