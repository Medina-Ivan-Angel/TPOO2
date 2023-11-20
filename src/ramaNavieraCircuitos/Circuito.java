package ramaNavieraCircuitos;
import java.util.List;
import java.util.List.*;



public class Circuito {
	
	private List<Tramo> tramos;
	
	public Circuito(List<Tramo> tramos) {
		this.tramos = tramos;
	}
	
	public List<Tramo> getTramos() {
		return this.tramos;
	}
	
	public void setTramos(List<Tramo> tramos) {
		this.tramos = tramos;
	}
	
	public void agregarTramo(Tramo tramo) {
		this.tramos.add(tramo);
	}

}
