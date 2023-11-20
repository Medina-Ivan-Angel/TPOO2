package ramaNavieraCircuitos;
import java.util.List.*;
import java.util.ArrayList.*;
import java.util.List;



public class Naviera {

	private List<Buque> flota;
	private List<Circuito> circuitosMaritimos;


	public Naviera(List<Buque> flota, List<Circuito> circuitosMaritimos) {
		this.flota = flota;
		this.circuitosMaritimos = circuitosMaritimos;
	}
	
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
